/*
 * Author: Chad Fusco
 * Class: CS111B, Summer 2022
 * Project 3 - Animal Kingdom
 */

public class Elephant extends Mammal implements Endangered {
	
	private static final BirthType ELEPHANT_BIRTH_TYPE = BirthType.LIVE_BIRTH;
	
	public Elephant(int id, String name) {
		super(id, name, ELEPHANT_BIRTH_TYPE);
	}

}
