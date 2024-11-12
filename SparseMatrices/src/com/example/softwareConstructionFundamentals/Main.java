package com.example.softwareConstructionFundamentals;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		System.out.println("Assignment Deadline_30_Oct");
		
		Map<String, Integer> matrix1 = new HashMap<>();
		matrix1.put("0,0",1);
		matrix1.put("0,1",2);
		matrix1.put("1,1",3);
		matrix1.put("2,2",4);
		SparceMatrices sm1 = new SparceMatrices(matrix1);
		sm1.printMatrix(sm1.getMatrix());
		System.out.println();
		Map<String, Integer> matrix2 = new HashMap<>();
		matrix2.put("0,0",5);
		matrix2.put("1,0",6);
		matrix2.put("1,2",7);
		matrix2.put("2,2",8);
		SparceMatrices sm2 = new SparceMatrices(matrix2);
		sm2.printMatrix(sm2.getMatrix());
		System.out.println();
		
		SparceMatrices result = sm1.addTwoMatrix(matrix2);
		result.printMatrix(result.getMatrix());
		
	}
}
