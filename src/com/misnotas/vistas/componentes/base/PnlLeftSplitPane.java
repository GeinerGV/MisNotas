package com.misnotas.vistas.componentes.base;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * PnlLeftSplitPane
 */
public class PnlLeftSplitPane extends JPanel {
	private JLabel jLtitle = new JLabel("TITULO");
	
	public PnlLeftSplitPane() {
		super();
		setLayout(new BorderLayout());
		jLtitle.setVerticalAlignment(JLabel.CENTER);
		add(jLtitle, BorderLayout.NORTH);
	}
}