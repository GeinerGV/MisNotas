package com.misnotas.vistas.componentes.base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.misnotas.interfaces.ModeloVista;
import com.misnotas.vistas.AppFrame;

import app.App;

/**
 * PnlLeftSplitPane
 */
public class PnlLeftSplitPane extends JPanel {
	private JLabel jLtitle = new JLabel("[title]");
	private static Color BG_TITLE = App.LIGTH_COLOR;

	private static final int PAD_TITLE = 10;
	private JPanel[] jPanels = new JPanel[BtnToolBarLeft.NUM_BTNS];
	private JPanel pnlCnt = new JPanel();;
	
	public PnlLeftSplitPane() {
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel jTitlePane = new JPanel(new GridBagLayout());
		jTitlePane.setBackground(BG_TITLE);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(PAD_TITLE,PAD_TITLE,PAD_TITLE,PAD_TITLE);
		c.weightx = 0.0;
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.WEST;
		jTitlePane.add(jLtitle, c);
		jLtitle.setHorizontalAlignment(JLabel.LEFT);
		jTitlePane.setMaximumSize(new Dimension(Short.MAX_VALUE, 70));
		add(jTitlePane);
		add(pnlCnt);
		selectPane(AppFrame.modelo.getPosBtnLeftSelected());
	}

	public void selectPane(int pos) {
		switch (pos) {
			case 0:
				jPanels[pos] = new PnlExplorer();
				break;
			case 1:
				jPanels[pos] = new PnlBuscar();
				break;
			default:
				break;
		}
		remove(1);
		jLtitle.setText(AppFrame.modelo.getNameBtnLeftSelected());
		add(jPanels[pos]);
	}
}