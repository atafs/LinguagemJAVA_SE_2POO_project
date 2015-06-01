package exame_modelo.exercicio3e4.class_1abstract;

import java.util.List;
import java.util.LinkedList;

import exame_modelo.exercicio3e4.account.Movement;

//ABSTRACT
public abstract class Account {
	
	//ATTRIBUTES
	private String id;
	private String client;
	private List<Movement> movements = new LinkedList<Movement>();

	//CONSTRUCTOR
	public Account(String id, String client, List<Movement> movements) {
		this.id = id;
		this.client = client;
		this.movements = movements;
	}
	
	//GETTERS AND SETTERS
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public List<Movement> getMovements() {
		return movements;
	}

	public void setMovements(List<Movement> movements) {
		this.movements = movements;
	}

	//ABSTRACT METHOD
	public abstract double saldoMedioEstimado();

}
