package control_2OO.Start_OO_week01e2.lampEnergyUsed_vProf;

public class Lamp {

	private boolean isOn;
	private double initialTime; // (ms)
	private double totalDuration; // (ms)
	private double power;		// (W)
	private double totalConsumption; // (W*h)

	public Lamp(double power) {
		this.power = power;
		isOn = false;
	}

	public void turnOn(){
		if(!isOn) {
			isOn = true;
			initialTime = System.currentTimeMillis();
		}
	}

	public void turnOff(){
		if(isOn) {
			isOn = false;
			double finalTime = System.currentTimeMillis();

			totalDuration += finalTime - initialTime; // ms
			totalConsumption = power * (totalDuration / (1000 * 60 * 60)); // (Wh)
		}
	}

	public void reset() {
		initialTime = 0;
		isOn = false;
		totalDuration = 0;
		totalConsumption = 0;
	}

	public double getTotalConsumption() {
		return totalConsumption;
	}

	public String toString() {
		String toReturn = "-------- Lamp is: ";
		if(isOn)
			toReturn += " ON -------\n";
		else
			toReturn += " OFF -------\n";
		
		toReturn += "Power: " + power + " W \n";
		toReturn += "Total Duration: " + totalDuration + " ms \n";
		toReturn += "Total Consumption: " + totalConsumption + " Wh \n";

		return toReturn;
	}
	
	
	
	
	
	

}
