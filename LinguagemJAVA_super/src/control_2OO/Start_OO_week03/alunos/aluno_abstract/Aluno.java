package control_2OO.Start_OO_week03.alunos.aluno_abstract;

public abstract class Aluno {
	
	//ATTRIBUTES
	private int numero;
	private String nome;
	
	//CONSTRUCTOR
	public Aluno(int numero, String nome) {
		this.numero = numero;
		this.nome = nome;
	}
	
	//GETTERS AND SETTERS
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//ABSTRACT METHODS
	public abstract String getTipo();
	
	//TOSTRING
	@Override
	public String toString() {
		return "NOME ALUNO: " + nome + "; NUMERO ALUNO: " + numero;
	}

}
