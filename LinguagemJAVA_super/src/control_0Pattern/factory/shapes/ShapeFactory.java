package control_0Pattern.factory.shapes;

import control_0Pattern.factory.shapes.interfaces.Shape;
import control_0Pattern.factory.shapes.types.Circle;
import control_0Pattern.factory.shapes.types.Rectangle;
import control_0Pattern.factory.shapes.types.Square;

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
