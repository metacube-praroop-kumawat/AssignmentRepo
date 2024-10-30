package com.example.softwareConstructionFundamentals;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Assignment Deadline_30_Oct");
		SparceMatrices matrix ;	
		DieCase dieCase1 = new DieCase(0,1,1);
		DieCase dieCase2 = new DieCase(0,2,2);
		DieCase dieCase3 = new DieCase(1,0,1);
		DieCase dieCase4 = new DieCase(2,0,2);
		DieCase dieCase5 = new DieCase(2,1,5);
		
		DieCase dieCase6 = new DieCase(0,0,1);
		DieCase dieCase7 = new DieCase(0,1,3);
		DieCase dieCase8 = new DieCase(0,2,5);
		DieCase dieCase9 = new DieCase(1,1,1);
		DieCase dieCase10 = new DieCase(2,0,4);
		DieCase dieCase11 = new DieCase(2,1,4);
		DieCase dieCase12 = new DieCase(2,2,4);
		
		ArrayList<DieCase> matrix1 = new ArrayList<>();
		matrix1.add(dieCase1);
		matrix1.add(dieCase2);
		matrix1.add(dieCase3);
		matrix1.add(dieCase4);
		matrix1.add(dieCase5);
		SparceMatrices sm1 = new SparceMatrices(matrix1);
		sm1.printMatrix();
		System.out.println();
		ArrayList<DieCase> matrix2 = new ArrayList<>();
		matrix2.add(dieCase6);
		matrix2.add(dieCase7);
		matrix2.add(dieCase8);
		matrix2.add(dieCase9);
		matrix2.add(dieCase10);
		matrix2.add(dieCase11);
		matrix2.add(dieCase12);
		SparceMatrices sm2 = new SparceMatrices(matrix2);
		sm2.printMatrix();
		System.out.println();
		
		SparceMatrices result = sm2.addTwoMatrix(sm1.getMatrix());
		result.printMatrix();
		
		
//		boolean condition = true;
//		while (condition ) {
//			System.out.print("Enter the row, column and value you want to enter :" + '\n');
//			int row = sc.nextInt();
//			int column = sc.nextInt();
//			int value = sc.nextInt();
//			DieCase dieCase = new DieCase(row, column, value);
//			matrix.addDieCase(dieCase);
//			System.out.print("Do you want to continue ? Y/N : ");
//			char yesNo = sc.next().charAt(0);
//			System.out.println();
//			if(yesNo == 'N' || yesNo == 'n') {
//				condition = false;
//			}
//		}
//		matrix.transposeOfMatrix();
	}
}
