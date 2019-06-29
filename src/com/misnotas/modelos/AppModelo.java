package com.misnotas.modelos;

import com.misnotas.interfaces.ModeloControlador;
import com.misnotas.interfaces.ModeloVista;
import com.misnotas.interfaces.VistaModelo;

/**
 * AppModelo
 */
public class AppModelo 
    implements ModeloControlador, ModeloVista{

    private VistaModelo vista;
    public void setVista(VistaModelo vista) {
        this.vista = vista;
    }
    
    // TODO: IMPLEMENTACIÓN MODELO

    @Override
    public int getPosBtnLeftSelected() {
        return 0;
    }

    @Override
    public void setPosBtnLeftSelected(int pos) {

    }

    
}