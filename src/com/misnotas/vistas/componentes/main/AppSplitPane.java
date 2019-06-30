package com.misnotas.vistas.componentes.main;

import javax.swing.JSplitPane;

import com.misnotas.vistas.componentes.base.PnlLeftSplitPane;
import com.misnotas.vistas.componentes.base.PnlRightSplitPane;

/**
 * AppSplitPane
 */
public class AppSplitPane extends JSplitPane {
    private PnlLeftSplitPane panelLeft = new PnlLeftSplitPane();
    private PnlRightSplitPane panelRight = new PnlRightSplitPane();

    public AppSplitPane() {
        super(JSplitPane.HORIZONTAL_SPLIT, true);
        setLeftComponent(panelLeft);
        setRightComponent(panelRight);
    }
}