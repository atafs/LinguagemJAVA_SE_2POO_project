package pt.iscte.poo.instalacao;

import org.json.simple.JSONObject;
import pt.iscte.poo.instalacao.aparelhos.Computador;
import pt.iscte.poo.instalacao.enums.AparelhoEstado;
import pt.iscte.poo.instalacao.interfaces.Variavel;

public abstract class Aparelho implements Ligavel, Variavel{
	
	//ATTRIBUTES
	private String nome;
	private double potenciaMaxima;
	private double potenciaActual;
	private AparelhoEstado estadoAparelho;
	private Tomada tomada;
	
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
		String nome = (String) obj.get("nome");
		
		double potencia = -1;
		if(obj.get("Potencia") != null) {
			potencia = (double)((long)obj.get("Potencia"));
		}
		
		if(obj.get("PotenciaMaxima") != null) {
			potencia = (double)((long)obj.get("PotenciaMaxima"));
		}
		
		if(tipo.equals("computador")) {
			return new Computador(nome, potencia);
			
		} else if(tipo.equals("Outros Aparelhos")) {
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
		if (potenciaActual <= potenciaMaxima) {
			this.potenciaActual = potenciaActual;
		} else {
			// System.out.println("ERROR: CAN NOT LOWER THE INTENSiTY ANY MORE. IT IS ALREADY ZERO!!!");
			throw new IllegalStateException(
					"ERROR: CAN NOT GET HIGHER THE INTENSiTY. IT IS ALREADY MAX!!!");
		}
	}

	@Override
	public void diminui(int potenciaActual) {
		if (potenciaActual >= 0) {
			this.potenciaActual = potenciaActual;	
		} else {
			//System.out.println("ERROR: CAN NOT LOWER THE INTENSiTY ANY MORE. IT IS ALREADY ZERO!!!");
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
}
