package _03_Intro_to_Enums;

public enum StatesOfMatter {

	 SOLID(0), LIQUID(25.55), GAS(100);
	
	private double celsiusTemp;
	
	private StatesOfMatter(double celsiusTemp) {
		this.celsiusTemp = celsiusTemp;
	}
	
	public double getCelsiusTemp() {
		return celsiusTemp;
	}
	
	public void setCelsiusTemp(double celsiusTemp) {
		this.celsiusTemp = celsiusTemp;
	}
	
	public double convertToFahrenheit() {
		return (celsiusTemp * 9/5) + 32;
	}
}