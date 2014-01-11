//Author:jeremy

package view;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ErrorWindow extends JFrame{
	
	public ErrorWindow(String message){
		
		JPanel panel = (JPanel) this.getContentPane() ;
		panel.setLayout(new GridLayout(3,3));
		this.setSize(250,100);
		this.setLocationRelativeTo(null);
		this.setTitle("Error");
		panel.add(new JLabel(message));
		this.setVisible(true);
	}
}
