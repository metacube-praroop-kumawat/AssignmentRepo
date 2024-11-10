package com.example.softwareConstructionFundamentals;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class SparceMatricesTest {

	@Test
	void transposeOfMatrix_noArguments_returnsTransposeOfMatrix() {
		
		Map<String, Integer> matrix1 = new HashMap<>();
		matrix1.put("0,0",1);
		matrix1.put("0,1",2);
		matrix1.put("1,1",3);
		matrix1.put("2,2",4);
		SparceMatrices sparceMatrix1 = new SparceMatrices(matrix1);

		Map<String, Integer> expected1 = (sparceMatrix1.transposeOfMatrix());
		
		Map<String, Integer> matrix2 = new HashMap<>();		
		matrix2.put("0,0",1);
		matrix2.put("1,0",2);
		matrix2.put("1,1",3);
		matrix2.put("2,2",4);
		Map<String, Integer> actual1 = matrix2; 
		
		assertEquals(actual1, expected1);
		
	}
	
	@Test
	void isSymmetricMatrix_noArguments_returnTrueIfSymmetric() {
		Map<String, Integer> matrix1 = new HashMap<>();
		matrix1.put("0,0",1);
		matrix1.put("0,1",2);
		matrix1.put("1,1",3);
		matrix1.put("2,2",4);
		SparceMatrices sparceMatrix1 = new SparceMatrices(matrix1);

		Map<String, Integer> matrix2 = new HashMap<>();
		matrix2.put("0,0",1);
		matrix2.put("0,1",2);
		matrix2.put("1,0",2);
		matrix2.put("1,1",3);
		matrix2.put("2,2",4);
		SparceMatrices sparceMatrix2 = new SparceMatrices(matrix2);
		
		boolean expected1 =  sparceMatrix1.isSymmetricMatrix();
		boolean expected2 = sparceMatrix2.isSymmetricMatrix();
		
		boolean actual1 = false;
		boolean actual2 = true;
		
		assertEquals(actual1, expected1);
		assertEquals(actual2, expected2);
	}

}
