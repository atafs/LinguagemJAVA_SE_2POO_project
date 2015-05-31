package exame_modelo.exercicio2;

import java.util.LinkedList;

import exame_modelo.exercicio2.account.Data;
import exame_modelo.exercicio2.account.Movement;
import exame_modelo.exercicio2.class_1abstract.Account;
import exame_modelo.exercicio2.class_2extends.AccountX;
import exame_modelo.exercicio2.class_2extends.AccountY;

public class Main {

	public static void main(String[] args) {

		//INSTANTIATE
		Account account1 = new AccountX("0", "Americo", new LinkedList<Movement>() );
		//Account account2 = new AccountX("1", "Tomas", new LinkedList<Movement>() );
		
		Data data0 = new Data();
		data0.setAno(2015);
		data0.setMes(06);
		data0.setDia(14);
		account1.getMovements().add(new Movement(data0, "first movement", 154.23));
		
		Data data1 = new Data();
		data1.setAno(2015);
		data1.setMes(06);
		data1.setDia(20);
		account1.getMovements().add(new Movement(data1, "receive from IRS", 1544.23));
		
		Data data2 = new Data();
		data2.setAno(2015);
		data2.setMes(06);
		data2.setDia(26);
		account1.getMovements().add(new Movement(data2, "salary from work", 11154.23));
		
		Data data3 = new Data();
		data3.setAno(2015);
		data3.setMes(06);
		data3.setDia(29);
		account1.getMovements().add(new Movement(data3, "la carte", 754.23));
		
		System.out.println("--------ACCOUNT_X_MOVEMENTS--------");
		for (Movement mov : account1.getMovements()) {
			System.out.println(mov.toString());
		}
		
		//
		System.err.println("--------ACCOUNT_X_SALDO--------");
		System.err.println(account1.saldoMedioEstimado());
		
		//SLEEP
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/* ********************************************************** */

		//INSTANTIATE
				Account account2 = new AccountY("1", "Tomas", new LinkedList<Movement>() );
				//Account account2 = new AccountX("1", "Tomas", new LinkedList<Movement>() );
				
				Data data5 = new Data();
				data5.setAno(2015);
				data5.setMes(06);
				data5.setDia(14);
				account2.getMovements().add(new Movement(data5, "first movement", 154.23));
				
				Data data6 = new Data();
				data6.setAno(2015);
				data6.setMes(06);
				data6.setDia(20);
				account2.getMovements().add(new Movement(data6, "receive from IRS", 1544.23));
				
				Data data7 = new Data();
				data7.setAno(2015);
				data7.setMes(06);
				data7.setDia(26);
				account2.getMovements().add(new Movement(data7, "salary from work", 11154.23));
				
				Data data8 = new Data();
				data8.setAno(2015);
				data8.setMes(06);
				data8.setDia(29);
				account2.getMovements().add(new Movement(data8, "la carte", 754.23));
				
				System.out.println("--------ACCOUNT_Y_MOVEMENTS--------");
				for (Movement mov : account2.getMovements()) {
					System.out.println(mov.toString());
				}
				
				//
				System.err.println("--------ACCOUNT_Y_SALDO--------");
				System.err.println(account2.saldoMedioEstimado());


	}

}
