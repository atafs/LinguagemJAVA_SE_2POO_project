package control_2OO.Start_OO_week01e2.lampEnergyUsed_v1;

public class Lamp {

	// ATRIBUTES
	private boolean on;
	private boolean off;

	private double power;
	private int numberLamp;
	
	private double turnLampOn;
	private double turnLampOff;
	private double durationOnTime;
	private double totalConsumptionTime;

	// CONSTRUCTOR
	public Lamp(double power, int numberLamp) {
		this.power = power;
		this.numberLamp = numberLamp;
	}

	// GETTERS AND SETTERS
	public boolean isOn() {
		return on;
	}

	public void setOn() {
		this.on = true;
	}

	public boolean isOff() {
		return off;
	}

	public void setOff() {
		this.off = false;
	}

	public double getLampOnTime() {
		return turnLampOn;
	}

	public void setLampOnTime() {
		this.turnLampOn = System.currentTimeMillis();
		on = true;
	}

	public double getLampOffTime() {
		return turnLampOff;
	}

	public void setLampOffTime() {
		this.turnLampOff = System.currentTimeMillis();
		off = true;
	}

	// OTHER METHODS
	/** RETURN the value during witch the lamp was on */
	public double calcDurationOnTime() {
		double temp = (turnLampOff - turnLampOn);
		return durationOnTime += temp / (1000*60*60);
	}

	/** RETURN the value in Watt per hour of the power used */
	public double calcConsuption() {
		//convert to watt per hour
		return totalConsumptionTime = power * durationOnTime;
	}
	
	//ToSTRING
	@Override
	public String toString() {
		String result = "------------ LAMP" + numberLamp + " -------------\n";
		result += "ON: " + on + "\n";
		result += "OFF: " + off + "\n";
		result += "POWER: " + power + ";[Watt]\n";
		result += "TURN_LAMP_ON: " + turnLampOn + "\n";
		result += "TURN_LAMP_OFF: " + turnLampOff + "\n";
		result += "DURATION: " + durationOnTime + "; [ms]\n\n";
		result += "TOTAL_CONSUMPTION_TIME: " + totalConsumptionTime + ";[Watt per hour];\n";

		return result;
	}

}
