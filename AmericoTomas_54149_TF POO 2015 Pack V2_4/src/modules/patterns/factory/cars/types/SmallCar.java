package modules.patterns.factory.cars.types;

import modules.patterns.factory.cars.enums.CarType;

public class SmallCar extends Car{

	public SmallCar() {
		super(CarType.SMALL);
		construct();
	}

	@Override
	public void construct() {
		System.out.println("Building small car");
		// add accessories
	}
}
