package com.example.Shapes;

enum ShapeType{
	SQUARE,
	RECTANGLE,
	CIRCLE,
	TRIANGLE,
	POLYGON
}

interface Shape {
	abstract int getArea();
	abstract int getPerimeter();
	abstract String getOrigin();
	abstract boolean isPointEnclosed();
}
