package control_0Pattern.factory.cars.main;

import control_0Pattern.factory.cars.CarFactory;
import control_0Pattern.factory.cars.enums.CarType;
import control_0Pattern.factory.cars.types.Car;

public class MainFactoryPattern {
	
	public static void main(String[] args) {
		
		//INSTANTIATE
		CarFactory carFactory = new CarFactory();
		
		System.out.println("-------------PRINT1----------------");
		Car smallCar = carFactory.buildCar(CarType.SMALL);
		Car sedanCar = carFactory.buildCar(CarType.SEDAN);
		Car luxuryCar = carFactory.buildCar(CarType.LUXURY);
		
		System.out.println("\n-------------PRINT1----------------");
		System.out.println(smallCar.getModel());
		System.out.println(sedanCar.getModel());
		System.out.println(luxuryCar.getModel());

	
	}

}
