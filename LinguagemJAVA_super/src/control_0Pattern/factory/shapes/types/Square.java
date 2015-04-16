package control_0Pattern.factory.shapes.types;

import control_0Pattern.factory.shapes.interfaces.Shape;

public class Square implements Shape {

	@Override
	public void draw() {
		System.out.println("Inside Square::draw() method.");
	}

}
