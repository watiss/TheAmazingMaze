//Author:valeh

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.GameWindow;

public class SolveButton extends JButton implements ActionListener {

	private final GameWindow gw;

	public SolveButton(GameWindow gw) {
		super("Solve");
		this.gw = gw;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent evt) {
		gw.getGwm().solveMaze();
	}

}
