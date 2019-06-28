package com.misnotas.vistas.componentes.base;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import app.App;

/**
 * BtnToolBarLeft
 */
public class BtnToolBarLeft extends JButton {

	public static final int BTN_SIZE = 40;

	
	private static final int ICON_SIZE = 32;

	public BtnToolBarLeft() {
		super();
		setMaximumSize(new Dimension(BTN_SIZE, BTN_SIZE));
	}

	public BtnToolBarLeft(String altText, String imageName) {
		super();
		//setMaximumSize(new Dimension(BTN_SIZE, BTN_SIZE));
		//setActionCommand(actionCommand);
		setToolTipText(altText);
		if (App.getURLIcon(imageName) != null) {                    //image found
			ImageIcon icon = new ImageIcon(App.getURLIcon(imageName));
			setIcon(new ImageIcon(icon.getImage().getScaledInstance(ICON_SIZE, ICON_SIZE, Image.SCALE_DEFAULT), altText));
		} else {                                     //no image found
			setText(altText);
			System.err.println("Resource not icon: " + imageName);
		}
		setBorderPainted(false);
		setContentAreaFilled(false);
		setRolloverEnabled(true);
		setVerticalTextPosition(CENTER);
	}
}