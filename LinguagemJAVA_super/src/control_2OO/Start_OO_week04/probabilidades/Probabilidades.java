/** 
 * americoLIB concept 
 * @author Americo Tomas (atafs): 05/03/2015 
 */

package control_2OO.Start_OO_week04.probabilidades;

public class Probabilidades {

	//ATTRIBUTES
	private double value;

	//CONSTRUCTOR
	public Probabilidades(double value) {

		if (value < 0 || value > 1) {
			throw new IllegalArgumentException(
					"ERROR: o numero tem de estar entre 0 e 1");
		}

		this.value = value;
	}

	public double doubleValue() {
		return value;
	}

	public float floatValue() {
		return (float) value;
	}

	public int intValue() {
		return (int) Math.round(value);
	}

	public long longValue() {
		return (long) value;
	}
	
	

}
