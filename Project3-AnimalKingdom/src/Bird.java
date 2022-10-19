/*
 * Author: Chad Fusco
 * Class: CS111B, Summer 2022
 * Project 3 - Animal Kingdom
 */

public abstract class Bird extends Animal implements Winged{
	
	private static final BirthType BIRD_BIRTH_TYPE = BirthType.LAYS_EGGS;
	private static final boolean BIRD_WARM_BLOODED = true;
	private boolean canFly;
	private boolean isEndangered;
	
	public Bird(int id, String name, boolean canFly, boolean isEndangered) {
		super(id, name, BIRD_BIRTH_TYPE);
		this.canFly = canFly;
		this.isEndangered = isEndangered;
	}
	
	@Override
	public boolean isWarmBlooded() {
		return Bird.BIRD_WARM_BLOODED;
	}
	
	public final boolean canFly() {
		return canFly;
	}
	
	public final boolean isEndangered() {
		return isEndangered;
	}
	
	@Override
	public String getDescription() {
		Class c = this.getClass();
		String description = "";
		while(true) {
			description += c.getSimpleName() + "\t";
			c = c.getSuperclass();
			if(c.getSimpleName().equals("Object")) {break;}
		}
		description += "(has wings, breathes air, " + (canFly() ?
				"can fly" : "cannot fly") + (isEndangered() ? ", endangered"
				: "") + ")";
		return description;
	}
	
}
