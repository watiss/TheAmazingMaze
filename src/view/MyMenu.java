//Author:valeh

package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import controller.MenuNewItem;
import controller.MenuOpenItem;
import controller.MenuSaveAsItem;
import controller.MenuSaveItem;

public class MyMenu extends JMenu {

	private final MenuSaveItem menuSaveItem;
	private final MenuOpenItem menuOpenItem;
	private final MenuSaveAsItem menuSaveAsItem;
	private final MenuNewItem menuNewItem;
	private final GameWindow gw;

	public MyMenu(GameWindow gw) {
		super("Menu");
		this.gw = gw;

		add(menuSaveItem = new MenuSaveItem(gw));
		add(menuOpenItem = new MenuOpenItem(gw));
		add(menuSaveAsItem = new MenuSaveAsItem(gw));
		add(menuNewItem = new MenuNewItem(gw));
	}

}
