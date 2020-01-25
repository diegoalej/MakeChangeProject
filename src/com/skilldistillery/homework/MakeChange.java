package com.skilldistillery.homework;

import java.util.Scanner;

public class MakeChange {
	 
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);		
		//Uncomment next two lines for testing on infinite loop as well as lines 46-49
		boolean debug = true;
		do {	//used for testing	
		
		// * User Story #1
		//   The user is prompted asking for the price of the item.
		System.out.print("Enter item price: " );
		double priceOfItem = kb.nextDouble();
		
		// * User Story #2
		//   The user is then prompted asking how much money was tendered by the customer.
		System.out.print("Enter amount tendered: " );
		double amountTendered = kb.nextDouble();
		
		double totalChange =  amountTendered - priceOfItem;
		
		// * User Story #3
		//   Display an appropriate message if the customer provided too little money or the exact amount.		 
		if (totalChange < 0) { //   Conditional using the change balance above testing for underpayment 
			System.out.println("Not enough, you are $"  + (roundTwoDecimals(totalChange) * -1) + " short for purchasing this item.");
		}
		else if (totalChange == 0) { //   Conditional using the change balance above testing for exact amount
			System.out.println("Exact payment, thanks!");
		}
		else {
		// * User Story #4
		//   If the amount tendered is more than the cost of the item, 
		//   display the number of bills and coins that should be given to the customer.
		String changeBreakdown = getChange(roundTwoDecimals(totalChange));		
		System.out.println(changeBreakdown);		
		}		
		// Uncomment next four lines for testing on infinite loop as well as lines 11 and 12
		if (priceOfItem == 0) {
			debug = false;
		}		
		}while (debug);
		kb.close();
	}//End Main
	
	//Method test different change cases from biggest to smallest to find exact change
	private static String getChange(double changeBalance) {
		String totalChangeString = "Here's your change breakdownfor $" + changeBalance + "\n";
		int currencyNumber;
		if(changeBalance >= 20) { //test to see if balance is more than denomination 
			currencyNumber = (int) (changeBalance / 20); //find out the number of bills/coins needed 
			totalChangeString += "$20: " + currencyNumber + "\n"; //concatenate the denomination and number of bills to the return string
			changeBalance = roundTwoDecimals(changeBalance - 20 * currencyNumber); //update the change balance and continue to the cases below
		}
		if(changeBalance >= 10) {
			currencyNumber = (int) (changeBalance / 10);
			totalChangeString += "$10: " + currencyNumber + "\n";
			changeBalance = roundTwoDecimals(changeBalance - 10 * currencyNumber);
		}
		if(changeBalance >= 5) {
			currencyNumber = (int) (changeBalance / 5);
			totalChangeString += " $5: " + currencyNumber + "\n";
			changeBalance = roundTwoDecimals(changeBalance - 5 * currencyNumber);
		}
		if(changeBalance >= 1) {
			currencyNumber = (int) (changeBalance / 1);
			totalChangeString += " $1: " + currencyNumber + "\n";
			changeBalance = roundTwoDecimals(changeBalance - 1 * currencyNumber);
		}
		if(changeBalance >= .25) {
			currencyNumber = (int) (changeBalance / .25);
			totalChangeString += "¢25: " + currencyNumber + "\n";
			changeBalance = roundTwoDecimals(changeBalance - .25 * currencyNumber);
		}
		if(changeBalance >= .10) {
			currencyNumber = (int) (changeBalance / .10);
			totalChangeString += "¢10: " + currencyNumber + "\n";
			changeBalance = roundTwoDecimals(changeBalance - .10 * currencyNumber);
		}
		if(changeBalance >= .05) {
			currencyNumber = (int) (changeBalance / .05);
			totalChangeString += " ¢5: " + currencyNumber + "\n";
			changeBalance = roundTwoDecimals(changeBalance - .05 * currencyNumber);
		}
		if(changeBalance >= .01) {
			currencyNumber = (int) (changeBalance / .01);
			totalChangeString += " ¢1: " + currencyNumber + "\n";
			changeBalance = roundTwoDecimals(changeBalance - .01 * currencyNumber);
		}
		return totalChangeString;
	}
	
	//Method uses * / by 100 to move decimal places and Math.round() to do the actual rounding
	public static double roundTwoDecimals(double roundedNum) {
		roundedNum = Math.round(roundedNum * 100);
		roundedNum /= 100;
		return roundedNum;
	}
		
}
