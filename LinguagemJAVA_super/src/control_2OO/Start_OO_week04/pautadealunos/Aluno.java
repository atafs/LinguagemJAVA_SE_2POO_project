/** 
 * americoLIB concept 
 * @author Americo Tomas (atafs): 05/03/2015 
 */

package control_2OO.Start_OO_week04.pautadealunos;

public class Aluno {

	// ATRUBUTES
	private int numero;
	private String nome;
	private int nota;

	// CONSTRUTOR
	public Aluno(String nome, int numero, int nota) {
		this.numero = numero;
		this.nome = nome;
		this.nota = nota;
	}

	// GETTERS AND SETTERS
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

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	// TOSTRING
	@Override
	public String toString() {
		String text = "";
		text += "NOME: " + nome + ", " + "NUMERO: " + numero + ", " + "NOTA: "
				+ nota + ", ";

		return text;
	}

}
