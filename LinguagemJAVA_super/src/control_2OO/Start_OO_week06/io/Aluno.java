package control_2OO.Start_OO_week06.io;

public class Aluno {

	private int numero;
	private String nome;
	private String nota;

	public Aluno(int numero, String nome, String nota){
		if(numero <= 0)
			throw new IllegalArgumentException("Erro: Numero invalido.");
		
		if(nome == null || nome.equals(""))
			throw new IllegalArgumentException("Erro: Nome invalido.");
		
		if(nota == null || !(nota.equals("NA") || nota.equals("RE") 
				|| (Integer.parseInt(nota) >= 0 && Integer.parseInt(nota) <= 20)))
			throw new IllegalArgumentException("Erro: Nota invalido.");
		
		this.numero = numero;
		this.nome = nome;
		this.nota = nota;
	}
	
	//
	public String getNome() {
		return nome;
	}
	
	public String getNota() {
		return nota;
	}
	
	public int getNumero() {
		return numero;
	}
	
	@Override
	public String toString() {
		return numero + " - " + nome + " - " + nota;
	}
}
