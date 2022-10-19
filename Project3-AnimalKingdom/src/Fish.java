/*
 * Author: Chad Fusco
 * Class: CS111B, Summer 2022
 * Project 3 - Animal Kingdom
 */

public abstract class Fish extends Animal implements WaterDweller{
	
	private static final boolean FISH_WARM_BLOODED = false;
	private boolean isEndangered;
	private static boolean breathesAir = false;
	
	public Fish(int id, String name, BirthType birthType,
			boolean isEndangered) {
		super(id, name, birthType);
		this.isEndangered = isEndangered;
	}
	
	@Override
	public boolean isWarmBlooded() {
		return Fish.FISH_WARM_BLOODED;
	}
	
	public final boolean isEndangered() {
		return isEndangered;
	}
	
	@Override
	public final boolean breathesAir() {
		return Fish.breathesAir;
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
		description += "(" + (breathesAir() ? "breathes air" :
			"breathes water") + (isEndangered() ? ", endangered" : "") + ")";
		return description;
	}
	
}
