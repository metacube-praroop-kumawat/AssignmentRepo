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
	
	public void printMatrix(ArrayList<DieCase> matrix) {
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
	
	public SparceMatrices transposeOfMatrix() {
		ArrayList<DieCase> transposeMatrix = new ArrayList<>();
		for (int i = 0; i < matrix.size(); i++) {
			 transposeMatrix.add(new DieCase(matrix.get(i).column,matrix.get(i).row,matrix.get(i).data)) ;
		}
		SparceMatrices result = new SparceMatrices(transposeMatrix);
		return result;
	}
	
	public boolean isSymmetricMatrix() {
		SparceMatrices transposeMatrix = transposeOfMatrix();
		boolean haveImage[] = new boolean[matrix.size()];
		for (int i = 0; i < matrix.size(); i++) {
			for (int j = 0; j < transposeMatrix.matrix.size(); j++) {
				if(matrix.get(i).row == transposeMatrix.matrix.get(j).row &&
						matrix.get(i).column == transposeMatrix.matrix.get(j).column &&
						matrix.get(i).data == transposeMatrix.matrix.get(j).data) {
					haveImage[i] = true;
				}
			}
		}
		for(int i = 0; i < haveImage.length; i++) {
			if(haveImage[i] == false) {
				return false;
			}
		}
		return true;
	}
	
	public SparceMatrices addTwoMatrix(ArrayList<DieCase> matrix2) {
		SparceMatrices addResult;
		ArrayList<DieCase> result = new ArrayList<>();
		int iteratorOnMatrix = 0;
		int iteratorOnMatrix2 = 0;
		while (iteratorOnMatrix < matrix.size() && iteratorOnMatrix2 < matrix2.size()) {
			if (matrix.get(iteratorOnMatrix).row == matrix2.get(iteratorOnMatrix2).row) {
				if (matrix.get(iteratorOnMatrix).column == matrix2.get(iteratorOnMatrix2).column) {
					DieCase diecase = new DieCase(matrix.get(iteratorOnMatrix).row, matrix.get(iteratorOnMatrix).column, matrix.get(iteratorOnMatrix).data + matrix2.get(iteratorOnMatrix2).data);
					result.add(diecase);
					iteratorOnMatrix++;
					iteratorOnMatrix2++;
				} else if (matrix.get(iteratorOnMatrix).column < matrix2.get(iteratorOnMatrix2).column) {
					DieCase diecase = new DieCase(matrix.get(iteratorOnMatrix).row, matrix.get(iteratorOnMatrix).column, matrix.get(iteratorOnMatrix).data);
					result.add(diecase);
					iteratorOnMatrix++;
				} else {
					DieCase diecase = new DieCase(matrix2.get(iteratorOnMatrix2).row, matrix2.get(iteratorOnMatrix2).column, matrix2.get(iteratorOnMatrix2).data);
					result.add(diecase);
					iteratorOnMatrix2++;
					}
				} else if (matrix.get(iteratorOnMatrix).row < matrix2.get(iteratorOnMatrix2).row) {
					DieCase diecase = new DieCase(matrix.get(iteratorOnMatrix).row, matrix.get(iteratorOnMatrix).column, matrix.get(iteratorOnMatrix).data);
					result.add(diecase);
					iteratorOnMatrix++;
				} else {
					DieCase diecase = new DieCase(matrix2.get(iteratorOnMatrix2).row, matrix2.get(iteratorOnMatrix2).column, matrix2.get(iteratorOnMatrix2).data);
					result.add(diecase);
					iteratorOnMatrix2++;
				}
		}
		while (iteratorOnMatrix < matrix.size()) {
			DieCase diecase = new DieCase(matrix.get(iteratorOnMatrix).row, matrix.get(iteratorOnMatrix).column, matrix.get(iteratorOnMatrix).data);
			result.add(diecase);
			iteratorOnMatrix++;
		}
		while (iteratorOnMatrix2 < matrix2.size()) {
			DieCase diecase = new DieCase(matrix2.get(iteratorOnMatrix2).row, matrix2.get(iteratorOnMatrix2).column, matrix2.get(iteratorOnMatrix2).data);
			result.add(diecase);
			iteratorOnMatrix2++;
		}
		addResult = new SparceMatrices(result);
		return addResult;		
	}

	public SparceMatrices multiplyMatrix(ArrayList<DieCase> matrix2, int rowsA, int colsA, int colsB) {
		//Result matrix elements
		ArrayList<DieCase> result = new ArrayList<>();
		
		//Map matrix B by column to make lookup efficient
		//group non zero elems of matrix2 by their col
		ArrayList<DieCase>[] bColMap = new ArrayList[colsB];
		for (int i = 0; i < colsB; i++) {
			bColMap[i] = new ArrayList<>();
		}
		
		for (DieCase bElem : matrix) {
			bColMap[bElem.row].add(bElem);//grouping by row in b
		}
		
		//multiplication logic
		for (DieCase aElem : matrix2) {
			int aRow = aElem.row;
			int aCol = aElem.column;
			int aVal = aElem.data;
			
			//for each element in B that shares the same column as aElem
			for (DieCase bElem : bColMap[aCol]) {
				
				//we found matching positions in A and B to multiply
				int resultRow = aRow;
				int resultCol = bElem.column;
				int product = aVal * bElem.data;
				
				//check if there a already an entry for (resultRow, resultCol)
				boolean found = false;
				for (DieCase resElem : result) {
					if (resElem.row == resultRow && resElem.column == resultCol) {
						resElem.data += product;
						found = true;
						break;
					}
				}
				//if no entry exists create a new one
				if (!found) {
					result.add(new DieCase(resultRow, resultCol, product));
				}
			}
		}
		SparceMatrices multiplyResult = new SparceMatrices(result);
		return multiplyResult;	
	}
	
	
}
