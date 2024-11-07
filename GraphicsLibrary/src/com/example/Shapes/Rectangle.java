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
	public String getOrigin() {
		return "0,0";
	}

	@Override
	public boolean isPointEnclosed( List<Float> list, Point point) {
		float length = list.get(0);
		float breadth = list.get(1);
		if (point.x < length && point.y < breadth) {
			return true;
		}
		return false;
	}

}
