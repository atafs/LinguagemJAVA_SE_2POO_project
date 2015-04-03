package control_2OO;

import control.ControlGame;

public class Start_OO_07Encapsulamento {

	public static void main(String[] args) {

		/* instantiate */
		Start_OO_07Encapsulamento jogador = new Start_OO_07Encapsulamento();
		ControlGame c = new ControlGame();

		/* use methods */
		jogador.jogar(5, 5, c);

	}

	/**
	 * se direito mover 5 unidades de uma vez, o esquerdo desloca -1 (logica do jogo)
	 */
	public void jogar(int direita, int esquerda, ControlGame c) {
		c.setEsquerda(esquerda);
		c.setDireita(direita);

		System.out.println("Direita:  " + c.getDireita() + "\nEsquerda: "
				+ c.getEsquerda());
	}

}
