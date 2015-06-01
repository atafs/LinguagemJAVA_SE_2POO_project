package exame_modelo.exercicio3.class_2extends;

import java.util.List;

import exame_modelo.exercicio3.account.Movement;
import exame_modelo.exercicio3.class_1abstract.Account;

public class AccountX extends Account {
	
	//ATTRIBUTES
	/* ----------DATA IMPUT--------------- */
	private static final double METADE_SALDO_CONTA = 0.5;
	/* ----------END INPUT---------------- */

	public AccountX(String id, String client, List<Movement> movements) {
		super(id, client, movements);
	}

	@Override
	public double saldoMedioEstimado() {
		double average = 0.0;
		
		/* TODO = 1/2 saldo actual 
			- ultimo movimento, 
			- assumido que: ordenado por ordem crescente de data
		*/
		if (this.getMovements().size() == -1) {
			return 0.0;
		}
		int last = this.getMovements().size()-1;
		Movement lastMov = getMovements().get(last);
		average = lastMov.getAmount()*METADE_SALDO_CONTA;
		
		return average;
	}

}
