package control_0Pattern.factory.shapes.types;

import control_0Pattern.factory.shapes.interfaces.Shape;

public class Rectangle implements Shape{

	@Override
	public void draw() {
		System.out.println("Inside Rectangle::draw() method.");		
	}

}
