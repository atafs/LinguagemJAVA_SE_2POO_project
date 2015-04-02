package pt.iscte.poo.instalacao;

import org.json.simple.JSONObject;

import pt.iscte.poo.instalacao.aparelhos.Computador;
import pt.iscte.poo.instalacao.aparelhos.Frigorifico;
import pt.iscte.poo.instalacao.aparelhos.Lampada;
import pt.iscte.poo.instalacao.aparelhos.MicroOndas;
import pt.iscte.poo.instalacao.aparelhos.Torradeira;
import pt.iscte.poo.instalacao.enums.AparelhoEstado;
import pt.iscte.poo.instalacao.interfaces.Variavel;

public abstract class Aparelho implements Ligavel, Variavel{
	
	//ATTRIBUTES
	private String nome;
	private double potenciaMaxima;
	private double potenciaActual;
	private AparelhoEstado estadoAparelho;
	private Tomada tomada;
	private boolean potenciaFixa = false;
	
	//CONSTRUCTOR (overload methods)
	public Aparelho(String nome,  double potenciaMaxima, AparelhoEstado estadoAparelho, Tomada tomada) {
		//DEVICE
		this.nome = nome;
		this.potenciaMaxima = potenciaMaxima;
		this.estadoAparelho = estadoAparelho;
		this.tomada = tomada;
		
		//IF aparelho for de potencia variavel, mudar o seu valor
		this.potenciaActual = 0.0;
	}
	
	//JUnit requires this constructor
	public Aparelho(String nome, double potencia) {
		this.nome = nome;
		this.potenciaMaxima = potencia;
	}
	
	//TOSTRING
	@Override
	public String toString() {
		String toReturn = ""/*super.toString()*/;
		toReturn += "-> APARELHO: ";
		toReturn += " -> NOME: " + this.nome;	
		toReturn += " -> POTENCIA: " + potenciaMaxima;	
		toReturn += " -> ESTADO: " + this.estadoAparelho;
		
		return toReturn;
	}
	
	//STATIC METHODS
	/** Metodo que utiliza um JSONObject (tipo um hashMap) */
	public static Ligavel novoAparelho(JSONObject obj) {
	
		String tipo = (String) obj.get("tipo");
		String id = (String) obj.get("id");
		
		//POWER (max or variable)
		double potencia = -1;
		if(obj.get("potencia") != null) {
			potencia = (double)((long)obj.get("potencia"));
		}
		
		if(obj.get("potenciaMaxima") != null) {
			potencia = (double)obj.get("potenciaMaxima");
		}
		
//		//TO DELETE
//		System.out.println(id);
//		System.out.println(potencia);
		
		//INSTANTIATE ALL DEVICES FROM THE TYPE (name of device)
		if(tipo.equals("computador")) {
			return new Computador(id, potencia);
		}
		
		else if(tipo.equals("frigorifico")) {
			return new Frigorifico(id, potencia);
		}
		
		else if(tipo.equals("lampada")) {
			return new Lampada(id, potencia);
		}
		
		else if(tipo.equals("microOndas")) {
			return new MicroOndas(id, potencia);
		}
		
		else if(tipo.equals("torradeira")) {
			return new Torradeira(id, potencia);
		}
		
		else if(tipo.equals("outrosAparelhos")) {
			return null;
		}
		return null;
	}
	
	//INTERFACES METHODS
	@Override
	/** */
	public void liga() {
		estadoAparelho = AparelhoEstado.ON;	
	}

	@Override
	public void desliga() {
		estadoAparelho = AparelhoEstado.OFF;	
	}
	
	@Override
	public boolean estaLigado() {
		//IF the device state is set as ON, then it is true;
		return (estadoAparelho == AparelhoEstado.ON);
	}
	
	@Override
	public void aumenta(int potenciaActual) {
		if ((this.potenciaActual + potenciaActual)  <= potenciaMaxima) {
			this.potenciaActual += potenciaActual;
			//System.out.println(this.potenciaActual);
		} else {
			this.potenciaActual = potenciaMaxima;
			//System.out.println("ERROR: CAN NOT GET HIGHER THE INTENSiTY. IT IS ALREADY MAX!!!");
			//System.out.println(this.potenciaActual);
			//throw new IllegalStateException("ERROR: CAN NOT GET HIGHER THE INTENSiTY. IT IS ALREADY MAX!!!");
		}
	}

	@Override
	public void diminui(int potenciaActual) {
		if ((this.potenciaActual + potenciaActual) >= 0) {
			this.potenciaActual -= potenciaActual;	
		} else {
			//System.out.println("ERROR: CAN NOT LOWER THE INTENSiTY ANY MORE. IT IS ALREADY ZERO!!!");
			this.potenciaActual = 0;
			throw new IllegalStateException("ERROR: CAN NOT LOWER THE INTENSiTY ANY MORE. IT IS ALREADY ZERO!!!");
		}
	}
	
	//GETTERS AND SETTERS
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPotenciaMaxima() {
		return potenciaMaxima;
	}
	public void setPotenciaMaxima(double potenciaMaxima) {
		this.potenciaMaxima = potenciaMaxima;
	}

	public AparelhoEstado getEstadoAparelho() {
		return estadoAparelho;
	}

	public void setEstadoAparelho(AparelhoEstado estadoAparelho) {
		this.estadoAparelho = estadoAparelho;
	}

	public Tomada getTomada() {
		return tomada;
	}

	public void setTomada(Tomada tomada) {
		this.tomada = tomada;
	}

	public double getPotenciaActual() {
		return potenciaActual;
	}

	public void setPotenciaActual(double potenciaActual) {
		this.potenciaActual = potenciaActual;
	}

	public boolean isPotenciaFixa() {
		return potenciaFixa;
	}

	public void setPotenciaFixa(boolean potenciaFixa) {
		this.potenciaFixa = potenciaFixa;
	}
}
