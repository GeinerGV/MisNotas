package com.misnotas.vistas.componentes.extras;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.BoxLayout;
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
    private JScrollPane jPnlCnt;

    public CategoriaPnl(String title, JPanel panel) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        jTitle = new jPcatTitle(title);
        
        jTitle.setBackground(App.LIGTH_COLOR.darker());
        add(jTitle);

        /* JPanel jp = new JPanel();
        jp.add(jPnlCnt, BorderLayout.CENTER); */
        jPnlCnt = new JScrollPane(panel);
        add(jPnlCnt);
    }
}