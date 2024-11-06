package com.example.Shapes;

public class Square implements Shape {
	public int getArea(int side) {
		return side*side;
	}
	public int getPerimeter(int side) {
		return 4*side;
	}
	public String getOrigin(int side) {
		return "0,0";
	}
	public boolean isPointEnclosed(int side, Point point) {
		if (point.x < side && point.y < side) {
			return true;
		}
		return false;
	}
}
