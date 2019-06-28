package com.misnotas.vistas.componentes.main;

import java.awt.Panel;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 * AppSplitPane
 */
public class AppSplitPane extends JSplitPane {
    private JPanel panelLeft;
    private JPanel panelRight;

    public AppSplitPane() {
        super(JSplitPane.HORIZONTAL_SPLIT, true);
        setLeftComponent(new Panel());
        setRightComponent(new Panel());
    }
}