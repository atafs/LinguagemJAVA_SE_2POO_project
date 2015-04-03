package control_2OO.Start_OO_week01.parkingCar;

public class Test_Carro_Parque {
	
	public static void main(String[] args) {
		
		//INSTANTIATE
		ParqueDeEstacionamento parque = new ParqueDeEstacionamento();
		
		String matricula1 = "24-54-OI";
		String matricula2 = "54-54-FI";
		String matricula3 = "94-54-JI";
	
		RegistoDeCarro c1 = new RegistoDeCarro("24-54-OI", 4);
		
		//OPERATIONS
		c1.setNumeroDeEntradas(9);
		
		//ADD CAR TO PARK (decrement from ticket)
		parque.adicionarRegisto(matricula1);
		parque.adicionarRegisto(matricula2);
		parque.adicionarRegisto(matricula3);
		
		//PRINT LIST OF CARS IN PARK
		System.out.println("ATTEMPT 01: ");
		System.out.println(parque.toString());
		
		//PRINT LIST OF CARS IN PARK
		System.out.println("ATTEMPT 02: ");
		System.out.println(parque.tentativaDeEntrada(matricula1));
		System.out.println(parque.tentativaDeEntrada(matricula2));
		System.out.println(parque.tentativaDeEntrada(matricula3));
		
		parque.carregarEntradas(matricula1, 1);
		parque.carregarEntradas(matricula2, 1);
		parque.carregarEntradas(matricula3, 1);
		System.out.print("\n");
		
		//PRINT LIST OF CARS IN PARK
		System.out.println("ATTEMPT 03: ");
		System.out.println(parque.tentativaDeEntrada(matricula1));
		System.out.println(parque.tentativaDeEntrada(matricula2));
		System.out.println(parque.tentativaDeEntrada(matricula3));
		

		
	}

}
