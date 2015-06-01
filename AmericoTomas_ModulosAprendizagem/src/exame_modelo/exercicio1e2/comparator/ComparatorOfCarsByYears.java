package exame_modelo.exercicio1e2.comparator;

import java.util.Comparator;

import exame_modelo.exercicio1e2.Car;

public class ComparatorOfCarsByYears implements Comparator<Car>{

	@Override
	public int compare(Car car1, Car car2) {
		//TODO americoLIB: ERROR (int vs Integer (Wrapper Class))
		//return (Integer)car1.getYearOfConstruction().compareTo((Integer)car2.getYearOfConstruction());

		//Integer
		Integer car1Int = (Integer)car1.getYearOfConstruction();
		Integer car2Int = (Integer)car2.getYearOfConstruction();
				
		return car1Int.compareTo(car2Int);
	}

}
