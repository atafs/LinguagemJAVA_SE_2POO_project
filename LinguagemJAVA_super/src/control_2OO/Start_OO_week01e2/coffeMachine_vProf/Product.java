package control_2OO.Start_OO_week01e2.coffeMachine_vProf;

public class Product {

	private String name;
	private double price;
	
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
	
	public String toString() {
		return name + " -> " + price + " �";
	}
	
}
