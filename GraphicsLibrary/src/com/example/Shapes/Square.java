package com.example.Shapes;

import java.util.List;

public class Square implements Shape {
	@Override
	public float getArea(List<Float> list) {
		float side = list.get(0);
		return side*side;
	}
	@Override
	public float getPerimeter(List<Float> list) {
		float side = list.get(0);
		return (float)(4*side);
	}
	@Override
	public String getOrigin() {
		return "0,0";
	}
	@Override
	public boolean isPointEnclosed(List<Float> list, Point point) {
		float side = list.get(0);
		if (point.x < side && point.y < side) {
			return true;
		}
		return false;
	}
}
