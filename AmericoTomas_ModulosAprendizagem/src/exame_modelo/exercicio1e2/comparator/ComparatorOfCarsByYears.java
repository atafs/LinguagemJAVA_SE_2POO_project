package exame_modelo.exercicio1e2.comparator;

import java.util.Comparator;

import exame_modelo.exercicio1e2.Car;

public class ComparatorOfCarsByYears implements Comparator<Car>{

	@Override
	public int compare(Car car1, Car car2) {
		//TODO americoLIB: ERROR (int vs Integer (Wrapper Class))
		//return (Integer)car1.getYearOfConstruction().compareTo((Integer)car2.getYearOfConstruction());
		
		//LOCAL VARIABLES
		Integer car1Year = (Integer)car1.getYearOfConstruction();
		Integer car2Year = (Integer)car2.getYearOfConstruction();
			
		//INTEGER
		return car1Year.compareTo(car2Year);//CRESCENTE
	}

}
