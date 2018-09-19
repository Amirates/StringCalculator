package com.haynespro.calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class CharAtExample {

	public static void main(String[] args) {

		// inputString with scanner

		String inputString = "0";

		inputString = inputString.replace(",", "");

		Scanner user_input = new Scanner(System.in);

		System.out.print("please insert your calcualtions: ");

		inputString = user_input.next();

		user_input.close();

		// Assign ArrayList of Strings "res" to splitExpression

		ArrayList<String> res = splitExpression(inputString);

		// Create an ObjectList that holds res

		ArrayList<Object> objectList = new ArrayList<Object>(res);

		System.out.print("\nLet my algorithm take care of it: \n\n");

		// Loop through the objectList and convert strings to doubles

		for (int i = 0; i < objectList.size(); i++) {
			try {
				objectList.set(i, Double.parseDouble((String) objectList.get(i)));
			} catch (NumberFormatException nfe) {

			}
		}

		// Create a variable maxi to substract 2 from the objectList index

		int maxi = objectList.size();

		maxi = maxi - 2;

		// Create variable lastSum out of the incoming for-loop's scope.

		double lastSum = 0;

		// Loop through the objectList with an algorhitm and perform calculations with
		// invoking the sum method

		for (int i = 0; i < maxi; i += 2) {
			String operator = (String) objectList.get(i + 1);
			double a = (Double) objectList.get(i);
			double b = (Double) objectList.get(i + 2);
			double sum;

			if (i == 0) {
				sum = sum(a, b, operator);
			} else {
				sum = sum(lastSum, b, operator);
			}
			lastSum = sum;
			System.out.println(lastSum);
		}

	}

	// Method that matches the string input with operators to perform calculations.

	private static double sum(Double a, Double b, String operator) {

		if (operator.equals("+")) {
			return a + b;
		}
		if (operator.equals("-")) {
			return a - b;
		}
		if (operator.equals("*")) {
			return a * b;
		}
		if (operator.equals("/")) {
			return a / b;
		}
		return 0;
	}

	// ArrayList splitExpression that casts to inputString

	private static ArrayList<String> splitExpression(String inputString) {

		// ArrayList result to return the result

		ArrayList<String> result = new ArrayList<String>();

		// Uses the toCharArray method to insert the string reference per character into
		// an array

		char[] destArray = inputString.toCharArray();

		// Empty String created

		String token = "";

		// Iterate through the "Items" in the Array

		for (int i = 0; i < destArray.length; i++) {

			// Nice all those references but we need an Object that actually holds the array

			char c = destArray[i];

			// If not a number then add to token, else assign the value of c to token

			if (isBreakCharacter(c)) {
				result.add(token);
				result.add(Character.toString(c));
				token = "";
			} else
				token = token + c;

		}

		result.add(token);
		return result;
	}

	// a method that breaks characters which are not numbers.The object "c" also
	// needs to hold this method.

	public static boolean isBreakCharacter(char c) {
		return c == '+' || c == '*' || c == '-' || c == '/';
	}

}
