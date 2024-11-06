package com.example.Shapes;

import java.util.List;

public class ShapeFactory {
	public static Shape createShape(ShapeType shapeType, Point point, List<Integer> list) {
		Shape shape = null;
		if (shapeType == ShapeType.CIRCLE) {
			shape = new Circle();
		} else if (shapeType == ShapeType.TRIANGLE) {
			shape = new Triangle();
		} else if (shapeType == ShapeType.SQUARE) {
			shape = new Square();
		} else if (shapeType == ShapeType.RECTANGLE) {
			shape = new Rectangle();
		} else if (shapeType == ShapeType.POLYGON) {
			shape = new Polygon();
		}
		return shape;
	}
}
