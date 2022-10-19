/*
 * Author: Chad Fusco
 * Class: CS111B, Summer 2022
 * Project 3 - Animal Kingdom
 */

public class CaliforniaCondor extends Bird implements Endangered {
	
	private static final boolean CAN_FLY = true;
	private static final boolean IS_ENDANGERED = true;
	
	public CaliforniaCondor(int id, String name) {
		super(id, name, CAN_FLY, IS_ENDANGERED);
	}

}
