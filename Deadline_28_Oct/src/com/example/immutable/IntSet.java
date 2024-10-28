package com.example.immutable;

public final class IntSet {
	private final Integer[] set; //array representing integers in the range 1-1000
	
	//constructor
	public IntSet(Integer[] elements) {
		set = new Integer[elements.length];
		int indexOfIntSetArray = 0;
		for ( int i = 0; i < elements.length; i++ ) {
			if ( elements[i] >= 1 && elements[i] <= 1000 ) {
				set[indexOfIntSetArray] = elements[i];
				indexOfIntSetArray++;
			} else {
				throw new IllegalArgumentException ("All elemets must be in the range 1-1000");
			}
		}
	}
	
	//check if an integer x is a member of the set
	public boolean isMember(int x ) {
		for( Integer value : set ) {
			if ( value == x ) {
				return true;
			}
		}
		return false;
	}
	
	//return the size of the set
	public int size() {
		return set.length;
	}
	
	//check whether s is a subset or not
	public boolean isSubSet ( IntSet array ) {
		int matchedElements = 0;
		for ( Integer valueInSubSet : array.set ) {
			for ( int i = 0; i < set.length; i++ ) {
				if ( valueInSubSet == set[i] ) {
					matchedElements++;
				}
			}
		}
		if ( matchedElements == array.set.length) {
			return true;
		}
		return false;
	}
	
	//get component set (1-1000 elements not present in the current set)
	public Integer[] getComplement() {
		Integer universalSet[] = new Integer[1000];
		for(int i = 0; i < 1000; i++) {
			universalSet[i] = 0;
		}
		for ( Integer elements : set ) {
			universalSet[elements-1] = elements;
		}
		Integer complement[] = new Integer[1000-set.length];
		int j = 0; 
		for ( int i = 0; i < universalSet.length; i++ ) {
			if ( universalSet[i] == 0 ) {
				complement[j] = i+1;
				j++;
			}
		}
		printSet(complement);
		return complement;
	}
	
	public void printSet(Integer set[]) {
		for (int i = 0; i < set.length; i++ ) {
			System.out.print(set[i]+", ");
		}
	}
}
