//Author:valeh

package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import dijkstra.VertexInterface;

import maze.MBox;
import maze.Maze;
import model.GameWindowModel;

public class GameWindowPanel extends JPanel {

	private GameWindow gw;
	private GameWindowModel gwm;
	private int heightUser;
	private int widthUser;
	ArrayList<MyButton> graphicMatrix;

	public GameWindowModel getGwm() {
		return gwm;
	}

	public void setGwm(GameWindowModel gwm) {
		this.gwm = gwm;
	}

	
	
	
	public GameWindowPanel(GameWindow gw) {

		this.gw = gw;
		gwm = gw.getGwm();
		heightUser = gwm.getHeightUser();
		widthUser = gwm.getWidthUser();
		setLayout(new GridLayout(heightUser, widthUser));
		// Maze graphicMaze=new Maze(widthUser,heightUser);
		Maze graphicMaze = gwm.getGraphicMaze();
		graphicMatrix = new ArrayList<MyButton>(heightUser * widthUser);

		for (int line = 0; line < heightUser; line++) {
			for (int col = 0; col < widthUser; col++) {
				graphicMatrix.add(new MyButton(gw, line, col));
			}

		}

		// gwm.setInitFile(widthUser,heightUser);
		for (MyButton button : graphicMatrix) {

			int i = button.getPosX(), j = button.getPosY();

			MBox mbox = graphicMaze.returnCase(i, j);
			char boxType = mbox.boxType();
			switch (boxType) {
			case 'E':
				button.setColor(Color.WHITE);
				break;
			case 'W':
				button.setColor(Color.BLACK);
				break;
			case 'D':
				button.setColor(Color.RED);
				break;
			case 'A':
				button.setColor(Color.GREEN);
				break;
			default:
				break;
			}

			this.add(button);

		}
	}

	public void notifyForUpdate(ArrayList<VertexInterface> liste) {
		for (VertexInterface vertex : liste) {
			// System.out.println( ((MBox) vertex).getColumn() );
			int x = ((MBox) vertex).getLine();
			int y = ((MBox) vertex).getColumn();
			MyButton button = graphicMatrix.get(x * widthUser + y); // arrayliste={
																	// (0,0),(0,1),...,(0,widthUser-1),(1,0),etc.}
																	// donc l'element qu'on cherhche est (x*widthUser)+y

			button.notifyForUpdate(1);
		}

	}

	public void notifyForUpdate() {
		for (MyButton button : graphicMatrix)
			if (!button.isForbidden())
				button.notifyForUpdate(2);
	}

}
