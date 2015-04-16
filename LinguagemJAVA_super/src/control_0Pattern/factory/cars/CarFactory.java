package control_0Pattern.factory.cars;

import control_0Pattern.factory.cars.enums.CarType;
import control_0Pattern.factory.cars.types.Car;
import control_0Pattern.factory.cars.types.LuxuryCar;
import control_0Pattern.factory.cars.types.SedanCar;
import control_0Pattern.factory.cars.types.SmallCar;

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
