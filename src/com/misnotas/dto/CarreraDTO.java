package com.misnotas.dto;

import java.util.ArrayList;

/**
 * CarreraDTO
 */
public class CarreraDTO {

    private int idCarrera;
    private String nombre;
    private ArrayList<MallaDTO> mallas = new ArrayList<MallaDTO>();

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<MallaDTO> getMallas() {
        return mallas;
    }

    public void setMallas(ArrayList<MallaDTO> mallas) {
        this.mallas = mallas;
    }

    public void addMalla(MallaDTO malla) {
        this.mallas.add(malla);
    }

    
}