package control_2OO;

import control.Animal;
import control.Ave;
import control.Baleia;
import control.Mamifero;
import control.Morcego;
import control.Peixe;
import control.Pessoa10;
import control.Veterinario;
import interfaces.Nadador;
import interfaces.Vivo;
import interfaces.Voador;

public class Start_OO_10Polimorfismo {

	public static void main(String[] args) {
		
		/*instantiate*/
		Animal a2 = new Baleia();
		Mamifero a1 = new Pessoa10();
	
		Voador v1 = new Morcego();
		Voador v2 = new Ave();
		
		Nadador n2 = new Peixe();
		Nadador n3 = new Pessoa10();
		
		Morcego m = new Morcego();
		Baleia b = new Baleia();
		Pessoa10 p = new Pessoa10();
		
		Vivo vivo1 = new Pessoa10();
		
		Veterinario vet = new Veterinario();
		
		/*print*/
		vet.verificarSaudeMamifero(m);
		vet.verificarSaudeMamifero(a1);
		vet.verificarSaudeMamifero(b);
		vet.verificarSaudeMamifero(p);

		vet.desempenhoNaAgua(b);
		vet.desempenhoNaAgua(n3);
		vet.desempenhoNaAgua(n2);

		vet.medeTamanhoAsa(m);
		vet.medeTamanhoAsa(v2);
		vet.medeTamanhoAsa(v1);
		
		vet.verficarSeEstaVivo(p);
		vet.verficarSeEstaVivo(vivo1);
		vet.verficarSeEstaVivo(a2);
	
		
		
		
	}

}
