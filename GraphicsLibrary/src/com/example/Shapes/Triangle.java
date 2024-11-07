package com.example.Shapes;

import java.util.List;

public class Triangle implements Shape{

	@Override
	public float getArea(List<Float> list) {
		float side1 = list.get(0);
		float side2 = list.get(1);
		float side3 = list.get(2);
		float semiPerimeter = (side1 + side2 + side3)/2;
		float area = (float)Math.sqrt(semiPerimeter*(semiPerimeter-side1)*(semiPerimeter-side2)*(semiPerimeter-side3));
		return area;
	}

	@Override
	public float getPerimeter(List<Float> list) {
		float side1 = list.get(0);
		float side2 = list.get(1);
		float side3 = list.get(2);
		float perimeter = side1 + side2 + side3;
		return perimeter;
	}

	@Override
	public String getOrigin() {
		
		return null;
	}

	@Override
	public boolean isPointEnclosed(List<Float> list, Point point) {
		
		return false;
	}

}
