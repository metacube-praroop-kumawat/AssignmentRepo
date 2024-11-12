package com.example.Shapes;

public	interface Shape {
	float getArea();
	float getPerimeter();
	Point getOrigin();
	boolean isPointEnclosed(Point test);
	enum ShapeType{
		SQUARE,
		RECTANGLE,
		CIRCLE,
		TRIANGLE,
		POLYGON
	}
}


