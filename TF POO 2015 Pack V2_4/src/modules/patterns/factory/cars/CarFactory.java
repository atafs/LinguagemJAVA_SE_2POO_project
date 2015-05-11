package modules.patterns.factory.cars;

import modules.patterns.factory.cars.enums.CarType;
import modules.patterns.factory.cars.types.Car;
import modules.patterns.factory.cars.types.LuxuryCar;
import modules.patterns.factory.cars.types.SedanCar;
import modules.patterns.factory.cars.types.SmallCar;

public class CarFactory {

	/** DESCRIPTION: static method that return a Car */
	public Car buildCar(CarType model) {
		Car car = null;
		switch (model) {
		case SMALL:
			car = new SmallCar();
			break;

		case SEDAN:
			car = new SedanCar();
			break;

		case LUXURY:
			car = new LuxuryCar();
			break;

		default:
			// throw some exception
			break;
		}
		return car;
	}

}
