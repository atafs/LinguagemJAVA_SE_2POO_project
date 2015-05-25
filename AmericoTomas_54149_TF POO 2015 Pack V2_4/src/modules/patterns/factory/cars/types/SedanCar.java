package modules.patterns.factory.cars.types;

import modules.patterns.factory.cars.enums.CarType;

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
