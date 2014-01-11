//Author:valeh

package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import maze.WBox;

public class MyButton extends JButton implements MouseListener, KeyListener {

	private GameWindow gw;
	private Color color;
	private int posX = 0;
	private int posY = 0;
	private boolean isModified = false;

	public MyButton(GameWindow gw) {
		super();
		this.gw = gw;
		this.setPreferredSize(new Dimension(5, 5));
		addMouseListener(this);

	}

	public MyButton(GameWindow gw, int posX, int posY) {
		super();
		this.gw = gw;
		this.setPreferredSize(new Dimension(5, 5));
		this.posX = posX;
		this.posY = posY;
		addMouseListener(this);
	}

	public boolean getIsModified() {
		return this.isModified;
	}

	public boolean isForbidden() {
		ArrayList<String> forbiddenList = new ArrayList<String>();
		int widthUser = gw.getGwm().getWidthUser();
		int heightUser = gw.getGwm().getHeightUser();

		for (int col = 0; col < widthUser; col++) {
			forbiddenList.add("(0," + col + ")"); // ( 0,col )
			forbiddenList.add("(" + (heightUser - 1) + "," + col + ")"); // ( (heightUser-1),col )

		}
		for (int lin = 0; lin < heightUser; lin++) {
			forbiddenList.add("(" + lin + ",0)"); // ( lin,0 )
			forbiddenList.add("(" + lin + "," + (widthUser - 1) + ")"); // ( lin,widthUser-1 )
									
		}
		if (!forbiddenList.contains("(" + this.posX + "," + this.posY + ")"))
			return false;
		return true;

	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public void setColor(Color color) {
		this.setBackground(color);
		this.color = color;
	}

	public void posXPlus(int c) {
		this.posX += c;
	}

	public void posYPlus(int c) {
		this.posY += c;
	}

	public void mouseClicked(MouseEvent evt) {
		if (!this.isForbidden())
			this.addKeyListener(this);

	}

	public void mouseEntered(MouseEvent evt) {
	}

	public void mouseExited(MouseEvent evt) {
	}

	public void mousePressed(MouseEvent evt) {
	}

	public void mouseReleased(MouseEvent evt) {
	}

	public void keyPressed(KeyEvent arg0) {
	}

	public void keyReleased(KeyEvent arg0) {
	}

	public void keyTyped(KeyEvent kEvt) {
		char caract = kEvt.getKeyChar();
		isModified = true;
		switch (caract) {
		case 'w':
			this.setBackground(Color.BLACK);
			gw.getGwm().actualiseMaze(this.posX, this.posY, 'w');
			break;
		case 'd':
			this.setBackground(Color.RED);
			gw.getGwm().actualiseMaze(this.posX, this.posY, 'd');
			break;
		case 'a':
			this.setBackground(Color.GREEN);
			gw.getGwm().actualiseMaze(this.posX, this.posY, 'a');
			break;
		case 'e':
			this.setBackground(Color.WHITE);
			gw.getGwm().actualiseMaze(this.posX, this.posY, 'e');
			break;
		default:
			isModified = false;
			break;
		}
	}

	public void notifyForUpdate(int order) {
		if (order == 1) {
			this.setBackground(Color.PINK);
			isModified = true;
		}
		// System.out.println("my x and y"+posX+posY);
		else
			this.setBackground(Color.WHITE);
		gw.getGwm().actualiseMaze(this.posX, this.posY, 'e');

	}

}
