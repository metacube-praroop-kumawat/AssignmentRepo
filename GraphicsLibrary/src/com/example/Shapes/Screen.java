package com.example.Shapes;

public class Screen {
	int XMAX;
	int YMAX;
	
	public Screen(int xMax, int yMax) {
		this.XMAX = xMax;
		this.YMAX = yMax;
	}

//	public void printScreen() {		
//		for (int i = 0; i < YMAX; i++) {
//			for (int j = 0; j < XMAX; j++) {
//				if (j == 0 || j == XMAX - 1 || i == 0 || i == YMAX -1) {
//					System.out.print("* ");
//				} else {
//					System.out.print("  ");
//				}
//			}
//			System.out.println();
//		}	
//	}
	public void addShape(Shape shapeType, Point point) {
		ShapeFactory shapeFactory = new ShapeFactory();
		shapeFactory.createShape(shapeType, point, null);
	
}
