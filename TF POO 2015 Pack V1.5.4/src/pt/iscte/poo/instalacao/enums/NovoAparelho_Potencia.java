package pt.iscte.poo.instalacao.enums;

public enum NovoAparelho_Potencia {
	
	POTENCIA_MAXIMA("potenciaMaxima"), POTENCIA("potencia");
	
	// ATTRIBUTES
	private final String text;

	// CONSTRUCTOR
	private NovoAparelho_Potencia(final String text) {
		this.text = text;
	}
	
	// TOSTRING
	@Override
	public String toString() {
		return text;
	}
	

}
