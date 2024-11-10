package com.example.Shapes;

import java.util.List;

public	interface Shape {
	float getArea(List<Float> list);
	float getPerimeter(List<Float> list);
	Point getOrigin(List<Float> list, Point point);
	boolean isPointEnclosed(List<Float> list, Point point, Point test);
	enum ShapeType{
		SQUARE,
		RECTANGLE,
		CIRCLE,
		TRIANGLE,
		POLYGON
	}
}


