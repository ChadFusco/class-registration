/*
 * Author: Chad Fusco
 * Class: CS111B, Summer 2022
 * Project 3 - Animal Kingdom
 */

public class Horse extends Mammal {
	
	private static final BirthType HORSE_BIRTH_TYPE =
			BirthType.LIVE_BIRTH;
	
	public Horse(int id, String name) {
		super(id, name, HORSE_BIRTH_TYPE);
	}

}
