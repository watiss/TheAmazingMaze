//Author:valeh

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import view.GameWindow;
import view.InitWindow;

public class MenuNewItem extends JMenuItem implements ActionListener{
	private final GameWindow gw;
	
	public MenuNewItem(GameWindow gw){
		super("New");
		this.gw = gw;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent evt) {
		new InitWindow();
		gw.dispose();

	}


}
