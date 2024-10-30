/*******************************************************************************************************
* @classname: sparceMatrices
* @author: Praroop
* Modification Log:
********************************************************************************************************
* Praroop Kumawat        2024/10/29         Making functions to operate on sparce Matrix
********************************************************************************************************/


package com.example.softwareConstructionFundamentals;

import java.util.ArrayList;
import java.util.Collections;

public final class SparceMatrices {
	private final ArrayList<DieCase> matrix = new ArrayList<>(); 
	
	public SparceMatrices(ArrayList<DieCase> matrix) {
		for (int i = 0; i < matrix.size(); i++ ) {
			this.matrix.add(matrix.get(i));
		}
	}
	
	public ArrayList<DieCase> getMatrix() {
		return this.matrix;	
	}
	
	public void printMatrix() {
		int maxRowIndex = 0;
		int maxColumnIndex = 0;
		//obtaining possible dimensions of matrix
		for (int i = 0; i < matrix.size(); i++) {
			maxRowIndex = maxRowIndex > matrix.get(i).row ? maxRowIndex : matrix.get(i).row;
			maxColumnIndex = maxColumnIndex > matrix.get(i).column ? maxColumnIndex : matrix.get(i).column;
		}
		//implementing 2D matrix
		int ansMatrix[][] = new int[maxRowIndex+1][maxColumnIndex+1];
		//filling 2D matrix
		for (int i = 0; i < matrix.size(); i++) {
			ansMatrix[matrix.get(i).row][matrix.get(i).column] = matrix.get(i).data;
		}
		for (int i = 0; i < ansMatrix.length; i++) {
			for (int j = 0; j < ansMatrix[0].length; j++) {
				System.out.print(ansMatrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public void addDieCase(DieCase dieCase) {
		matrix.add(dieCase);
	}
	
	public SparceMatrices transposeOfMatrix(ArrayList<DieCase> matrix) {
		for (int i = 0; i < matrix.size(); i++) {
			int temp = matrix.get(i).column;
			matrix.get(i).column = matrix.get(i).row;
			matrix.get(i).row = temp;
		}
		SparceMatrices transposeMatrix = new SparceMatrices(matrix);
		return transposeMatrix;
	}
	
	public boolean isSymmetricMatrix() {
		SparceMatrices transposeMatrix = transposeOfMatrix(matrix);
		for (int i = 0; i < matrix.size(); i++) {
			if (matrix.get(i).column != transposeMatrix.matrix.get(i).column ||
				matrix.get(i).row != transposeMatrix.matrix.get(i).row ||
				matrix.get(i).data != transposeMatrix.matrix.get(i).data) {
				return false;
			}
		}
		return true;
	}
	
	public SparceMatrices addTwoMatrix(ArrayList<DieCase> matrix2) {
		SparceMatrices addResult;
		ArrayList<DieCase> result = new ArrayList<>();
		for (int i = 0; i < matrix.size(); i++) {
			for (int j = 0; j < matrix2.size(); j++) {
				if (matrix.get(i).column == matrix2.get(j).column || matrix.get(i).row == matrix2.get(j).row) {
					DieCase dieCase = new DieCase(matrix.get(i).row, matrix.get(i).column, matrix.get(i).data + matrix2.get(j).data);
					result.add(dieCase);
				} else if (matrix.get(i).row == matrix2.get(j).row && matrix.get(i).column != matrix2.get(j).column) {
					if (matrix.get(i).column > matrix2.get(j).column) {
						DieCase dieCase = new DieCase(matrix2.get(j).row, matrix2.get(j).column, matrix2.get(j).data);
						result.add(dieCase);
					} else {
						DieCase dieCase = new DieCase(matrix.get(i).row, matrix.get(i).column, matrix.get(i).data);
						result.add(dieCase);
					}
				} else if (matrix.get(i).row < matrix2.get(j).row ) {
					DieCase dieCase = new DieCase(matrix.get(i).row, matrix.get(i).column, matrix.get(i).data);
					result.add(dieCase);
					//matrix2 pair is less than matrix
				} else if (matrix.get(i).row > matrix2.get(j).row ) {
					DieCase dieCase = new DieCase(matrix2.get(j).row, matrix2.get(j).column, matrix2.get(j).data);
					result.add(dieCase);
				}
			}
		}
		addResult = new SparceMatrices(result);
		return addResult;		
	}

	
	
}
