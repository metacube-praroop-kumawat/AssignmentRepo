package com.example.Shapes;

import java.util.List;

public class Circle implements Shape {
	@Override
	public float getArea(List<Float> list) {
		float radius = list.get(0);
		return (float) (3.14*radius*radius);
	}
	
	@Override
	public float getPerimeter(List<Float> list) {
		float radius = list.get(0);
		return (float)(2*3.14*radius);
	}
	
	@Override
	public String getOrigin() {
		return "0,0";
	}
	
	@Override
	public boolean isPointEnclosed(List<Float> list, Point point) {
		float radius = list.get(0);
		float distanceOfPointFromOrigin = (float) Math.sqrt((point.x - 0)*(point.x - 0) + (point.y - 0)*(point.y - 0));
		if (distanceOfPointFromOrigin < 2*3.14*radius) {
			return true;
		}
		return false;
	}
}
