package modules.lists.all_lists;

public class Aluno {
	
	//ATTRIBUTES
	private long numero;
	private String nome;
	
	//CONSTRUCTOR
	public Aluno(long numero, String nome) {
		this.numero = numero;
		this.nome = nome;
	}
	
	//GETTER AND SETTER
	public long getNumero() {
		return numero;
	}
	public String getNome() {
		return nome;
	}
	
	//TOSTRING
	@Override
	public String toString() {
		return "Aluno [numero=" + numero + ", nome=" + nome + "]";
	}
	
	
}
