package control_2OO.Start_OO_week01e2.coffeeMachine_v1;

public class Product {
	
	//ATTRIBUTES
	private String name;
	private double price;
	
	//CONSTRUCTOR
	public Product(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	//GETTERS AND SETTERS
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	//TOSTRING
	@Override
	public String toString() {
		return name + " -> " + price + "€; \n";
	}
	
	

}
