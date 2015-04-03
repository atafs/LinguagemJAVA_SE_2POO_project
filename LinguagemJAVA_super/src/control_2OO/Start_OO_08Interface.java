package control_2OO;

import control.Homem;
import control.Mulher;

public class Start_OO_08Interface {

	public static void main(String[] args) {

		Homem h = new Homem();
		h.setNome("Americo");
		h.setIdade(34);
		
		Mulher m = new Mulher();
		m.setNome("Guida");
		m.setIdade(38);
		
		m.casar(h);
	
	}

}
