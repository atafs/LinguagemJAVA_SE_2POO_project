package pt.iscte.poo.instalacao.enums;

import org.json.simple.JSONObject;

public enum MaqLavarRoupaEstado {
	
	STAND_BY("waiting for instructions"), HIGHTEMP("highTemp"), LOWTEMP("lowTemp");
	
	// ATTRIBUTES
	private final String text;

	// CONSTRUCTOR
	private MaqLavarRoupaEstado(final String text) {
		this.text = text;
	}
	
	// TOSTRING
	@Override
	public String toString() {
		return text;
	}
	
	//METHOD
	// STATIC METHOD (from the class, not the instance)
	/** Seleccao do novo aparelho */
	public static void executaPrograma(JSONObject obj) {

		//JSONObject attributes
		String id = (String) obj.get("id");
	
		//toUpperCase makes the program more robust
		String tipoUpperCase = id.toUpperCase();
		try {
			// Enum.valueOf() throws an exception if the input is not valid
			MaqLavarRoupaEstado novo = MaqLavarRoupaEstado.valueOf(tipoUpperCase);

			switch (novo) {
			case HIGHTEMP:
				//...
				break;
			
			case LOWTEMP:
				//...
//				String idPrograma = (String) obj.get("id");
//				maqLavarLoica.setEstado(MaqLavarRoupaEstado.valueOf(idPrograma));
				break;
				
			case STAND_BY:
				System.out.println("default status... waiting for instructions");
				break;

			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

}
