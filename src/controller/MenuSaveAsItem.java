//Author:valeh

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import view.GameWindow;

public class MenuSaveAsItem extends JMenuItem implements ActionListener {
	private final GameWindow gw;

	public MenuSaveAsItem(GameWindow gw) {
		super("SaveAs");
		this.gw = gw;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent evt) {
		JFileChooser fc = new JFileChooser();

		fc.removeChoosableFileFilter(fc.getAcceptAllFileFilter());
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"superMaze files", "smz"); // Only .smz files are authorizd
		fc.setFileFilter(filter);

		int returnVal = fc.showSaveDialog(getParent());

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String path = fc.getSelectedFile().getAbsolutePath();
			if (!path.endsWith(".smz"))
				JOptionPane.showMessageDialog(null,
						"Save only superMaze(.smz) files!", "File Type Error",
						JOptionPane.ERROR_MESSAGE);
			else {
				gw.getGwm().saveAs(path);
				gw.getGwm().setFileName(path);
			}
		}

	}

}
