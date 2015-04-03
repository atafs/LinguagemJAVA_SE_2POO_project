package control_2OO.Start_OO_week03.facturas;

public class Main {
	
	public static void main(String[] args) {
		
		//INSTANTIATE
		double valorProduto = 400.00;
		Factura f = new Factura("Computador", valorProduto);
		
		Cliente cliente = new Cliente("Americo", "202038777", TipoDeCliente.INDIVIDUAL);
		Cliente cliente1 = new Cliente("Tomas", "777777777", TipoDeCliente.EMPRESA);
		
		//PRINT
		System.out.println();
		System.out.println("---------PRINT1-------------");
		System.out.println(f);
		
		//PRINT
		System.out.println();
		System.out.println("---------PRINT2-------------");
		System.out.println(TipoDeCliente.INDIVIDUAL.ordinal() + ": Number");
		System.out.println(TipoDeCliente.EMPRESA.ordinal() + ": Number");
		
		TipoDeCliente[] v = TipoDeCliente.values();
		for (TipoDeCliente tipoDeCliente : v) {
			System.out.print(tipoDeCliente + "; ");
		}
		
		//INSTANTIATE		
		Factura f2 = new NovaFactura("SSD Card", 300.00, cliente);
		Factura f3 = new NovaFactura("PORTATIL", 500.00, cliente1);
		
		//PRINT
		System.out.println();
		System.out.println(f2);
		System.out.println(f3);
		
	}

}
