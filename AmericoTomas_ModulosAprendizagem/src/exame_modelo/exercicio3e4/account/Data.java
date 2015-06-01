package exame_modelo.exercicio3e4.account;

//DAO CLASS
public class Data implements Comparable<Data> {
	
	//ATTRIBUTES
	private int dia;
	private int mes;
	private int ano;
	
	//CONSTRUCTOR
	public Data(int dia, int mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	public Data() {
		this.dia = 0;
		this.mes = 0;
		this.ano = 0;
	}
	
	//GETTERS AND SETTERS
	public int getDia() {
		return dia;
	}
	
	public int getMes() {
		return mes;
	}
	
	public int getAno() {
		return ano;
	}
	
	public void setDia(int dia) {
		this.dia = dia;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	//TOSTRING
	@Override
	public String toString() {
		return dia + "/" + mes + "/" + ano;
	}

	//COMPARETO
	@Override
	public int compareTo(Data outraData) {
		if(ano != outraData.getAno())
			return ano - outraData.getAno(); 
		
		if(mes != outraData.getMes())
			return mes - outraData.getMes(); 
		
		if(dia != outraData.getDia())
			return dia - outraData.getDia(); 
		
		return 0;
	}
	
	//STATIC METHODS
	public static int differenceEmDiasEntre(Data data1, Data data2) {
		int difference = 0;
		
		//CHECK IF THEY ARE FORM SAME YEAR AND MONTH
		if (data1.getAno() == data2.getAno() && data1.getMes() == data2.getMes()) {
			if (data2.getDia() >= data1.getDia()) {
				difference = data2.getDia() - data1.getDia();
			}else {
				difference = data1.getDia() - data2.getDia();
			}
			
		}
		
		
		return difference;
	}
	
}



