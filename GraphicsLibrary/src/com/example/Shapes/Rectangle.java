package com.example.Shapes;

import java.util.List;

public class Rectangle implements Shape{

	@Override
	public float getArea(List<Float> list) {
		float length = list.get(0);
		float breadth = list.get(1);
		return length*breadth;
	}

	@Override
	public float getPerimeter(List<Float> list) {
		float length = list.get(0);
		float breadth = list.get(1);
		return 2*(length+breadth);
	}

	@Override
	public Point getOrigin(List<Float> list, Point point) {
		return point;
	}

	@Override
	public boolean isPointEnclosed( List<Float> list, Point point, Point test) {
		Point origin = getOrigin(list, point);
		float length = list.get(0);
		float breadth = list.get(1);
		if (test.x < length + origin.x && test.y < breadth + origin.y && test.x > origin.x && test.y > origin.y) {
			return true;
		}
		return false;
	}

}
