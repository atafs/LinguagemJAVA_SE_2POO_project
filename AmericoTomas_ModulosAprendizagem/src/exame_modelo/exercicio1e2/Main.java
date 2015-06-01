package exame_modelo.exercicio1e2;

import java.util.ArrayList;
import java.util.Collections;

import exame_modelo.exercicio1e2.comparator.ComparatorGeneral;


public class Main {
	
	//ATTRIBUTES
	/* ----------DATA IMPUT--------------- */
	private static final int MAX_CARS = 5;
	/* ----------END INPUT---------------- */

	public static void main(String[] args) {

		//INSTANTIATE LIST: ARRAY
		ArrayList<Car> cars = new ArrayList<>();
		
		//INSTANTIATE CLASS CAR
		System.err.println("--------LIST OF CARS - INSTANTIATE--------");
		for (int i = 0; i < MAX_CARS; i++) {
			int random2000_2009 = (2000 + (int)(Math.random()*9));
			Car car = new Car("Car" + i, random2000_2009);	
			cars.add(car);
			System.err.println(car.toString());
		}
		paragraph();
		
		//COLLECTIONS
		Collections.sort(cars, new ComparatorGeneral());
		System.out.println("--------LIST OF CARS - SORT--------");
		for (Car car : cars) {
			System.out.println(car.toString());

		}
		
	}
	
	//PARAGRAPH
	public static void paragraph() {
		System.out.println("");
	}

}
