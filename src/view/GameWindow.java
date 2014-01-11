//Author:valeh

package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import view.GameWindowPanel;
import view.MyMenu;

import model.GameWindowModel;
import model.InitWindowModel;

import controller.AboutButton;
import controller.ClearButton;
import controller.SolveButton;
import dijkstra.VertexInterface;

public class GameWindow extends JFrame implements Observer {

	private GameWindowPanel gwp;
	private GameWindowModel gwm;

	private final SolveButton solveButton;
	private final AboutButton aboutButton;
	private final ClearButton clearButton;
	private final JMenuBar menuBar = new JMenuBar();
	private final MyMenu myMenu;

	public GameWindowModel getGwm() {
		return gwm;
	}

	public void setGwm(GameWindowModel gwm) {
		this.gwm = gwm;
	}

	public GameWindowPanel getGwp() {
		return gwp;
	}

	public void setGwp(GameWindowPanel gwp) {
		this.gwp = gwp;
	}

	public GameWindow() {
		super("Maze");
		gwm = new GameWindowModel();

		int height = gwm.getHeightUser();
		int width = gwm.getWidthUser();

		this.setSize(50 * height, 50 * width);
		setLocationRelativeTo(null);

		gwp = new GameWindowPanel(this);

		gwm.addObserver(this);

		// Conteneur principal:celui par defaut.Dessus on colle le JPanel gwp et
		// les 2 autre buttons en BorderLayout
		JPanel mainContainer = (JPanel) getContentPane();
		BorderLayout bl = new BorderLayout();
		mainContainer.setLayout(bl);

		JPanel menuPanel = new JPanel(); // Le menu en bas qui est lui-meme un
											// panel contenant les 2 buttons en
											// boxlayout
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.LINE_AXIS));
		menuPanel.add(solveButton = new SolveButton(this));
		menuPanel.add(aboutButton = new AboutButton(this));
		menuPanel.add(clearButton = new ClearButton(this));
		

		mainContainer.add(gwp, bl.CENTER);
		mainContainer.add(menuPanel, bl.SOUTH);

		menuBar.add(myMenu = new MyMenu(this)); // La barre menu en haut avec
												// Save,Open,SaveAs
		this.setJMenuBar(menuBar);
		this.setContentPane(mainContainer);
		setVisible(true);
		//this.pack();

	}

	public GameWindow(File file) {

		super(file.getName());
		gwm = new GameWindowModel(file.getAbsolutePath());

		int height = gwm.getHeightUser();
		int width = gwm.getWidthUser();

		this.setSize(50 * height, 50 * width);
		setLocationRelativeTo(null);

		gwp = new GameWindowPanel(this);

		gwm.addObserver(this);

		// Conteneur principal:celui par defaut.Dessus on colle le JPanel gwp et
		// les 3 autre buttons en BorderLayout
		JPanel mainContainer = (JPanel) getContentPane();
		BorderLayout bl = new BorderLayout();
		mainContainer.setLayout(bl);

		JPanel menuPanel = new JPanel(); // Le menu en bas qui est lui-meme un
											// panel contenant les 3 buttons en
											// boxlayout
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.LINE_AXIS));
		menuPanel.add(solveButton = new SolveButton(this));
		menuPanel.add(aboutButton = new AboutButton(this));
		menuPanel.add(clearButton = new ClearButton(this));

		mainContainer.add(gwp, bl.CENTER);
		mainContainer.add(menuPanel, bl.SOUTH);

		menuBar.add(myMenu = new MyMenu(this)); // La barre menu en haut avec
												// Save,Open,SaveAs
		this.setJMenuBar(menuBar);
		this.setContentPane(mainContainer);
		setVisible(true);

	}

	public void update(Observable observable, Object parameter) {

		if (parameter instanceof File) {

			this.dispose();
			GameWindow gw = new GameWindow((File) parameter);
		} else if (parameter instanceof ArrayList<?>) {
			gwp.notifyForUpdate((ArrayList<VertexInterface>) parameter);

		} else {
			gwp.notifyForUpdate();
		}
	}

}
