package com.misnotas.vistas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.misnotas.interfaces.ControladorVista;
import com.misnotas.interfaces.ModeloVista;
import com.misnotas.interfaces.VistaControlador;
import com.misnotas.interfaces.VistaModelo;
import com.misnotas.vistas.componentes.base.PnlLeftSplitPane;
import com.misnotas.vistas.componentes.main.AppSplitPane;
import com.misnotas.vistas.componentes.main.AppToolbarBottom;
import com.misnotas.vistas.componentes.main.AppToolbarLeft;

/**
 * AppFrame
 */
public class AppFrame extends JFrame
    implements VistaControlador, VistaModelo {

    public static ControladorVista controlador;

    public static ModeloVista modelo;

    public static AppFrame vista;

    public void setControlador(ControladorVista controlador) {
        this.controlador = controlador;
    }

    public void setModelo(ModeloVista modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the modelo
     */
    public ModeloVista getModelo() {
        return modelo;
    }

    /**
     * @return the controlador
     */
    public ControladorVista getControlador() {
        return controlador;
    }

    /* public static ModeloVista getModelo(JComponent ele) {
        return ((AppFrame) ele.getRootPane().getParent()).getModelo();
    } */

    /**
     * @return the controlador
     */
    /* public ControladorVista getControlador(JComponent ele) {
        return ((AppFrame) ele.getRootPane().getParent()).getControlador();
    } */


    public static final String APP_NAME = "Mis Notas";
    public static final int MIN_SIZE = 300;

    public AppFrame(ControladorVista controlador, ModeloVista modelo) {
        super();
        setControlador(controlador);
        setModelo(modelo);
        vista = this;
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
        setTitle(APP_NAME);
        setMinimumSize(new Dimension(MIN_SIZE, MIN_SIZE));
        initComponents();
        setVisible(true);
    }

    private AppSplitPane appSplitPane;
    private AppToolbarBottom appToolbarBottom;
    private AppToolbarLeft appToolbarLeft;

    private JPanel openFiles;

    /**
     * @param openFiles the openFiles to set
     */
    public void setOpenFiles(JPanel openFiles) {
        this.openFiles = openFiles;
    }

    // TODO: IMPLEMENTACIÓN VISTA

	@Override
	public void onBtnLeftSelectedChange() {
        ((PnlLeftSplitPane)appSplitPane.getLeftComponent()).selectPane(modelo.getPosBtnLeftSelected());
        this.validate();
	}

	@Override
	public int getPosBtnLeftSelected(String name) {
		switch (name.trim().toLowerCase()) {
            case "buscar":
                return 1;
            default:
                return 0;
        }
    }
}