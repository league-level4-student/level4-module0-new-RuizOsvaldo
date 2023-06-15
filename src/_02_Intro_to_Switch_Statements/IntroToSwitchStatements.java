package _02_Intro_to_Switch_Statements;

import java.util.Random;

import javax.swing.JOptionPane;

public class IntroToSwitchStatements {
	public static void main(String[] args) {

		/*
		 * A Switch Statement is an alternative to writing an if-else statement that can
		 * only check against a single value of type: byte, Byte, short, Short, int,
		 * Integer, char, Character, String or enum.
		 */

		int x = Integer.parseInt(JOptionPane.showInputDialog("Enter a number."));

		// Note: The following two blocks of code are logically the same.

		if (x == 0) {
			System.out.println("0 from if-else");
		} else if (x == 1) {
			System.out.println("1 from if-else");
		} else if (x == 2) {
			System.out.println("2 from if-else");
		} else {
			System.out.println("Out of bounds from if-else");
		}

		switch (x) {

		case 0:
			System.out.println("0 from switch");
		case 1:
			System.out.println("1 from switch");
		case 2:
			System.out.println("2 from switch");
		default:
			System.out.println("Out of bounds from switch");
		}

		// 1. Run the program and get all the possible results in the console.

		// 2. Remove the break; statements in the switch statments and repeat step 1.

		// 3. Uncomment the following code.

		String c = JOptionPane.showInputDialog("Enter a color.");

		if (c.equals("red")) {
			System.out.println("red from if-else");
		} else if (c.equals("green")) {
			System.out.println("green from if-else");
		} else if (c.equals("blue")) {
			System.out.println("blue from if-else");
		} else {
			System.out.println("Not RGB from if-else");
		}

		// 4. Write a switch statement that is logically equivalent to the if-else.
		// Note: Don't forget to add breaks after each case to avoid fall through.

		switch (c) {

		case "red":
			System.out.println("red from switch");
			break;
		case "green":
			System.out.println("green from switch");
			break;
		case "blue":
			System.out.println("blue from switch");
			break;
		default:
			System.out.println("Not RGB from switch");
			break;
		}

		// 5. Run the code to make sure the if-else and switch match for each value.
	}
}