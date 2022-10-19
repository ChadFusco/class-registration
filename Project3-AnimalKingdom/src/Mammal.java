/*
 * Author: Chad Fusco
 * Class: CS111B, Summer 2022
 * Project 3 - Animal Kingdom
 */

import java.util.*;

public abstract class Mammal extends Animal{
	
	private static final boolean MAMMAL_WARM_BLOODED = true;
	private boolean isEndangered;
	private boolean waterDweller;
	
	public Mammal(int id, String name, BirthType birthType) {
		super(id, name, birthType);
		this.waterDweller = Arrays.toString(this.getClass().getSuperclass()
				.getInterfaces()).contains("WaterDweller");
		this.isEndangered = Arrays.toString(this.getClass().getInterfaces())
				.contains("Endangered");
	}
	
	@Override
	public boolean isWarmBlooded() {
		return Mammal.MAMMAL_WARM_BLOODED;
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
		description += waterDweller || isEndangered() ? "(" : "";
		description += waterDweller ? "lives in water, breathes air" : "";
		description += waterDweller && isEndangered() ? ", " : "";
		description += isEndangered() ? "" + "endangered" : "";
		description += waterDweller || isEndangered() ? ")" : "";
		return description;
	}
	
}
