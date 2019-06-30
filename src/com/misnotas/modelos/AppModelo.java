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

    private int posBtnleftSelected = 0;
    private String nameBtnleftSelected = "Buscar";
    
    // TODO: IMPLEMENTACIÓN MODELO

    @Override
    public int getPosBtnLeftSelected() {
        return posBtnleftSelected;
    }

    @Override
    public void setPosBtnLeftSelected(int pos) {
        posBtnleftSelected = pos;
        vista.onBtnLeftSelectedChange();
    }

    @Override
    public String getNameBtnLeftSelected() {
        return nameBtnleftSelected;
    }

    @Override
    public void setNameBtnLeftSelected(String name) {
        nameBtnleftSelected = name;
    }
}