/*******************************************************************************************************
* @classname: IntSet
* @author: Praroop
* Modification Log:
********************************************************************************************************
* Praroop Kumawat        2024/10/29         Making functions to operate on Sets
********************************************************************************************************/


package com.example.immutable;

public final class IntSet {
	//array representing integers in the range 1-1000
	private final Integer[] set; 
	
	//constructor
	public IntSet(Integer[] elements) {
		set = new Integer[elements.length];
		int indexOfIntSetArray = 0;
		for (int i = 0; i < elements.length; i++) {
			if (elements[i] >= 1 && elements[i] <= 1000) {
				set[indexOfIntSetArray] = elements[i];
				indexOfIntSetArray++;
			} else {
				throw new IllegalArgumentException ("All elemets must be in the range 1-1000");
			}
		}
	}
	
	/**
	 * check if parameter x is a part of set or not
	 * @param x to value in Set which we are looking for
	 * @return boolean true if x is present 
	 */
	public boolean isMember(int x) {
		//iterating on set
		for (Integer value : set) {
			if (value == x) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * gives the size of set
	 * @return int size of set
	 */
	public int size() {
		return set.length;
	}
	
	/**
	 * check whether IntSet array is a subset or not
	 * @param array the subset
	 * @return boolean true if yes subset
	 */
	public boolean isSubSet (IntSet array) {
		int matchedElements = 0;
		//checking the values of subset are present in set or not
		for (Integer valueInSubSet : array.set) {
			for (int i = 0; i < set.length; i++) {
				if (valueInSubSet == set[i]) {
					matchedElements++;
				}
			}
		}
		//all the elements of subset is present in set
		if (matchedElements == array.set.length) {
			return true;
		}
		return false;
	}
	
	/**
	 *get component set (1-1000 elements not present in the current set)
	 * @return Integer type array of complement 
	 */
	public Integer[] getComplement() {
		//universal array to see what elements are not present in set
		Integer universalSet[] = new Integer[1000];
		for (int i = 0; i < 1000; i++) {
			universalSet[i] = 0;
		}
		for (Integer elements : set) {
			universalSet[elements-1] = elements;
		}
		Integer complement[] = new Integer[1000-set.length];
		int j = 0; 
		//if universal array have 0 value then the element is not present in set
		for (int i = 0; i < universalSet.length; i++) {
			if (universalSet[i] == 0) {
				complement[j] = i+1;
				j++;
			}
		}
		printSet(complement);
		return complement;
	}
	
	/**
	 * get union of two sets
	 * @param intSet IntSet object in which array is present
	 * @return Integer array resulted by union 
	 */
	public Integer[] union(IntSet intSet) {
		//universal array to see what elements are present in set
		boolean universalSet[] = new boolean[1000];
		//taking input for set1
		for (int i = 0; i < set.length; i++) {
			universalSet[set[i]-1] = true;
		}
		//taking input for set2
		for (int i = 0; i < intSet.set.length; i++) {
			universalSet[intSet.set[i]-1] = true;
		}
		int ansSize = 0;
		int index = 0;
		for (int i = 0; i < universalSet.length; i++) {
			if (universalSet[i] == true) {
				ansSize++;
			}
		}
		//inserting union elements from universal array to union array
		Integer union[] = new Integer[ansSize];
		for (int i = 0; i < universalSet.length; i++) {
			if (universalSet[i] == true) {
				union[index] = i+1;
				index ++;
			}
		}
		printSet(union);
		return union;		
	}
	
	/**
	 * printing the elements of set
	 * @param set of which we want to print elements
	 */
	public void printSet(Integer set[]) {
		for (int i = 0; i < set.length-1; i++) {
			System.out.print(set[i]+", ");
		}
		System.out.print(set[set.length-1]);
	}
}
