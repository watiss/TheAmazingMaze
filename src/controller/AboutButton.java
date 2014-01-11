//Author:valeh

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.GameWindow;

public class AboutButton extends JButton implements ActionListener {
	private final GameWindow gw;

	public AboutButton(GameWindow gw) {
		super("About");
		this.gw = gw;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent evt) {
		JFrame aboutWindow = new JFrame("About");
		aboutWindow.setLocationRelativeTo(null);
		aboutWindow.setSize(200, 100);

		JPanel aboutWindowPanel = new JPanel();
		aboutWindowPanel
				.add(new JLabel(
						"<HTML>*****Welcome to SuperMaze*****<br>To change a case,click on "
								+ "it then press:<br>w to create a wall case (black)<br>e to create an empty case (white)<br> "
								+ "d to create the departure case (red)<br>a to create the arrival "
								+ "case (green)<br>Then click on Solve to have the amazing shortest path "
								+ "from departure to arrival in pink.<br>The wall cases all around are "
								+ "non-modifiable.<br>Enjoy!!<HTML>"));// the
																		// HTML
																		// balise
																		// is a
																		// solution
																		// to
																		// skip
																		// lines
																		// with
																		// JLabel

		aboutWindow.setContentPane(aboutWindowPanel);
		aboutWindow.pack();
		aboutWindow.setVisible(true);

	}

}
