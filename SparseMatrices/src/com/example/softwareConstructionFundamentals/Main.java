package com.example.softwareConstructionFundamentals;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Assignment Deadline_30_Oct");
		
		ArrayList<DieCase> matrix1 = new ArrayList<>();
		matrix1.add(new DieCase(0,0,1));
		matrix1.add(new DieCase(0,1,2));
		
		matrix1.add(new DieCase(1,1,3));
		matrix1.add(new DieCase(2,2,4));
		SparceMatrices sm1 = new SparceMatrices(matrix1);
		sm1.printMatrix(sm1.getMatrix());
		System.out.println();
		ArrayList<DieCase> matrix2 = new ArrayList<>();
		matrix2.add(new DieCase(0,0,5));
		matrix2.add(new DieCase(1,0,6));
		matrix2.add(new DieCase(1,2,7));
		matrix2.add(new DieCase(2,2,8));
		SparceMatrices sm2 = new SparceMatrices(matrix2);
		sm2.printMatrix(sm2.getMatrix());
		System.out.println();
		
		boolean result = sm1.isSymmetricMatrix();
		System.out.print(result);
//		result.printMatrix(result.getMatrix());
		
		
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
