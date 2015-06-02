package modules.io.serializableAndJason;

public class Teste {

	public static void main(String[] args) {
		HighScores highScores = new HighScores();
		
		System.out.println("----------SERIALIZABLE-----------");
		highScores.adicionaJogador(new Jogador("Maria", (long)50));
		highScores.adicionaJogador(new Jogador("Ana", (long)60));
		highScores.adicionaJogador(new Jogador("Joao", (long)20));
		System.out.println(highScores);
		
		
		highScores.escreveFicheiroSerializado("ficheiroSerializado.data");
		highScores.leFicheiroSerializado("ficheiroSerializado.data");
		
	
		System.err.println("----------JSON LISTS-----------");
		highScores.leFicheiroJSON("src/modules/io/file/ficheiroJSON.json");
		System.err.println(highScores);
		
		
		highScores.adicionaJogador(new Jogador("Ana", new Long(60)));
		System.err.println(highScores);
		
		highScores.escreveFicheiroJSON("src/modules/io/file/ficheiroJSON2.json");
	}
}
