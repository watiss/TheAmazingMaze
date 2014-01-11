//Author:valeh

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.GameWindowModel;

import view.GameWindow;

public class MenuOpenItem extends JMenuItem implements ActionListener {

	private final GameWindow gw;

	public MenuOpenItem(GameWindow gw) {
		super("Open");
		this.gw = gw;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent evt) {

		JFileChooser fc = new JFileChooser();

		fc.removeChoosableFileFilter(fc.getAcceptAllFileFilter());
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"superMaze files", "smz"); // Only smz files are authorized
		fc.setFileFilter(filter);

		int returnVal = fc.showOpenDialog(getParent());

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			if (!fc.getSelectedFile().exists()) {
				JOptionPane.showMessageDialog(null, "Inexistant file!",
						"Unfound", JOptionPane.ERROR_MESSAGE);
			} else {
				String path = fc.getSelectedFile().getAbsolutePath();
				if (!path.endsWith(".smz"))
					JOptionPane.showMessageDialog(null,
							"Open only superMaze(.smz) files!",
							"File Type Error", JOptionPane.ERROR_MESSAGE);
				else
					gw.getGwm().actualiseModel(fc.getSelectedFile());
			}
		}

	}

}
