/*
 * Author: Chad Fusco
 * Class: CS111B, Summer 2022
 * Project 3 - Animal Kingdom
 */

public class DuckbilledPlatypus extends Mammal {
	
	private static final BirthType DUCKBILLEDPLATYPUS_BIRTH_TYPE =
			BirthType.LAYS_EGGS;
	
	public DuckbilledPlatypus(int id, String name) {
		super(id, name, DUCKBILLEDPLATYPUS_BIRTH_TYPE);
	}

}
