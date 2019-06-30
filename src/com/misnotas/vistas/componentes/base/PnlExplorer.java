package com.misnotas.vistas.componentes.base;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.misnotas.vistas.componentes.extras.CategoriaPnl;
import com.misnotas.vistas.componentes.extras.ListOpenFiles;;

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
        catOpenTabs = new CategoriaPnl(OPEN_TABS_TITLE, new ListOpenFiles());
        catTreeData = new CategoriaPnl(TREE_DATA_TITLE, new JPanel());

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(catOpenTabs);
        add(catTreeData);
    }
}