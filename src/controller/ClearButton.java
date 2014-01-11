//Author:valeh

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.GameWindow;

public class ClearButton extends JButton implements ActionListener {
	private final GameWindow gw;

	public ClearButton(GameWindow gw) {
		super("Clear");
		this.gw = gw;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent evt) {
		gw.getGwm().clear();
	}
}
