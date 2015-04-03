package control_2OO.Start_OO_week06.serializableAndJason;

public class Teste {

	public static void main(String[] args) {
		HighScores highScores = new HighScores();
		
//		highScores.adicionaJogador(new Jogador("Maria", 50));
//		highScores.adicionaJogador(new Jogador("Ana", 60));
//		highScores.adicionaJogador(new Jogador("Joao", 20));
	
//		System.out.println(highScores);
		
//		highScores.escreveFicheiroSerializado("ficheiroSerializado.data");
	
	
//		highScores.leFicheiroSerializado("ficheiroSerializado.data");
	
		
		highScores.leFicheiroJSON("src/control_2OO/Start_OO_week06/file/ficheiroJSON.json");
		System.out.println(highScores);
		
		
		highScores.adicionaJogador(new Jogador("Ana", new Long(60)));
		System.out.println(highScores);
		
		highScores.escreveFicheiroJSON("src/control_2OO/Start_OO_week06/file/ficheiroJSON2.json");
	}
}
