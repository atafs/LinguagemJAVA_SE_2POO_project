package modules.patterns.factory.shapes.types;

import modules.patterns.factory.shapes.interfaces.Shape;

public class Rectangle implements Shape{

	@Override
	public void draw() {
		System.out.println("Inside Rectangle::draw() method.");		
	}

}
