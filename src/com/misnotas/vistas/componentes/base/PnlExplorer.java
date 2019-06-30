package com.misnotas.vistas.componentes.base;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import com.misnotas.vistas.componentes.extras.CategoriaPnl;

/**
 * PnlExplorer
 */
public class PnlExplorer extends JPanel {
    public static final String OPEN_TABS_TITLE = "Pestañas abiertas";
    public static final String TREE_DATA_TITLE = "Mis notas";
    
    private CategoriaPnl catOpenTabs;
    private CategoriaPnl catTreeData;

    public PnlExplorer() {
        super();
        catOpenTabs = new CategoriaPnl(OPEN_TABS_TITLE);
        catTreeData = new CategoriaPnl(TREE_DATA_TITLE);

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH; // temporal
        c.weightx = 1.0;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        add(catOpenTabs, c);
        c.gridy = 1;
        add(catTreeData, c);
    }
}