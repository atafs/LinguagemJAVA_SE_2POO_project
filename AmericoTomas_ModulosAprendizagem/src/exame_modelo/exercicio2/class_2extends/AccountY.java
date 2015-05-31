package exame_modelo.exercicio2.class_2extends;

import java.util.List;

import exame_modelo.exercicio2.account.Data;
import exame_modelo.exercicio2.account.Movement;
import exame_modelo.exercicio2.class_1abstract.Account;

public class AccountY extends Account {

	public AccountY(String id, String client, List<Movement> movements) {
		super(id, client, movements);
	}

	@Override
	public double saldoMedioEstimado() {
		double average = 0.0;
		Movement lastMov = new Movement();
		lastMov.getData().setAno(2015);
		lastMov.getData().setMes(06);
		lastMov.getData().setDia(14);

		
		//CREATE LIST (Array for efficency)
		//TODO HARDCODING... TO FIX
		
		//int last = this.getMovements().size()-1;
		//int totalRecords = last + 1;//zero counts
		double[] averages = new double[4];
		
		//LOOP ALL VALUES
		int i = 0;//iterator
		for (Movement movement : getMovements()) {

//			//ASSUME: THAT THIS LIST IS CLEANED EVERY MONTH
//			if (lastMov.getData().equals(null)) {//FIRST RECORD
//				lastMov = movement;
//			}
			
			/* TODO: media de saldos
			- numero de dias em que cada um esteve depositado
			- differencaEmDiasEntre(Data data1, Data data2)
			 */
			
		
			int days = Data.differenceEmDiasEntre(lastMov.getData(), movement.getData());
			if (days == 0) {
				return movement.getAmount();
			}
			average = movement.getAmount()/days;
			averages[i] = average;
			i++;
		}
		
		//MAKE THE CALCULATION OF VALUES
		double totalValuesList = 0.0;
		for (int j = 0; j < averages.length; j++) {
			totalValuesList += averages[j];
		}
		average = totalValuesList / averages.length;
		
		return average;
	}

}
