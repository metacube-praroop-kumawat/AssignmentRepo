package com.example.Shapes;

import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;

public class Screen {
	int XMAX;
	int YMAX;
	static int timeStamp = 0;
	Map<String, Shape> shapesOnScreen = new HashMap<>();
//	String = (x,y),t
	Map<Shape, List<Float>> dimensions = new HashMap<>();
	
	
	public Screen(int xMax, int yMax) {
		this.XMAX = xMax;
		this.YMAX = yMax;
	}

	public void addShape(Shape.ShapeType shapeType, Point point, List<Float> list) {
		ShapeFactory shapeFactory = new ShapeFactory();
		Shape shape = shapeFactory.createShape(shapeType, point, list);
		timeStamp++;
		String str = new String("(" + point.x + "," + point.y + ")" + "," + timeStamp) ;
		shapesOnScreen.put(str, shape);	
		dimensions.put(shape, list);
		System.out.println("Shape "+ shapeType + " added successfully");
	}
	
	public void deleteShape(Shape.ShapeType shapeType, Point point) {
		for(String str : shapesOnScreen.keySet()) {
			if((str.charAt(1) - 48) == point.x && (str.charAt(3) - 48) == point.y) { //converting characters to int value by ASCII
				dimensions.remove(shapesOnScreen.get(str));
				shapesOnScreen.remove(str);
				System.out.println("The shape at point " + point.x + "," + point.y + " is removed successfully");
			}
		}
	}
	
	public void deleteAllShapesOfSpecificType(Shape.ShapeType shapeType) {
		int count = 0;
		Map<String, Shape> copyList = new HashMap<>(shapesOnScreen);  

		for (String str : copyList.keySet()) {
//			(shapesOnScreen.get(str).getClass().getSimpleName().toUpperCase());
			if ((shapesOnScreen.get(str)).getClass().getSimpleName().toUpperCase().equals(shapeType.name())) {
				dimensions.remove(shapesOnScreen.get(str));
				shapesOnScreen.remove(str);
				count++;
			}
		}
		if (count > 0) {
			System.out.println("All "+ count +" shapes of " + shapeType + " are removed from Screen.");
		} else { 
			System.out.println("No shape of " + shapeType + " is present.");
		}
	}
	public void sortingByOrder(String str) {
		System.out.println("Sorting on the basis of " + str + ":-");
		if (str == "Area") {
			float array[] = new float[shapesOnScreen.size()];
			Map<Float, Shape> mapForPrintSorting = new HashMap<>();
			int i = 0;
			for (Shape shape : dimensions.keySet()) {
				array[i] = shape.getArea(dimensions.get(shape));
				mapForPrintSorting.put(array[i], shape);
				i++;
			}
			Arrays.sort(array);
			for (Float value : array) {
				System.out.println(mapForPrintSorting.get(value).getClass().getSimpleName().toUpperCase());
			}
		} else if (str == "Perimeter") {
			float array[] = new float[shapesOnScreen.size()];
			Map<Float, Shape> mapForPrintSorting = new HashMap<>();
			int i = 0;
			for (Shape shape : dimensions.keySet()) {
				array[i] = shape.getPerimeter(dimensions.get(shape));
				mapForPrintSorting.put(array[i], shape);
				i++;
			}
			Arrays.sort(array);
			for (Float value : array) {
				System.out.println(mapForPrintSorting.get(value).getClass().getSimpleName().toUpperCase());
			}
		} else if (str == "Time Stamp") {
			
		}
		
		
	}
	
	
}
