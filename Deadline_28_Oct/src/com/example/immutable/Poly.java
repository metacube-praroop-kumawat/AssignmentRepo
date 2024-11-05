/*******************************************************************************************************
* @classname: Poly
* @author: Praroop
* Modification Log:
********************************************************************************************************
* Praroop Kumawat        2024/10/29         Making functions to operate on polynomials
********************************************************************************************************/

package com.example.immutable;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public final class Poly {
	private final Integer[][] polynomial;
	
	public Poly(Integer[][] polynomial) {
		this.polynomial  = new Integer[polynomial.length][2];
		//polynomial[][0] -> degree
		//polynomial[][1] -> coefficient 
		for (int i = 0; i < polynomial.length; i++) {
			if(polynomial[i][1] == 0 ) {
				continue;
			}
			this.polynomial[i][0] = polynomial[i][0];
			this.polynomial[i][1] = polynomial[i][1];
		}
	}
	
	/**
	 * converting to polynomial expression from 2-D Array
	 * @return string in polynomial expression form
	 */
	public String printPolynomial() {
		Arrays.sort(polynomial, Comparator.comparingDouble(o -> o[0]));
		StringBuilder sb = new StringBuilder("");
		for (int i = polynomial.length-1; i >=0; i--) {
			//degree is 0 than only coefficient is printed
			if (polynomial[i][0] == 0 ) {
				sb.append(polynomial[i][1]);
			// coefficient is 1 therefore only x is printed	
			} else if (polynomial[i][1] == 1 && polynomial[i][0] == 1 && i!=polynomial.length-1) {
				sb.append("x ");
			//degree is 1 and coefficient is greater than 1,eg:- 3x is printed	
			} else if (polynomial[i][0] == 1 && polynomial[i][1] > 1) {
				sb.append(polynomial[i][1]+"x ");
			//degree is greater than 1 and coefficient is 1, eg:- x^2	
			} else if (polynomial[i][0] > 1 && polynomial[i][1] == 1) {
				sb.append("x^"+polynomial[i][0]);
			//other case, eg:- 3x^4	
			} else {
				sb.append(polynomial[i][1]+"x^"+polynomial[i][0]);
			}
			if (i!=0) {
				sb.append(" + ");
			}
		}
		return sb.toString();
	}
	
	/**
	 * for a value of variable x calculates the polynomial expression
	 * @param var float value for which calculate expression by substituting it with x
	 * @return the value of the expression
	 */
	public float evaluate(float var) {
		float ans = 0;
		for (int i=0; i < polynomial.length; i++) {
			//multiplying coefficient*(var^degree)
			ans += Math.pow(var, polynomial[i][0])*polynomial[i][1];
		}
		return ans;
	}
	
	/**
	 * gives the highest degree of the polynomial expression
	 * @return Integer the highest degree
	 */
	public Integer degree() {
		//last index in array stores the highest degree
		return polynomial[polynomial.length-1][0];
	}
	
	/**
	 * add two different polynomial expressions
	 * @param polynomial1 another Poly object
	 * @return a new Poly object resulted by addition
	 */
	public static Poly addPolynomial(Poly polynomial1, Poly polynomial2) {
		HashMap<Integer, Integer> map = new HashMap<>();
		//storing degree and coefficient pair in HashMap for polynomial
		for (int i = 0; i < polynomial2.polynomial.length; i++) {
			if (map.containsKey(polynomial2.polynomial[i][0])) {
				map.put(polynomial2.polynomial[i][0], map.get(polynomial2.polynomial[i][0])+polynomial2.polynomial[i][1]);
			} else {
				map.put(polynomial2.polynomial[i][0], polynomial2.polynomial[i][1]);
			}
		}
		//storing degree and coefficient pair in HashMap for polynomial1
		for (int i = 0; i < polynomial1.polynomial.length; i++) {
			if (map.containsKey(polynomial1.polynomial[i][0])) {
				map.put(polynomial1.polynomial[i][0], map.get(polynomial1.polynomial[i][0])+polynomial1.polynomial[i][1]);
			} else {
				map.put(polynomial1.polynomial[i][0], polynomial1.polynomial[i][1]);
			}
		}
		Integer ans[][] = new Integer[map.size()][2];
		int index = 0;
		//creating new Poly object with resultant addition array
		for (Integer degree : map.keySet()) {
			ans[index][0] = degree;
			ans[index++][1] = map.get(degree);
		}
		Poly ansPolynomial = new Poly(ans);
		return ansPolynomial;
	}
	
	/**
	 * multiplies two polynomials and gives the resultant polynomial
	 * @param polynomial2 another Poly object with which we want multiplication
	 * @return a new Poly object resulted by multiplication
	 */
	public static Poly multiplyPoly(Poly polynomial1, Poly polynomial2) {
		HashMap<Integer, Integer> map = new HashMap<>();
		//storing degree and coefficient pair in HashMap
		for (int i = 0; i < polynomial1.polynomial.length; i++) {
			for (int j = 0; j < polynomial2.polynomial.length; j++) {
				if (map.containsKey(polynomial1.polynomial[i][0]+polynomial2.polynomial[j][0])) {
					map.put(polynomial1.polynomial[i][0]+polynomial2.polynomial[j][0], 
					map.get(polynomial1.polynomial[i][0]+polynomial2.polynomial[j][0])+ polynomial1.polynomial[i][1]*polynomial2.polynomial[j][1]);
				} else {
					map.put(polynomial1.polynomial[i][0]+polynomial2.polynomial[j][0], polynomial1.polynomial[i][1]*polynomial2.polynomial[j][1]);
				}
			}
		}
		Integer ans[][] = new Integer[map.size()][2];
		int index = 0;
		//inserting degree coefficient pair into 2D array
		for (Integer degree : map.keySet()) {
			ans[index][0] = degree;
			ans[index][1] = map.get(degree);
			index++;
		}
		//creating new Poly object with resultant multiplication array
		Poly ansPolynomial = new Poly(ans);
		return ansPolynomial;
		
	}
	

}
