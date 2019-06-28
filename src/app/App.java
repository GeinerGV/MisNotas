package app;

import java.net.URL;

import javax.swing.SwingUtilities;

import com.misnotas.vistas.AppFrame;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Geiner");
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AppFrame().ejecutar();
            }
        });
    }

    public static URL getURLIcon(String iconName) {
        return App.class.getResource(ICONS_PATH + iconName);
    }


    public static final String ICONS_PATH = "assets/icons/";
}