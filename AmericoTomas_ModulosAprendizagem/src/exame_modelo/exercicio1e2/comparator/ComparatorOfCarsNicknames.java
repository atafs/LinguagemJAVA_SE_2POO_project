package exame_modelo.exercicio1e2.comparator;

import java.util.Comparator;

import exame_modelo.exercicio1e2.Car;

public class ComparatorOfCarsNicknames implements Comparator<Car>{

	@Override
	public int compare(Car car1, Car car2) {
		//STRING
		return car1.getNickName().compareTo(car2.getNickName());
	}

}
