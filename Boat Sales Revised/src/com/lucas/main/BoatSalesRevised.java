package com.lucas.main;

import java.text.NumberFormat;
import java.util.Scanner;

public class BoatSalesRevised {
	
	static String iBoatType, oBoatType, iBoatCost, iQty, oAccType, iAccType, iPrepCost, oBoatCost, oAccCost, oPrepCost, oTotBoatCost, oSubtotal, oTax, oTotal, keepGoing = "Y";
	static int cAccType, cQty;
	static double cTotal, cTax, cSubtotal, cBoatCost, cMarkupAmt, cAccCost, cPrepCost, cMarkupCost, cTotBoatCost;
	static Scanner scanner;
	static NumberFormat nf;
	static boolean isValid = true;
	
	public static void main(String[] args) {
		init();
		
		input();
		
		calcs();
		
		output();
	}
	
	public static void init() {
		scanner = new Scanner(System.in);
		scanner.useDelimiter(System.getProperty("line.separator"));
		nf = NumberFormat.getCurrencyInstance(java.util.Locale.US);
	}
	
	public static void input() {
		do {
			try {
				System.out.print("Please enter the amount of boats you would like between 1 - 25: ");
				iQty = scanner.next();
				cQty = Integer.parseInt(iQty);
			} catch (Exception e){
				System.out.print("Must be a valid integer.");
			}
			if (cQty < 1) {
				System.out.println("Incorrect amount. Please enter again.");
				isValid = false;
			} else if (cQty > 25) {
				System.out.println("Incorrect amount. Please enter again.");
				isValid = false;
			} else {
				isValid = true;
			}
		} while (isValid == false);
		
		do {
			//Gets the amount of boats
			System.out.print("Please enter the type of boat you would like, 'B' for Bass, 'P' for Pontoon, 'S' for Ski, 'C' for Canoe: ");
			iBoatType = scanner.next();
		
			switch (iBoatType.toUpperCase()) {
		case "B":
			oBoatType = "Bass";
			cMarkupAmt = 0.33;
			isValid = true;
			break;
		case "P":
			oBoatType = "Pontoon";
			cMarkupAmt = 0.25;
			isValid = true;
			break;
		case "S":
			oBoatType = "Ski";
			cMarkupAmt = 0.425;
			isValid = true;
			break;
		case "C":
			oBoatType = "Canoe";
			cMarkupAmt = 0.20;
			isValid = true;
			break;
		default:
			System.out.println("Please enter a correct boat type.");
			isValid = false;
		}
		
		} while(isValid == false);
		
		do {
			try {
				//Gets the price of all the boats
				System.out.print("Enter the price of the boat, between $2,500 - $150,000: ");
				iBoatCost = scanner.next();
				cBoatCost = Double.parseDouble(iBoatCost);
			} catch (Exception e) {
				System.out.println("Please enter valid number data.");
			}
			
			if (cBoatCost < 2500.00) {
				System.out.println("Invalid price.");
				isValid = false;
			} else if (cBoatCost > 150000.00) {
				System.out.println("Invalid price.");
				isValid = false;
			} else {
				isValid = true;
			}
			
		} while (isValid == false);
		
		do {
			try {
				System.out.print("Please enter the accessory you would like. '1' for Electronics, '2' for Ski Package, '3' for Fishing Package: ");
				iAccType = scanner.next();
				cAccType = Integer.parseInt(iAccType);
			} catch (Exception e) {
				System.out.println("Non-numeric data entered, please enter numeric data.");
			}
			switch (cAccType) {
			case 1:
				oAccType = "Electronics";
				cAccCost = 5415.30;
				isValid = true;
				break;
			case 2:
				oAccType = "Ski Package";
				cAccCost = 3980.00;
				isValid = true;
				break;
			case 3:
				oAccType = "Fishing Package";
				cAccCost = 345.45;
				isValid = true;
				break;
			default:
				isValid = false;
				System.out.println("Invalid code. Please enter a correct number.");
			}
		} while (isValid == false);
		
		do {
			try {
				System.out.print("Enter the price of the prep: ");
				iPrepCost = scanner.next();
				cPrepCost = Double.parseDouble(iPrepCost);
			} catch (Exception e) {
				System.out.println("Non-numeric data entered. Please enter numeric data.");
			}
			if (cPrepCost < 100.00) {
				isValid = false;
				System.out.println("Invalid cost.");
			} else if (cPrepCost > 9999.99) {
				isValid = false;
				System.out.println("Invalid cost.");
			} else {
				isValid = true;
			}
		} while (isValid == false);
		
	}
	
	public static void calcs() {
		cMarkupCost = (cMarkupAmt * cBoatCost);
		cTotBoatCost = cMarkupCost + cBoatCost;
		cSubtotal = cTotBoatCost + cPrepCost + cAccCost;
		cTax = cSubtotal * 0.06;
		cTotal = cSubtotal + cTax;
	}
	
	public static void output() {
		oBoatCost = nf.format(cBoatCost);
		oAccCost = nf.format(cAccCost);
		oPrepCost = nf.format(cPrepCost);
		oTotBoatCost = nf.format(cTotBoatCost);
		oSubtotal = nf.format(cSubtotal);
		oTax = nf.format(cTax);
		oTotal = nf.format(cTotal);
		
		System.out.println("Your reciept is:");
		System.out.println(oBoatType +  ", " + oAccType + ", " + iQty + ", Boat Cost: " + oBoatCost + ", Accessory Cost " + oAccCost + ", Prep Cost: " + oPrepCost + ", Markup Cost: " + oTotBoatCost + ", Subtotal: " + oSubtotal + ", Tax: " + oTax + ", Total: " + oTotal);
		
		do {
			System.out.print("Would you like to print another receipt? Y for yes, N for no. ");
			keepGoing = scanner.next();
			
			switch (keepGoing.toUpperCase()) {
			case "Y":
				main(null);
				break;
			case "N":
				System.out.println("Program terminated.");
				System.exit(0);
				break;
			default:
				System.out.println("Please enter a Y or an N");
			}
		} while (keepGoing != "N" && keepGoing != "Y");
	}
	
	
}
