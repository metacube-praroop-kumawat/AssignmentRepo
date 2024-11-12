package com.example.Shapes;

import java.util.List;

public class Circle implements Shape {
	List<Float> list;
	Point point;
	
	public Circle(List<Float> list, Point point){
		this.list = list;
		this.point = point;
	}
	
	@Override
	public float getArea() {
		float radius = this.list.get(0);
		return (float) (3.14*radius*radius);
	}
	
	@Override
	public float getPerimeter() {
		float radius = this.list.get(0);
		return (float)(2*3.14*radius);
	}
	
	@Override
	public Point getOrigin() {
		float radius = this.list.get(0);
		double a =  this.point.x - radius*Math.sin(Math.atan(this.point.y/this.point.x));
		double b =  this.point.y - radius*Math.sin(Math.atan(this.point.y/this.point.x));
		Point centre = new Point(a, b);
		return centre;
	}
	
	@Override
	public boolean isPointEnclosed(Point test) {
		float radius = this.list.get(0);
		int lhs = (int) ((test.x - this.point.x)*(test.x - this.point.x) + (test.y - this.point.y)*(test.y - this.point.y));		
		int rhs = (int) ((int)radius*radius);
		if(lhs <= rhs) {
			return true;
		}
		return false;
	}
}
