package _00_Intro_To_Encapsulation;

public class IntroToEncapsulation {

	public static void main(String[] args) {

		/*
		 * Encapsulation is the process of wrapping together related members(methods and
		 * variables) under the umbrella of a single class and limiting access from
		 * outside classes.
		 */

		// 1. Create a Vehicle object.
		Vehicle v = new Vehicle();
		// 2. Use the vehicle's setters to change fuelTankCapacity and mpg.
		v.setFuelTankCapacity(10);
		v.setMpg(40);
		// 3. Call setFuelInTank with an amount greater than the capacity.
		v.setFuelInTank(20);
		// Note: The reason setFuelInTank doesn't show up is because it's private.
		
		// 4. Modify setFuelInTank's access modifier so you can use it.
		// Hint: Access modifiers are described at the top of the Vehicle class.

		// 5. Create a setter for the vehicle's color then set its color using it.
		v.setColor("blue");
		// 6. Create local variables for fuelTankCapacity, fuelInTank and mpg.
		int fuelTankCapacity;
		int fuelInTank;
		int mpg;
		// 7. Use the vehicle's getters to initialize all of them.
		// Note: You may need to fix some access modifiers.
		fuelTankCapacity = v.getFuelTankCapacity();
		fuelInTank = v.getFuelInTank();
		mpg = v.getMpg();
		// 8. Create a getter for color and do the same thing you did for steps 6 & 7.
		String color = v.getColor();
		// 9. Print out all the local variables.
		System.out.println(fuelTankCapacity);
		System.out.println(fuelInTank);
		System.out.println(mpg);
		System.out.println(color);
		// 10. If you haven't already, completely encapsulate the Vehicle class.
		// Hint: Make all member variables private and all getters/setters public.

		// 11. Drive the vehicle until it runs out of gas.
		while(v.getFuelInTank() > 0) {
			v.drive();
		}
	}

}

class Vehicle {

	// There are four possible access modifiers in Java:

	// public makes the member accessible from anywhere in the project.

	private int fuelTankCapacity;

	// private makes the member accessible only within the class.

	private int fuelInTank;

	// protected makes the member accessible only to subclasses and the package.

	private String color;

	// no access modifier makes the member accessible only to the package.

	private int mpg;

	// A setter changes a member variable.

	public void setMpg(int mpg) {
		this.mpg = mpg;
	}
	
	public void setColor(String color) {
		this.color = color;
	}

	// More complex setters can be created if you want to limit changes to members.

	public void setFuelTankCapacity(int fuelTankCapacity) {
		if (fuelTankCapacity >= 1) {
			this.fuelTankCapacity = fuelTankCapacity;
		} else {
			System.out.println("Invalid fuel tank capacity. Capacity set to 1.");
			this.fuelTankCapacity = 1;
		}
	}

	public void setFuelInTank(int fuelInTank) {

		if (fuelInTank >= 0 && fuelInTank <= fuelTankCapacity) {

			this.fuelInTank = fuelInTank;

		} else {

			System.out.println("Invalid amount of fuel. Tank set to full.");
			this.fuelInTank = fuelTankCapacity;
		}

	}

	// A getter returns a member variable.

	public int getFuelTankCapacity() {
		return fuelTankCapacity;
	}

	public int getFuelInTank() {

		return fuelInTank;

	}

	public int getMpg() {
		return mpg;
	}
	
	public String getColor() {
		return color;
	}

	public void drive() {

		if (fuelInTank > 0) {
			System.out.println("I'm driving my " + color + " vehicle " + mpg + " miles.");
			setFuelInTank(fuelInTank - 1);
			System.out.println(fuelInTank + "/" + fuelTankCapacity + " gallons left.");
		}

		if (fuelInTank == 0) {
			System.out.println("I'm out of gas.");
		}
	}
}
