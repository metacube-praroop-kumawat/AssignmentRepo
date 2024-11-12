package com.example.Shapes;

import java.util.List;

public class Polygon implements Shape {
	List<Float> list;
	Point point;
	
	public Polygon(List<Float> list, Point point){
		this.list = list;
		this.point = point;
	}
	
	@Override
	public float getArea() {
		int numberOfSides = this.list.size();
		float sideLength = this.list.get(0);
		float apothem = (float) ((numberOfSides*numberOfSides)*Math.tan(22/(7*numberOfSides)));
		return (float)((1/2)*apothem*numberOfSides*sideLength);
	}
	
	@Override
	public float getPerimeter() {
		int numberOfSides = this.list.size();
		float sideLength = this.list.get(0);
		return (float)(numberOfSides*sideLength);
	}
	
	@Override
	public Point getOrigin() {
		return point;
	}
	
	@Override
	public boolean isPointEnclosed(Point test) {
		
		
		return false;
	}
}
