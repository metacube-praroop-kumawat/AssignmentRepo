/*******************************************************************************************************
* @classname: ShapeFactory
* @author: Praroop
* Modification Log:
********************************************************************************************************
* Praroop Kumawat        2024/11/06         Defining shape factory class to use composition
********************************************************************************************************/

package com.example.Shapes;

import java.util.List;

public class ShapeFactory {
	/**
	 * calls for the particular class to create shape object
	 * @param shapeType is a type of shape user wants to create
	 * @param point the starting Point
	 * @param list dimensions of the shape
	 * @return Shape object that is created
	 */
	public Shape createShape(Shape.ShapeType shapeType, Point point, List<Float> list) {
		Shape shape = null;
		if (shapeType == Shape.ShapeType.CIRCLE) {
			shape = new Circle(list, point);
		} else if (shapeType == Shape.ShapeType.TRIANGLE) {
			shape = new Triangle(list, point);
		} else if (shapeType == Shape.ShapeType.SQUARE) {
			shape = new Square(list, point);
		} else if (shapeType == Shape.ShapeType.RECTANGLE) {
			shape = new Rectangle(list, point);
		} else if (shapeType == Shape.ShapeType.POLYGON) {
			shape = new Polygon(list, point);
		}
		return shape;
	}
}
