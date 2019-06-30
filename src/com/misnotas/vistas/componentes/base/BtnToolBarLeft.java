package com.misnotas.vistas.componentes.base;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.misnotas.vistas.AppFrame;

import app.App;

/**
 * BtnToolBarLeft
 */
public class BtnToolBarLeft extends JButton {

	public static final int BTN_SIZE = 40;
	public static final int NUM_BTNS = 2;

	private static final int ICON_SIZE = 32;

	public BtnToolBarLeft(String name) {
		super();
		setMaximumSize(new Dimension(BTN_SIZE, BTN_SIZE));
		setName(name);
	}

	public BtnToolBarLeft(String name, String imageName) {
		super();
		// setMaximumSize(new Dimension(BTN_SIZE, BTN_SIZE));
		// setActionCommand(actionCommand);
		setName(name);
		setToolTipText(name);
		if (App.getURLIcon(imageName) != null) { // image found
			ImageIcon icon = new ImageIcon(App.getURLIcon(imageName));
			setIcon(new ImageIcon(icon.getImage().getScaledInstance(ICON_SIZE, ICON_SIZE, Image.SCALE_DEFAULT), name));
		} else { // no image found
			setText(name);
			System.err.println("Resource not icon: " + imageName);
		}
		setBorderPainted(false);
		setContentAreaFilled(false);
		setRolloverEnabled(true);
		setVerticalTextPosition(CENTER);
		addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent e) {
				AppFrame.controlador.onBtnLeftSelect(getName());
			}
		});
	}
}