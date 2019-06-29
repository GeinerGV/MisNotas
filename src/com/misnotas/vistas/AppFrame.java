package com.misnotas.vistas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

import com.misnotas.vistas.componentes.main.AppSplitPane;
import com.misnotas.vistas.componentes.main.AppToolbarBottom;
import com.misnotas.vistas.componentes.main.AppToolbarLeft;

/**
 * AppFrame
 */
public class AppFrame extends JFrame {

    public static final String APP_NAME = "Mis Notas";
    public static final int MIN_SIZE = 300;

    public AppFrame() {
        super();
        setTitle(APP_NAME);
        setMinimumSize(new Dimension(MIN_SIZE, MIN_SIZE));
        initComponents();
    }

    public void initComponents() {
        appSplitPane = new AppSplitPane();
        appToolbarBottom = new AppToolbarBottom();
        appToolbarLeft = new AppToolbarLeft();
        Container contenedor = getContentPane();
        contenedor.add(appSplitPane, BorderLayout.CENTER);
        contenedor.add(appToolbarBottom, BorderLayout.SOUTH);
        contenedor.add(appToolbarLeft, BorderLayout.WEST);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        pack();
    }

    public void ejecutar() {
        setVisible(true);
    }

    private AppSplitPane appSplitPane;
    private AppToolbarBottom appToolbarBottom;
    private AppToolbarLeft appToolbarLeft;
}