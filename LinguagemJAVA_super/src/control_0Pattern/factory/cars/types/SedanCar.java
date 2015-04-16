package control_0Pattern.factory.cars.types;

import control_0Pattern.factory.cars.enums.CarType;

public class SedanCar extends Car{

	public SedanCar() {
		super(CarType.SEDAN);
		construct();
	}

	@Override
	public void construct() {
		System.out.println("Building sedan car");
		// add accessories
	}
}
