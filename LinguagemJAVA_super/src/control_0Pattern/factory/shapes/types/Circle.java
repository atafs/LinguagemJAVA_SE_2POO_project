package control_0Pattern.factory.shapes.types;

import control_0Pattern.factory.shapes.interfaces.Shape;

public class Circle implements Shape{

	@Override
	public void draw() {
		System.out.println("Inside Circle::draw() method.");		
	}

}
