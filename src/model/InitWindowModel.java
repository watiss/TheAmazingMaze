//Author:jeremy

package model;

import controller.BoundException;

public class InitWindowModel {

	private static int heightUserInit = 11;
	private static int widthUserInit = 13;
	private static int heightMax = 20;
	private static int widthMax = 20;

	public int getHeightUserInit() {
		return heightUserInit;
	}

	public int getWidthUserInit() {
		return widthUserInit;
	}

	public static void setHeight(int heightUser) throws BoundException {
		if (heightUser > heightMax) {
			throw new BoundException();
		} else {
			heightUserInit = heightUser;
		}
	}

	public static void setWidth(int widthUser) throws BoundException {

		if (widthUser > widthMax) {
			throw new BoundException();
		} else {
			widthUserInit = widthUser;
		}
	}

}
