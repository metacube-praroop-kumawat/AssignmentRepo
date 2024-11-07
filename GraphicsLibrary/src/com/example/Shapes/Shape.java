package com.example.Shapes;

import java.util.List;



public	interface Shape {
	float getArea(List<Float> list);
	float getPerimeter(List<Float> list);
	String getOrigin();
	boolean isPointEnclosed(List<Float> list, Point point);
	enum ShapeType{
		SQUARE,
		RECTANGLE,
		CIRCLE,
		TRIANGLE,
		POLYGON
	}
}


