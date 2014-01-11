//Author:jeremy

package controller;

import java.awt.AWTEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import model.InitWindowModel;

import view.ErrorWindow;
import view.GameWindow;
import view.InitWindow;

public class OkButton extends JButton implements ActionListener{

	private static final long serialVersionUID = 1L;
	private final InitWindow initWindow;	
	public OkButton(InitWindow iw){
		super("OK");
		initWindow = iw;
		addActionListener(this);
	}
	
	
	public void actionPerformed(ActionEvent arg0) {
		initWindow.createGW();
		
	}

	
}
