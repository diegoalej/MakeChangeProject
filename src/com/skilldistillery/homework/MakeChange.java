package com.skilldistillery.homework;
import java.util.Scanner;
/**
 * Java program to calculate and output exact currency change  
 * Program takes input for item price and cash tendered and 
 * outputs the exact amount of change on the screen. 
 * @author  Diego Hoyos  
 */
public class MakeChange {
	/**
	 * Main method initiates Scanner and makes use of the getTotalChange() method to get a 
	 * balance and getChange() method to test for errors and calculate and output exact change
	 */
	public static void main(String[] args) {
// Uncomment lines 22 and 25 to run on infinite loop
			Scanner kb = new Scanner(System.in);		
//		while(true) {
			double totalChange = getTotalChange(kb);
			getChange(totalChange);
//		if(totalChange < -1000)break;}
			kb.close();			
	}// End Main	
	/**
	 * Takes user iput and returns the difference of the item price and amount tendered
	 * @param Scanner object passed in from main
	 * @return double with total amount of change or underpayment
	 */
	private static double getTotalChange(Scanner kb) {
		System.out.print("Enter item price: ");		
		double priceOfItem = kb.nextDouble();
		System.out.print("Enter amount tendered: ");
		double amountTendered = kb.nextDouble();
		double totalChange = amountTendered - priceOfItem;
		return totalChange;
	}
	/**
	 * Method includes tests cases for exact payment, underpayment, or calls 
	 * getChangeString() to figure out exact change and output messages accordingly 
	 * @param totalChange is the balance of item price minus payment amount
	 * @return nothing
	 */
	private static void getChange(double totalChange) {
		if (totalChange < 0) { // Conditional testing for underpayment
			System.out.println("Not enough, you are $" + (roundTwoDecimals(totalChange) * -1)
					+ " short for purchasing this item.");
		} else if (totalChange == 0) { // Conditional testing for exact amount
			System.out.println("Exact payment, thanks!");
		} else {// Else get exact change and print out result
			String changeBreakdown = getChangeString(roundTwoDecimals(totalChange));
			System.out.println(changeBreakdown);
		}
	}
	/**
	 * Method tests different currency denominations from biggest to smallest 
	 * to calculate exact change and output accordingly
	 * @param changeBalance is the total amount of change to be broken down
	 * @return String with change breakdown
	 */
	private static String getChangeString(double changeBalance) {
		String totalChangeString = "Here's your change breakdownfor $" + changeBalance + "\n";
		int currencyNumber;
		if (changeBalance >= 20) { // test to see if balance is more than denomination
			currencyNumber = (int) (changeBalance / 20); // find out the number of bills/coins needed
			totalChangeString += "$20: " + currencyNumber + "\n"; // concatenate the denomination and number of bills to return string
			changeBalance = roundTwoDecimals(changeBalance - 20 * currencyNumber); // update the change balance 
		}
		if (changeBalance >= 10) {
			currencyNumber = (int) (changeBalance / 10);
			totalChangeString += "$10: " + currencyNumber + "\n";
			changeBalance = roundTwoDecimals(changeBalance - 10 * currencyNumber);
		}
		if (changeBalance >= 5) {
			currencyNumber = (int) (changeBalance / 5);
			totalChangeString += " $5: " + currencyNumber + "\n";
			changeBalance = roundTwoDecimals(changeBalance - 5 * currencyNumber);
		}
		if (changeBalance >= 1) {
			currencyNumber = (int) (changeBalance / 1);
			totalChangeString += " $1: " + currencyNumber + "\n";
			changeBalance = roundTwoDecimals(changeBalance - 1 * currencyNumber);
		}
		if (changeBalance >= .25) {
			currencyNumber = (int) (changeBalance / .25);
			totalChangeString += "¢25: " + currencyNumber + "\n";
			changeBalance = roundTwoDecimals(changeBalance - .25 * currencyNumber);
		}
		if (changeBalance >= .10) {
			currencyNumber = (int) (changeBalance / .10);
			totalChangeString += "¢10: " + currencyNumber + "\n";
			changeBalance = roundTwoDecimals(changeBalance - .10 * currencyNumber);
		}
		if (changeBalance >= .05) {
			currencyNumber = (int) (changeBalance / .05);
			totalChangeString += " ¢5: " + currencyNumber + "\n";
			changeBalance = roundTwoDecimals(changeBalance - .05 * currencyNumber);
		}
		if (changeBalance >= .01) {
			currencyNumber = (int) (changeBalance / .01);
			totalChangeString += " ¢1: " + currencyNumber + "\n";
			changeBalance = roundTwoDecimals(changeBalance - .01 * currencyNumber);
		}
//		System.out.println("Change balance at the end of method getChangeString: " + changeBalance);
		return totalChangeString;
	}
	/**
	 * Method uses multiplication and division as well as Math.round()
	 * to round and limit decimal places to two 
	 * @param roundedNum is the running change balance that needs to be rounded
	 * @return Double with only two decimal places
	 */
	public static double roundTwoDecimals(double roundedNum) {
		roundedNum = Math.round(roundedNum * 100);
		roundedNum /= 100;
		return roundedNum;
	}

}
