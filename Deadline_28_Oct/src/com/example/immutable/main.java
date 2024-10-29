package com.example.immutable;

public class main {

	public static void main(String[] args) {
		//IntSet class functions called
		IntSet integerArrayObject1 = new IntSet(new Integer[]{1,3,6,7});
		IntSet integerArrayObject2 = new IntSet(new Integer[]{2,3,6});
		System.out.print("The union of two sets are:" + '\n');
		integerArrayObject1.union(integerArrayObject2);
		System.out.println();
		System.out.println();
		System.out.println();
		//Poly class function called
		Integer arr[][] = {{2,1}, {1,3}, {0,1}};
		Poly polynomial = new Poly(arr);
		Integer arr1[][] = {{4,1},{3,1},{2,1},{1,1},{0,1},{5,3}};
		Poly poly2 = new Poly(arr1);
		Poly poly3 = poly2.addPolynomial(polynomial);
		System.out.println("The resultant polynomial from the addition of two polynomial " + '\n' + polynomial.printPolynomial() +
				" and " + '\n' + poly2.printPolynomial() + " is :- " + '\n' + poly3.printPolynomial());
	}

}
