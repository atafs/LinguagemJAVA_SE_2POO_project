package control_2OO.Start_OO_week03.facturas;

public class NovaFactura extends Factura {

	// ATTRIBUTOS
	protected Cliente cliente;

	// CONSTRUCTOR
	public NovaFactura(String nomeProduto, double valorProduto, Cliente cliente) {
		super(nomeProduto, valorProduto);
		this.cliente = cliente;
	}

	// TOSTRING
	@Override
	public String toString() {
		
		String string;
		if (cliente.getTipoCliente() == TipoDeCliente.INDIVIDUAL) {
			string = "\n---------NovaFactura INDIVIDUAL-------------\n"
					+ "-   NOME CLIENTE: " + cliente.getNomeCliente() + "\n"
					+ "-   NIF CLIENTE: " + cliente.getNIF() + "\n" 
					+ "-   TIPO CLIENTE: " + cliente.getTipoCliente() + "\n\n"
					+ "-   NOME PRODUTO: " + super.nomeProduto + "\n" 
					+ "-   NOME CLIENTE: " + super.valorProduto + "\n\n"
					+ "-   OBRIGADO PELA SUA VISITA!!!" + TipoDeCliente.INDIVIDUAL + "\n"
					+ "-------------------------------------------\n";
		} else {
			string = "\n---------NovaFactura EMPRESA-------------\n"
					+ "-   NOME CLIENTE: " + cliente.getNomeCliente() + "\n"
					+ "-   NIF CLIENTE: " + cliente.getNIF() + "\n" 
					+ "-   TIPO CLIENTE: " + cliente.getTipoCliente() + "\n\n"
					+ "-   NOME PRODUTO: " + super.nomeProduto + "\n" 
					+ "-   NOME EMPRESA: " + super.valorProduto + "\n\n"
					+ "-   OBRIGADO PELA SUA VISITA!!!" + TipoDeCliente.EMPRESA + "\n"
					+ "------------------------------------------\n";
		}
		return string;	
	}
		
		

}
