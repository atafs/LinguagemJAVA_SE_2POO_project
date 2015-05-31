package exame_modelo.exercicio1.comparator;

import java.util.Comparator;

import exame_modelo.exercicio1.Car;

public class ComparatorOfCarsNicknames implements Comparator<Car>{

	@Override
	public int compare(Car car1, Car car2) {
		//STRING
		return car1.getNickName().compareTo(car2.getNickName());
	}

}
