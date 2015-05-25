package modules.patterns.factory.shapes;

import modules.patterns.factory.shapes.interfaces.Shape;
import modules.patterns.factory.shapes.types.Circle;
import modules.patterns.factory.shapes.types.Rectangle;
import modules.patterns.factory.shapes.types.Square;

public class ShapeFactory {

	// use getShape method to get object of type shape
	public Shape getShape(String shapeType) {
		if (shapeType == null) {
			return null;
		}
		if (shapeType.equalsIgnoreCase("CIRCLE")) {
			return new Circle();

		} else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
			return new Rectangle();

		} else if (shapeType.equalsIgnoreCase("SQUARE")) {
			return new Square();
		}
		return null;
	}

}
