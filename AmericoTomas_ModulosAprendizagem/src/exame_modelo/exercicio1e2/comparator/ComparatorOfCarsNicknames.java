package exame_modelo.exercicio1e2.comparator;

import java.util.Comparator;

import exame_modelo.exercicio1e2.Car;

public class ComparatorOfCarsNicknames implements Comparator<Car>{

	@Override
	public int compare(Car car1, Car car2) {
		
		//LOCAL VARIABLES
		String car1Plate = car1.getNickName();
		String car2Plate = car2.getNickName();	
		
		//STRING
		return car2Plate.compareTo(car1Plate);//DECRESCENTE
	}

}
