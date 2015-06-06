package modules.io.io;

public class Teste {

	public static void main(String[] args) {
		Pauta pauta = new Pauta();
		
		pauta.leFicheiro("src/modules/io/file/ficheiro.txt");
		System.out.println(pauta);
		
		pauta.adicionaAluno(new Aluno(337, "Ana Fernandes", "NA"));
		System.out.println(pauta);
		
		pauta.escreveFicheiro("src/modules/io/file/ficheiro2.txt");
	}
}
