package control_2OO.Start_OO_week03.facturas;

public class Cliente {

	// ATTRIBUTES
	private String nomeCliente;
	private String NIF;
	TipoDeCliente tipoCliente;

	// CONSTRUCTOR
	public Cliente(String nomeCliente, String NIF, TipoDeCliente tipoCliente) {
		this.nomeCliente = nomeCliente;
		this.NIF = NIF;
		this.tipoCliente = tipoCliente;
	}

	// TOSTRING
	@Override
	public String toString() {
		return nomeCliente + ": Nome do Cliente; \n" + NIF
				+ ": Valor do NIF; \n" + tipoCliente + ": Tipo de Cliente\n";
	}

	// GETTERS AND SETTERS
	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getNIF() {
		return NIF;
	}

	public void setNIF(String nIF) {
		NIF = nIF;
	}

	public TipoDeCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoDeCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

}
