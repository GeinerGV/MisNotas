package com.misnotas.vistas.componentes.main;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.misnotas.vistas.componentes.base.BtnToolBarLeft;

/**
 * AppToolbarLeft
 */
public class AppToolbarLeft extends JPanel {

    private static final int DISTANCE_BTW_BTNS = 15;

    private String[][] btnsInfo = new String[][] {
        {"Explorador", "icons8-windows-explorer-50.png"},
        {"Buscar", "icons8-search-50.png"}
    };

    private boolean[] btnsAdded;
    
    public AppToolbarLeft() {
        super();
        btnsAdded = new boolean[btnsInfo.length];
        for (int i = 0; i < btnsAdded.length; i++) {
            btnsAdded[i] = false;
        }
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(Box.createRigidArea(new Dimension(0, DISTANCE_BTW_BTNS)));
        createNewBtn(0);
        createNewBtn(1);

        setBackground(new Color(255, 255, 255));
    }

    public void createNewBtn(int pos) {
        if (pos<btnsAdded.length) {
            if (!btnsAdded[pos]) {
                add(new BtnToolBarLeft(btnsInfo[pos][0], btnsInfo[pos][1]));
                add(Box.createRigidArea(new Dimension(0, DISTANCE_BTW_BTNS)));
            }
        }
    }
}