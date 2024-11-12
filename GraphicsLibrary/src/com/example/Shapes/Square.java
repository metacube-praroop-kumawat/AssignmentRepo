package com.example.Shapes;

import java.util.List;

public class Square implements Shape {
	List<Float> list;
	Point point;
	
	public Square(List<Float> list, Point point){
		this.list = list;
		this.point = point;
	}
	
	@Override
	public float getArea() {
		float side = this.list.get(0);
		return side*side;
	}
	@Override
	public float getPerimeter() {
		float side = this.list.get(0);
		return (float)(4*side);
	}
	@Override
	public Point getOrigin() {
		return this.point;
	}
	
	@Override
	public boolean isPointEnclosed(Point test) {
		Point origin =  getOrigin();
		float side = this.list.get(0);
		if (test.x < side + origin.x && test.y < side + origin.y && test.x > origin.x && test.y > origin.y ) {
			return true;
		}
		return false;
	}
}
