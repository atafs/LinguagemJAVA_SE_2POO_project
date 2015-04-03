package control_1Logica;

public class FluxoSwitch1 {

	public enum Days {

		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
	}

	public static void main(String[] args) {

		//CHANGE INPUT DATA
		String current = "SUNDAY";
		Days currentDay = Days.valueOf(current.toUpperCase());

		switch (currentDay) {
		case MONDAY:
		case TUESDAY:
		case WEDNESDAY:
			System.out.println("boring");
			break;
		case THURSDAY:
			System.out.println("getting better");
		case FRIDAY:
		case SATURDAY:
		case SUNDAY:
			System.out.println("much better");
			break;

		}

	}

}
