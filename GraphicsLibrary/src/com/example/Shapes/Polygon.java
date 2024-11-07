package com.example.Shapes;

import java.util.List;

public class Polygon implements Shape {
	
	@Override
	public float getArea(List<Float> list) {
		int numberOfSides = list.size();
		float sideLength = list.get(0);
		float apothem = (float) ((numberOfSides*numberOfSides)*Math.tan(22/(7*numberOfSides)));
		return (float)((1/2)*apothem*numberOfSides*sideLength);
	}
	
	@Override
	public float getPerimeter(List<Float> list) {
		int numberOfSides = list.size();
		float sideLength = list.get(0);
		return (float)(numberOfSides*sideLength);
	}
	
	@Override
	public String getOrigin() {
		return "0,0";
	}
	
	@Override
	public boolean isPointEnclosed(List<Float> list, Point point) {
		
		if (point.x < 10 && point.y < 10) {
			return true;
		}
		return false;
	}
}
