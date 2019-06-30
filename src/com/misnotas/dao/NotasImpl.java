package com.misnotas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.misnotas.dto.CarreraDTO;
import com.misnotas.dto.MallaDTO;

/**
 * NotasImpl
 */
public class NotasImpl {

    Connection conn = null;
    String url = "jdbc:mysql://mysql.freehostia.com/geigra_gegeve";

    public NotasImpl() {
        try {
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
		} catch ( Exception e) {
			System.out.println("No se pudo cargar el driver");
		}
    }

    private Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url, "geigra_gegeve", "RaW:XT.r!cH=pVovd6d'");
		} catch (SQLException e) {
			System.out.println("No se pudo otener conexion");
			e.printStackTrace();
		}
		return conn;
    }
    
    public List getCarreras(String nombre) {
        PreparedStatement stmt = null;
		ResultSet rs;
        ArrayList<CarreraDTO> carreras = new ArrayList<CarreraDTO>();
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT C.idCarrera, C.nombre, M.idMalla, M.periodoInicial, M.periodoFinal ");
        sql.append(" FROM Carrera C, Malla M ");
        sql.append(" WHERE M.Carrera_idCarrera = C.idCarrera AND C.nombre LIKE CONCAT(?, '%'); ");
        //String sql = "SELECT C.idCarrera, C.nombre FROM Carrera C WHERE nombre like CONCAT(?, '%');";

        try {
            this.getConnection();
			stmt = conn.prepareStatement(sql.toString());
            stmt.setString(1, nombre);
            rs = stmt.executeQuery();
            while ( rs.next() ) {
                CarreraDTO c = new CarreraDTO();
                MallaDTO m = new MallaDTO();
                m.setIdMalla(rs.getInt(3));
                m.setPeriodoInicial(rs.getString(4));
                m.setPeriodoFinal(rs.getString(5));
                Boolean save = true;
                for (CarreraDTO carrera : carreras) {
                    if (carrera.getIdCarrera() == rs.getInt(1)) {
                        save = false;
                        carrera.addMalla(m);
                        break;
                    }
                }
                if (save) {
                    c.setIdCarrera(rs.getInt(1));
                    c.setNombre(rs.getString(2));
                    c.addMalla(m);
                    carreras.add(c);
                }
            }
            
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return carreras;
    }
}