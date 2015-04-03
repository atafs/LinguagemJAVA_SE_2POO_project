package control_2OO.Start_OO_week06.io;

public class Teste {

	public static void main(String[] args) {
		Pauta pauta = new Pauta();
		
		pauta.leFicheiro("src/control_2OO/Start_OO_week06/file/ficheiro.txt");
		System.out.println(pauta);
		
		pauta.adicionaAluno(new Aluno(337, "Ana Fernandes", "NA"));
		System.out.println(pauta);
		
		pauta.escreveFicheiro("src/control_2OO/Start_OO_week06/file/ficheiro2.txt");
	}
}
