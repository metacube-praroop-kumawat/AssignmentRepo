package com.example.softwareConstructionFundamentals;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class SparceMatricesTest {

	@Test
	void transposeOfMatrix_noArguments_returnsTransposeOfMatrix() {
		
		ArrayList<DieCase> matrix1 = new ArrayList<>();
		matrix1.add(new DieCase(0,0,1));
		matrix1.add(new DieCase(0,1,2));
		matrix1.add(new DieCase(1,1,3));
		matrix1.add(new DieCase(2,2,4));
		SparceMatrices sparceMatrix1 = new SparceMatrices(matrix1);

		ArrayList<DieCase> expected1 = (sparceMatrix1.transposeOfMatrix());
		
		ArrayList<DieCase> matrix2 = new ArrayList<>();
		matrix2.add(new DieCase(0,0,1));
		matrix2.add(new DieCase(1,0,2));
		matrix2.add(new DieCase(1,1,3));
		matrix2.add(new DieCase(2,2,4));
		ArrayList<DieCase> actual1 = matrix2; 
		
		assertEquals(actual1, expected1);
		
	}
	
	@Test
	void isSymmetricMatrix_noArguments_returnTrueIfSymmetric() {
		ArrayList<DieCase> matrix1 = new ArrayList<>();
		matrix1.add(new DieCase(0,0,1));
		matrix1.add(new DieCase(0,1,2));
		matrix1.add(new DieCase(1,1,3));
		matrix1.add(new DieCase(2,2,4));
		SparceMatrices sparceMatrix1 = new SparceMatrices(matrix1);

		ArrayList<DieCase> matrix2 = new ArrayList<>();
		matrix2.add(new DieCase(0,0,1));
		matrix2.add(new DieCase(0,1,2));
		matrix2.add(new DieCase(1,0,2));
		matrix2.add(new DieCase(1,1,3));
		matrix2.add(new DieCase(2,2,4));
		SparceMatrices sparceMatrix2 = new SparceMatrices(matrix2);
		
		boolean expected1 =  sparceMatrix1.isSymmetricMatrix();
		boolean expected2 = sparceMatrix2.isSymmetricMatrix();
		
		boolean actual1 = false;
		boolean actual2 = true;
		
		assertEquals(actual1, expected1);
		assertEquals(actual2, expected2);
	}

}
