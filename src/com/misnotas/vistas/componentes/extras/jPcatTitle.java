package com.misnotas.vistas.componentes.extras;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.App;

/**
 * jPcatTitle
 */
public class jPcatTitle extends JPanel {
    private static final int PAD_TITLE = 5;
    private static final int ICO_SIZE = 12;
    private static final String ICO_NAME = "icons8-right-button-24.png";
    private static final String ICO_DSC = "Dropdown";

    // private String title;
    private JLabel jLTitle;
    private ImageIcon icoDef;
    public jPcatTitle(String title2) {
        super();
        // this.title = title;
        jLTitle = new JLabel(title2.toUpperCase());
        if (App.getURLIcon(ICO_NAME) != null) {
            icoDef = new ImageIcon(App.getURLIcon(ICO_NAME));
            icoDef = new ImageIcon(icoDef.getImage().getScaledInstance(ICO_SIZE, ICO_SIZE, Image.SCALE_DEFAULT), ICO_DSC);
            jLTitle.setIcon(icoDef);
        }
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        add(jLTitle);
        /* setLayout(new GridBagLayout());
        setBackground(App.LIGTH_COLOR.darker());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 1.0;
        c.weightx = 1.0;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(PAD_TITLE, PAD_TITLE, PAD_TITLE, 0);
        add(jLTitle, c); */
    }
}