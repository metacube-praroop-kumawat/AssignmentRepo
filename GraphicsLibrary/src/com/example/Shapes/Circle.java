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
	public Point getOrigin(List<Float> list, Point point) {
		float radius = list.get(0);
		double a =  point.x - radius*Math.sin(Math.atan(point.y/point.x));
		double b =  point.y - radius*Math.sin(Math.atan(point.y/point.x));
		Point centre = new Point(a, b);
		return centre;
	}
	
	@Override
	public boolean isPointEnclosed(List<Float> list, Point point, Point test) {
		float radius = list.get(0);
		int lhs = (int) ((test.x-point.x)*(test.x-point.x) + (test.y-point.y)*(test.y-point.y));		
		int rhs = (int) ((int)radius*radius);
		if(lhs <= rhs) {
			return true;
		}
		return false;
	}
}
