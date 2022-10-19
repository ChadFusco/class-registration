/*
 * Author: Chad Fusco
 * Class: CS111B, Summer 2022
 * Project 3 - Animal Kingdom
 */

public class Goldfish extends Fish {
	
	private static final BirthType GOLDFISH_BIRTH_TYPE = BirthType.LAYS_EGGS;
	private static boolean IS_ENDANGERED = false;
	
	public Goldfish(int id, String name) {
		super(id, name, GOLDFISH_BIRTH_TYPE, IS_ENDANGERED);
	}

}
