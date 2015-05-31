package exame_modelo.exercicio1;

//DAO CLASS
public class Car {
	
	//ATTRIBUTES
	private String nickName;
	private String plate;
	private int yearOfConstruction;
	
	//CONSTRUCTOR: overload
	public Car(String nickName, int yearOfConstruction) {
		super();
		this.nickName = nickName;
		this.yearOfConstruction = yearOfConstruction;
	}
	
	public Car(String nickName, String plate, int yearOfConstruction) {
		this(nickName, yearOfConstruction);
		this.plate = plate;
	}

	//GETTERS AND SETTERS
	public String getNickName() {
		return nickName;
	}
	public int getYearOfConstruction() {
		return yearOfConstruction;
	}
	
	public String getPlate() {
		return plate;
	}

	//TOSTRING
	@Override
	public String toString() {
		String toReturn = "";
		toReturn += "NickName = " + nickName + " -> ";
		toReturn += "YearOfConstruction = " + yearOfConstruction;
		return toReturn;
	}
	
}
