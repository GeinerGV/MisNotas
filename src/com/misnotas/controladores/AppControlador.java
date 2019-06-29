package com.misnotas.controladores;

import java.awt.event.ActionEvent;

import com.misnotas.interfaces.ControladorVista;
import com.misnotas.interfaces.ModeloControlador;
import com.misnotas.interfaces.VistaControlador;

/**
 * AppControlador
 */
public class AppControlador implements ControladorVista {

    private VistaControlador vista;
    private ModeloControlador modelo;

    public void setVista(VistaControlador vista) {
        this.vista = vista;
    }

    public void setModelo(ModeloControlador modelo) {
        this.modelo = modelo;
    }

    // TODO: IMPLEMENTACIÓN CONTROLADOR

    @Override
    public void onBtnLeftSelect(String name) {
        System.out.println(name);
    }

    
}