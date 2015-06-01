package exame_modelo.exercicio3.account;

public class Movement {
	
	//ATTRIBUTES
	private Data data;//data
	private Data value;//dataValor
	private String description;//descricao
	private double amount;//quantiaMovimentada
	private double balanceContabilistico;//saldo contabilistico
	private double balanceCorrente;//saldo corrente
	private Category type;//categoria
	
	//CONSTRUCTOR
	public Movement(Data data, Data value, String description, double amount,
			double balanceContabilistico, double balanceCorrente, Category type) {
		this.data = new Data();
		this.value = new Data();
		this.description = "";
		this.amount = 0.0;
		this.balanceContabilistico = 0.0;
		this.balanceCorrente = 0.0;
		this.type = new Category();
	}
	
	public Movement(Data data, String description, double amount) {
		this.data = data;
		this.description = description;
		this.amount = amount;
	}
	
	public Movement() {
		this.data = new Data();
		this.value = null;
		this.description = "";
		this.amount = 0.0;
		this.balanceContabilistico = 0.0;
		this.balanceCorrente = 0.0;
		this.type = null;
	}
	
	//TOSTRING
	@Override
	public String toString() {
		String toReturn = "";
		toReturn += "-> data = " + data;
		toReturn += "\n\tvalue = " + value;		
		toReturn += "\n\tdescription = " + description;		
		toReturn += "\n\tamount = " + amount;
		toReturn += "\n\tbalanceContabilistico = " + balanceContabilistico;		
		toReturn += "\n\tbalanceCorrente = " + balanceCorrente;		
		toReturn += "\n\ttype = " + type;	
		toReturn += "\n\t-------------------------------";	
		toReturn += "\n";	
		
		return toReturn;
	}

	//GETTERS AND SETTERS
	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public Data getValue() {
		return value;
	}

	public void setValue(Data value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalanceContabilistico() {
		return balanceContabilistico;
	}

	public void setBalanceContabilistico(double balanceContabilistico) {
		this.balanceContabilistico = balanceContabilistico;
	}

	public double getBalanceCorrente() {
		return balanceCorrente;
	}

	public void setBalanceCorrente(double balanceCorrente) {
		this.balanceCorrente = balanceCorrente;
	}

	public Category getType() {
		return type;
	}

	public void setType(Category type) {
		this.type = type;
	}

}
