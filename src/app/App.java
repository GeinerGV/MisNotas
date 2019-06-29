package app;

import java.awt.Color;
import java.net.URL;

import javax.swing.SwingUtilities;

import com.misnotas.controladores.AppControlador;
import com.misnotas.modelos.AppModelo;
import com.misnotas.vistas.AppFrame;

public class App {
    public static void main(String[] args) throws Exception {
        AppControlador controlador = new AppControlador();
        AppModelo modelo = new AppModelo();
        controlador.setModelo(modelo);
        AppFrame vista = new AppFrame(controlador, modelo);
        controlador.setVista(vista);
        modelo.setVista(vista);
        System.out.println("Hello Geiner");
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                vista.ejecutar();
            }
        });
    }

    public static URL getURLIcon(String iconName) {
        return App.class.getResource(ICONS_PATH + iconName);
    }


    public static final String ICONS_PATH = "assets/icons/";
    public static final Color LIGTH_COLOR = new Color(255, 229, 229);
}