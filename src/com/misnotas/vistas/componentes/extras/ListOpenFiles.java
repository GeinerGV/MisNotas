package com.misnotas.vistas.componentes.extras;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.misnotas.vistas.AppFrame;

import app.App;

/**
 * ListOpenFiles
 */
public class ListOpenFiles extends JPanel {


    public class ItmList extends JPanel {
        private int pos;
        public ItmList(String name, int pos) {
            super();
            this.pos = pos;
            setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
            JButton close = new JButton();
            if (App.getURLIcon("icons8-close-window-24.png")!=null) {
                ImageIcon ico = new ImageIcon(App.getURLIcon("icons8-close-window-24.png"));
                ico = new ImageIcon(ico.getImage().getScaledInstance(12, 12, Image.SCALE_DEFAULT), "Close");
                close.setIcon(ico);
            } else {
                close.setText("x");
            }
            close.setContentAreaFilled(false);
            close.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    ((ListOpenFiles) getParent()).closeFile(pos);
                }
            });
            JLabel label = new JLabel(name);
            add(close);
            add(label);
        }
    }

    public void closeFile(int pos) {
        remove(pos);
    }

    public ListOpenFiles() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public void openFile(int id) {
        
    }
}