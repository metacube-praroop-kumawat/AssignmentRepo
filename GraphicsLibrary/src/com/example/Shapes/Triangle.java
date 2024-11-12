package com.example.Shapes;

import java.util.List;

public class Triangle implements Shape{
	List<Float> list;
	Point point;
	
	public Triangle(List<Float> list, Point point){
		this.list = list;
		this.point = point;
	}
	
	@Override
	public float getArea() {
		float side1 = this.list.get(0);
		float side2 = this.list.get(1);
		float side3 = this.list.get(2);
		float semiPerimeter = (side1 + side2 + side3)/2;
		float area = (float)Math.sqrt(semiPerimeter*(semiPerimeter-side1)*(semiPerimeter-side2)*(semiPerimeter-side3));
		return area;
	}

	@Override
	public float getPerimeter() {
		float side1 = this.list.get(0);
		float side2 = this.list.get(1);
		float side3 = this.list.get(2);
		float perimeter = side1 + side2 + side3;
		return perimeter;
	}

	@Override
	public Point getOrigin() {
		return point;
	}

	@Override
	public boolean isPointEnclosed(Point test) {
		float side1 = this.list.get(0);
		float side2 = this.list.get(1);
		float side3 = this.list.get(2);
		double area1 = 0.5 * side1 * Math.sqrt(test.x * test.x) + (test.y * test.y);
		double area2 = 0.5 * side2 * Math.sqrt((test.x - side1) * (test.x - side1)) + (this.point.y * this.point.y);
		double area3 = 0.5 * side3 * Math.sqrt((test.x - side2) * (test.x - side2)) + (this.point.y * this.point.y);
		if (area1 + area2 + area3 - this.getArea() < 1e-9) {
			return true;
		}
		return false;
	}

}
