package com.misnotas.vistas.componentes.base;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.misnotas.vistas.componentes.extras.CategoriaPnl;

import app.App;

/**
 * PnlBuscar
 */
public class PnlBuscar extends JPanel {

    public PnlBuscar() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JPanel inputSearch = new JPanel(new GridBagLayout());
        inputSearch.setMaximumSize(new Dimension(Short.MAX_VALUE, 70));
        GridBagConstraints c = new GridBagConstraints();
        JTextField input = new JTextField();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 10, 0);
        inputSearch.add(input, c);
        ImageIcon ico = new ImageIcon(App.getURLIcon("icons8-search-50.png"));
        ico = new ImageIcon(ico.getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT));
        JButton btn = new JButton(ico);
        c.gridx = 1;
        c.insets = new Insets(10, 0, 10, 10);
        inputSearch.add(btn, c);

        btn.setMaximumSize(new Dimension(60, Short.MAX_VALUE));

        add(new CategoriaPnl("Resultados", new JPanel()));
    }
}