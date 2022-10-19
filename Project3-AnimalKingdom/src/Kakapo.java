/*
 * Author: Chad Fusco
 * Class: CS111B, Summer 2022
 * Project 3 - Animal Kingdom
 */

public class Kakapo extends Bird implements Endangered {
	
	private static final boolean CAN_FLY = false;
	private static final boolean IS_ENDANGERED = true;
	
	public Kakapo(int id, String name) {
		super(id, name, CAN_FLY, IS_ENDANGERED);
	}
	
	@Override
	public void displayConservationInformation() {
		System.out.println("Zooligists are currently hard at work teaching"
				+ " this bird how to fly to better evade predators.");
	}

}
