/*
 * Author: Chad Fusco
 * Class: CS111B, Summer 2022
 * Project 3 - Animal Kingdom
 */

public class GreatWhiteShark extends Fish implements Endangered{
	
	private static final BirthType GREATWHITESHARK_BIRTH_TYPE =
			BirthType.LIVE_BIRTH;
	private static final boolean IS_ENDANGERED = true;
	
	public GreatWhiteShark(int id, String name) {
		super(id, name, GREATWHITESHARK_BIRTH_TYPE, IS_ENDANGERED);
	}

}
