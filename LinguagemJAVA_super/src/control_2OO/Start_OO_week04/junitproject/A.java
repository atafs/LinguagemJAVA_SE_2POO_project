package control_2OO.Start_OO_week04.junitproject;

public class A {
	private int x;
	private String id;
	
	public A(int x, String id) {
		super();
		this.x = x;
		this.id = id;
	}
	
	public int getX() {
		return x;
	}
	
	public String getId() {
		return id;
	}
	
	public String toString() {
		return id + "(" + x + ")";
	}
}
