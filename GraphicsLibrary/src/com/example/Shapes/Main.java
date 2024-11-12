package com.example.Shapes;

import java.util.List;
import java.util.ArrayList;

public class Main {
	public static void main(String args[]) {
		Screen screen1 = new Screen(20,20);
		List<Float> rectangle1 = new ArrayList<>();
		rectangle1.add((float) 3);
		rectangle1.add((float) 4);
		
		List<Float> square1 = new ArrayList<>();
		square1.add((float) 2);
		
		List<Float> circle1 = new ArrayList<>();
		circle1.add((float)5);
		
		screen1.addShape(Shape.ShapeType.SQUARE, new Point(1.0,1.0), square1);
		screen1.addShape(Shape.ShapeType.CIRCLE, new Point(2.0,2.0), circle1) ;
		screen1.addShape(Shape.ShapeType.RECTANGLE , new Point(1.0,1.0), rectangle1);
	//	screen1.deleteAllShapesOfSpecificType(Shape.ShapeType.CIRCLE);
	//	screen1.deleteAllShapesOfSpecificType(ShapeType.RECTANGLE);
//		for (String str : screen1.shapesOnScreen.keySet()) {
//			System.out.println(str + " , "+  screen1.shapesOnScreen.get(str));
//		}
		 screen1.sortingByOrder("Perimeter");
	}
}
