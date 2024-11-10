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
	public Point getOrigin(List<Float> list,Point point) {
		return point;
	}
	
	@Override
	public boolean isPointEnclosed(List<Float> list, Point point, Point test) {
		Point origin =  getOrigin(list, point);
		float side = list.get(0);
		if (test.x < side + origin.x && test.y < side + origin.y && test.x > origin.x && test.y > origin.y ) {
			return true;
		}
		return false;
	}
}
