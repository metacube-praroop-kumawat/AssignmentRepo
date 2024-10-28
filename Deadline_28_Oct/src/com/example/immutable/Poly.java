package com.example.immutable;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public final class Poly {
	private final Integer[][] polynomial;
	
	public Poly( Integer[][] polynomial ) {
		Arrays.sort(polynomial, Comparator.comparingDouble(o -> o[0]));
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
	
	public String printPolynomial() {
		StringBuilder sb = new StringBuilder("");
		for ( int i = polynomial.length-1; i >=0; i--) {
			if ( polynomial[i][0] == 0 ) {
				sb.append(polynomial[i][1]);
			} else if ( polynomial[i][1] == 1 && polynomial[i][0] == 1 && i!=polynomial.length-1) {
				sb.append("x ");
			} else if ( polynomial[i][0] == 1 && polynomial[i][1] > 1 ) {
				sb.append(polynomial[i][1]+"x ");
			} else if (polynomial[i][0] > 1 && polynomial[i][1] == 1) {
				sb.append("x^"+polynomial[i][0]);
			} else {
				sb.append(polynomial[i][1]+"x^"+polynomial[i][0]);
			}
			if(i!=0) {
				sb.append(" + ");
			}
		}
		return sb.toString();
	}
	
	public float evaluate ( float var ) {
		float ans = 0;
		for ( int i=0; i < polynomial.length; i++ ) {
			ans += Math.pow(var, polynomial[i][0])*polynomial[i][1];
		}
		return ans;
	}
	
	public Integer degree () {
		return polynomial[polynomial.length-1][0];
	}
	
	public Poly addPolynomial ( Poly polynomial1 ) {
		//distinct values
		HashMap<Integer, Integer> map = new HashMap<>();
		for( int i = 0; i< polynomial.length; i++) {
			if(map.containsKey(polynomial[i][0])) {
				map.put(polynomial[i][0], map.get(polynomial[i][0])+polynomial[i][1]);
			}
			map.put(polynomial[i][0], polynomial[i][1]);
		}
		for( int i = 0; i< polynomial1.polynomial.length; i++) {
			if(map.containsKey(polynomial1.polynomial[i][0])) {
				map.put( polynomial1.polynomial[i][0], map.get( polynomial1.polynomial[i][0] ) + polynomial1.polynomial[i][1] );
			}
			map.put(polynomial1.polynomial[i][0], polynomial1.polynomial[i][1]);
		}
		// function code
		Integer ans[][] = new Integer[map.size()][2];
		int iterator1 = polynomial.length-1;
		int iterator2 = polynomial1.polynomial.length-1;
		int i = 0;
		while ( iterator1 >= 0 && iterator2 >= 0 ) {
			if ( polynomial[iterator1][0] > polynomial1.polynomial[iterator2][0] ) {
				ans[i][0] = polynomial[iterator1][0];
				ans[i][1] = polynomial[iterator1][1];
				iterator1--;
			} else if ( polynomial[iterator1][0] < polynomial1.polynomial[iterator2][0] ) {
				ans[i][0] = polynomial1.polynomial[iterator2][0];
				ans[i][1] = polynomial1.polynomial[iterator2][1];
				iterator2--;
			} else {
				ans[i][0] = polynomial[iterator1][0] ;
				ans[i][1] = polynomial[iterator1][1] + polynomial1.polynomial[iterator2][1];
				iterator1--;
				iterator2--;
			}
			i++;
		}
		while ( iterator1 >= 0 ) {
			ans[i][0] = polynomial[iterator1][0];
			ans[i][1] = polynomial[iterator1][1];
			iterator1--;
			i++;
		} 
		while ( iterator2 >= 0  ) {
			ans[i][0] = polynomial1.polynomial[iterator2][0];
			ans[i][1] = polynomial1.polynomial[iterator2][1];
			iterator2--;
			i++;
		}
		
		Poly ansPolynomial = new Poly(ans);
		ansPolynomial.printPolynomial();
		return ansPolynomial;
	}
	

}
