package com.example.immutable;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntSet IntegerArrayObject1 = new IntSet(new Integer[]{1,3,6,7});
		IntSet integerArrayObject2 = new IntSet(new Integer[]{2,3,6});
		IntegerArrayObject1.getComplement();
		//System.out.println(IntegerArrayObject1.getComplement());
	}

}
