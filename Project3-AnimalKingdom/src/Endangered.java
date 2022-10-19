/*
 * Author: Chad Fusco
 * Class: CS111B, Summer 2022
 * Project 3 - Animal Kingdom
 */

public interface Endangered {
	
	default void displayConservationInformation() {
		System.out.println("Conservation information to be provided.");
	}
	
}