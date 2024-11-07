package com.example.Shapes;

import java.util.List;

public class ShapeFactory {
	public Shape createShape(Shape.ShapeType shapeType, Point point, List<Float> list) {
		Shape shape = null;
		if (shapeType == Shape.ShapeType.CIRCLE) {
			shape = new Circle();
		} else if (shapeType == Shape.ShapeType.TRIANGLE) {
			shape = new Triangle();
		} else if (shapeType == Shape.ShapeType.SQUARE) {
			shape = new Square();
		} else if (shapeType == Shape.ShapeType.RECTANGLE) {
			shape = new Rectangle();
		} else if (shapeType == Shape.ShapeType.POLYGON) {
			shape = new Polygon();
		}
		return shape;
	}
}
