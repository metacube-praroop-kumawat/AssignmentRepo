package com.example.Shapes;

import java.util.List;

public class Rectangle implements Shape{
	List<Float> list;
	Point point;
	
	public Rectangle(List<Float> list, Point point){
		this.list = list;
		this.point = point;
	}

	@Override
	public float getArea() {
		float length = this.list.get(0);
		float breadth = this.list.get(1);
		return length*breadth;
	}

	@Override
	public float getPerimeter() {
		float length = this.list.get(0);
		float breadth = this.list.get(1);
		return 2*(length+breadth);
	}

	@Override
	public Point getOrigin() {
		return this.point;
	}

	@Override
	public boolean isPointEnclosed(Point test) {
		Point origin = getOrigin();
		float length = this.list.get(0);
		float breadth = this.list.get(1);
		if (test.x < length + origin.x && test.y < breadth + origin.y && test.x > origin.x && test.y > origin.y) {
			return true;
		}
		return false;
	}

}
