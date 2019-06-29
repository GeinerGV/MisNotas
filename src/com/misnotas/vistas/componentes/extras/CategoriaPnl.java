package com.misnotas.vistas.componentes.extras;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import app.App;

/**
 * CategoriaPnl
 */
public class CategoriaPnl extends JPanel {

    private jPcatTitle jTitle;
    private JScrollPane jPnlCnt = new JScrollPane();

    public CategoriaPnl(String title) {
        super();
        jTitle = new jPcatTitle(title);
        
        jTitle.setBackground(App.LIGTH_COLOR.darker());
        add(jTitle, BorderLayout.NORTH);
        add(jPnlCnt, BorderLayout.CENTER);
    }
}