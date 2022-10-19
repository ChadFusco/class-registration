/*
 * Author: Chad Fusco
 * Class: CS111B, Summer 2022
 * Project 1: Credit Card Number Verification
 */

import java.util.*;
import java.time.LocalDate;
import java.lang.Math;

public class CreditCardValidator {

	public static void main(String[] args) {
		
		long creditCardNumber = readUserCreditCardNumber();
		int year = readUserYear();
		int month = readUserMonth(year);

		System.out.print("Your valid credit card number is ");
		for (int i=Long.toString(creditCardNumber).length()-1; i >= 0; i--) {
			System.out.print(singleDigit(creditCardNumber,i+1));
			if(i % 4 == 0) {
				System.out.print(" ");
			}
		}
		System.out.println("exp. " + month + "/" + year);
		
	}
		
	public static int readUserYear() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the credit card expiration year" +
				" as a four digit number (YYYY):");
		int userYear = Integer.parseInt(scan.nextLine());
		
		int currentYear = java.time.LocalDate.now().getYear();
		
		while (userYear < currentYear) {
			System.out.println("Invalid year. Please enter " + currentYear +
					" or later:");
			userYear = Integer.parseInt(scan.nextLine());
		}
		
		return userYear;
	}
	
	public static int readUserMonth(int userYear) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the credit card expiration month" +
				" as a two digit number (MM):");
		
		int currentYear = java.time.LocalDate.now().getYear();
		int currentMonth = java.time.LocalDate.now().getMonthValue();
		
		boolean isValidMonth = true;
		int userMonth;
		
		do {
			userMonth = Integer.parseInt(scan.nextLine());
			if (userMonth < 1 || userMonth > 12) {
				isValidMonth = false;
				System.out.println("Invalid month. Month must be at least 1 " +
						"and no greater than 12:");
			}
			else if (userYear == currentYear && userMonth < currentMonth) {
				isValidMonth = false;
				System.out.println("Card is expired. Please enter month for a" +
						" different credit card:");
			}
			else if (userYear == currentYear && userMonth == currentMonth) {
				System.out.println("Warning: your card expires this month!");
				isValidMonth = true;
			}
			else {
				isValidMonth = true;
			}
		} while (!isValidMonth);
		
		return userMonth;
		
	}
	
	public static long readUserCreditCardNumber() {
		
		boolean isValidCCNumber = true;
		long firstDigit;
		String userCCNumberStr;
		long userCCNumber;
		final int validCCNumberLen = 16;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the " + validCCNumberLen +
				"-digit credit card number" +
				" without spaces or dashes (numbers only):");
		
		
		do {
			userCCNumberStr = scan.nextLine();
			userCCNumber = Long.parseLong(userCCNumberStr);
			
			firstDigit = singleDigit(userCCNumber, validCCNumberLen);
			
			if (firstDigit < 1) {
				isValidCCNumber = false;
				System.out.println("Number is too short. Please enter a " +
						validCCNumberLen + "-digit number:");
			}
			else if (userCCNumber / (long) Math.pow(10,validCCNumberLen) > 0) {
				isValidCCNumber = false;
				System.out.println("Number is too long. Please enter a " +
						validCCNumberLen + "-digit number:");
			}
			// else-if below checks that the first digit of the CC number
			// is either 4, 5, or 6.
			else if (firstDigit < 4 || firstDigit > 6) {
				isValidCCNumber = false;
				System.out.println("Number must start with a 4, 5, or 6. " +
						"Please try again:");
			}
			else if (!passesCheckSum(userCCNumberStr)) {
				isValidCCNumber = false;
				System.out.println("Number invalid (fails check sum test). " +
						"Please try again:");
			}
			else {
				isValidCCNumber = true;
			}
		} while (!isValidCCNumber);
		
		return userCCNumber;
	}
	
	// this method assumes cardNumber has the valid number of digits
	public static boolean passesCheckSum(String cardNumber) {
		
		int digitInt;
		char digitChar;
		long sum = 0;
		
		for (int i=0; i < cardNumber.length(); i++) {
			
			digitChar = cardNumber.charAt(i);
			digitInt = convertDigitCharToInt(digitChar);
			
			if (i % 2 == 0) {
				int digitXTwo = 2 * digitInt;
				if (digitXTwo > 9) {
					String digitXTwoStr = Integer.toString(digitXTwo);
					sum += convertDigitCharToInt(digitXTwoStr.charAt(0));
					sum += convertDigitCharToInt(digitXTwoStr.charAt(1));
				}
				else {
					sum += digitXTwo;
				}
			}
			else {
				sum += digitInt;
			}
		}
		
		return sum % 10 == 0;
	}
	
	// Method to return a single digit from an integer of type long.
	// The "position" parameter is the position number (going from right
	// to left) of the digit of interest, not the index number.
	public static int singleDigit(long num, int position) {
		long tenToPosPow = (long) Math.pow(10,position);
		long tenToPosMinusOnePow = tenToPosPow / 10;
		String digit = Long.toString(num % tenToPosPow /
				tenToPosMinusOnePow);
		return Integer.valueOf(digit);
	}

	/*
	 * Below is a collection of helper methods you might or might not use.
	 * Don't worry too much about understanding these- we'll learn more
	 * about them later on. For now, you can just use them!
	 */
	
	// example: pass in the char '3' and return the int 3
	public static int convertDigitCharToInt(char digit) {
		return Integer.valueOf(String.valueOf(digit));
	}

}
