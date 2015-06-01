package exame_modelo.exercicio1.comparator;

import java.util.Comparator;

import exame_modelo.exercicio1.Car;

public class ComparatorGeneral implements Comparator<Car>{

	@Override
	public int compare(Car car1, Car car2) {
		ComparatorOfCarsByYears compYear = new ComparatorOfCarsByYears();
		ComparatorOfCarsNicknames compPlate = new ComparatorOfCarsNicknames();
		
		if(compYear.compare(car1, car2) != 0){
			//CRESCENTE
			return compYear.compare(car1, car2);
		
		} else {
			//DECRESCENTE
			return compPlate.compare(car2, car1);
		}
	}

}
