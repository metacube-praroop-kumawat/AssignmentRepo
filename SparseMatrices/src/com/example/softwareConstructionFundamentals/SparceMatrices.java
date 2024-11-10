/*******************************************************************************************************
* @classname: sparceMatrices
* @author: Praroop
* Modification Log:
********************************************************************************************************
* Praroop Kumawat        2024/10/29         Making functions to operate on sparce Matrix
********************************************************************************************************/


package com.example.softwareConstructionFundamentals;

import java.util.Map;
import java.util.HashMap;

public final class SparceMatrices {
	private Map<String, Integer> matrix = new HashMap<>();
	//row,col
	
	/**
	 * constructor
	 * @param matrix ArrayList containing nonzero elements of matrix
	 */
	public SparceMatrices(Map<String, Integer> matrix) {
		this.matrix = matrix;
	}
	
	/**
	 * getter function 
	 * @return the matrix which have nonzero elements of matrix
	 */
	public Map<String, Integer> getMatrix() {
		return this.matrix;	
	}
	
	/**
	 * printing the matrix
	 * @param matrix ArrayList containing nonzero elements of matrix
	 */
	public void printMatrix(Map<String, Integer> matrix) {
		int maxRowIndex = 0;
		int maxColumnIndex = 0;
		//obtaining possible dimensions of matrix
		for (String rowCol : matrix.keySet()) {
			maxRowIndex = maxRowIndex > Integer.valueOf(rowCol.charAt(0))-48 ? maxRowIndex :Integer.valueOf(rowCol.charAt(0))-48;
			maxColumnIndex = maxColumnIndex > Integer.valueOf(rowCol.charAt(2))-48 ? maxColumnIndex : Integer.valueOf(rowCol.charAt(2))-48;
		}
		//implementing 2D matrix
		int ansMatrix[][] = new int[maxRowIndex+1][maxColumnIndex+1];
		//filling 2D matrix
		for (String rowCol : matrix.keySet()) {
			ansMatrix[Integer.valueOf(rowCol.charAt(0))-48][Integer.valueOf(rowCol.charAt(2))-48] = matrix.get(rowCol);
		}
		for (int i = 0; i < ansMatrix.length; i++) {
			for (int j = 0; j < ansMatrix[0].length; j++) {
				System.out.print(ansMatrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	/**
	 * to add a nonzero element of matrix to ArrayList
	 * @param dieCase DieCase object containing row, column and data of the entry
	 */
	public void addDieCase(String rowCol, Integer value) {
		matrix.put(rowCol, value);
	}
	
	/**
	 * to get a transpose of a sparse matrix
	 * @return SparceMatrices instance 
	 */
	public Map<String, Integer> transposeOfMatrix() {
		Map<String, Integer> transposeMatrix = new HashMap<>();
		for (String rowCol : this.matrix.keySet()) {
			 transposeMatrix.put(rowCol.charAt(2)+","+rowCol.charAt(0), matrix.get(rowCol)) ;
		}
		return transposeMatrix;
	}
	
	/**
	 * to check if the matrix is symmetric or not
	 * @return boolean true if symmetric else false
	 */
	public boolean isSymmetricMatrix() {
		Map<String, Integer> transposeMatrix = transposeOfMatrix();
		boolean haveImage[] = new boolean[matrix.size()];
		int index = 0;
		for (String rowCol : this.matrix.keySet()) {
			if (transposeMatrix.get(rowCol.charAt(0)+","+rowCol.charAt(2)) == this.matrix.get(rowCol.charAt(0)+","+rowCol.charAt(2))) {
				haveImage[index] = true;
				index++;
			}
		}
		for(int i = 0; i < haveImage.length; i++) {
			if(haveImage[i] == false) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * add two matrices
	 * @param matrix2 ArrayList containing nonzero elements of matrix
	 * @return the resultant added matrix 
	 */
	public SparceMatrices addTwoMatrix(Map<String, Integer> matrix2) {
		SparceMatrices addResult;
		Map<String, Integer> result = new HashMap<>();
		for (String rowCol : this.matrix.keySet()) {
			if (matrix2.containsKey(rowCol)) {
				result.put(rowCol, this.matrix.get(rowCol) + matrix2.get(rowCol));
			} else {
				result.put(rowCol, this.matrix.get(rowCol));
			}
		}
		for (String rowCol : matrix2.keySet()) {
			if (!result.containsKey(rowCol)) {
				result.put(rowCol, matrix2.get(rowCol));
			}
		}
		addResult = new SparceMatrices(result);
		return addResult;		
	}

	/**
	 * to multiply two matrices
	 * @param matrix2 ArrayList containing nonzero elements of matrix
	 * @param rowsA number of rows in matrix1
	 * @param colsA number of columns in matrix1 
	 * @param colsB number of columns in matrix2
	 * @return the resultant of multiplication
	 */
	public SparceMatrices multiplyMatrix(Map<String, Integer> matrix2) {
		//Result matrix elements
		Map<String, Integer> result = new HashMap<>();
		
		
		SparceMatrices multiplyResult = new SparceMatrices(result);
		return multiplyResult;	
	}
	
	
}
