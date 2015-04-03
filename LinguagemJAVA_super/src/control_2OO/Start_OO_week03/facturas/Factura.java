package control_2OO.Start_OO_week03.facturas;

public class Factura {

	//ATTRIBUTES
	protected String nomeProduto;
	protected double valorProduto;

	//CONSTRUCTOR
	public Factura(String nomeProduto, double valorProduto) {
		this.nomeProduto = nomeProduto;
		this.valorProduto = valorProduto;
	}
	
	//TOSTRING
	public String toString() {
		return nomeProduto + ": Nome do Produto; \n" + valorProduto + ": Valor do Produto\n";
	}
	

	
	
}
