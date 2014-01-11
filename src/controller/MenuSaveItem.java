//Author:valeh

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import view.GameWindow;

public class MenuSaveItem extends JMenuItem implements ActionListener {
	private final GameWindow gw;

	public MenuSaveItem(GameWindow gw) {
		super("Save");
		this.gw = gw;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent evt) {
		gw.getGwm().save();

	}

}
