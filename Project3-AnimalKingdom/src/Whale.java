/*
 * Author: Chad Fusco
 * Class: CS111B, Summer 2022
 * Project 3 - Animal Kingdom
 */

public abstract class Whale extends Mammal implements WaterDweller {
	
	private static final BirthType WHALE_BIRTH_TYPE = BirthType.LIVE_BIRTH;
	private static boolean breathesAir = true;
	
	public Whale(int id, String name) {
		super(id, name, WHALE_BIRTH_TYPE);
	}
	
	@Override
	public final boolean breathesAir() {
		return Whale.breathesAir;
	}

}
