package com.efraimgentil;

import java.util.Arrays;

public class RecursiveBinarySerach {

	public static void main(String[] args) {
		int SIZE = 8;
		Comparable[] a = new Integer[SIZE];
		for (int i = 0; i < SIZE; i++)
			a[i] = new Integer(i * 2);

		System.out.println( Arrays.asList(a).toString() );
		for (int i = 0; i < SIZE * 2; i++)
			System.out.println("Encontrado " + i + " em "	+ binarySearch(a, new Integer(i)));
	}

	private static int binarySearch(Comparable[] a, Integer i) {
		return binarySearch( a , i , 0 , ( a.length - 1)  );
	}

	private static int binarySearch(Comparable[] a, Integer searchValue, int first, int higherIndex) {
		if(first > higherIndex)
			return -1;
		
		int middleIndex = first  + ( higherIndex - first ) /2;
		int compareResult = a[middleIndex].compareTo(searchValue);
		
		System.out.println("SearchValue:" +  searchValue + " MiddleIndex:" +  middleIndex + " Resultado: " + compareResult );
		if( compareResult == 0){
			return middleIndex;
		}else if(compareResult < 0){
			return binarySearch(a, searchValue, middleIndex+1 , higherIndex);
		}else {
			return binarySearch(a, searchValue, first  , middleIndex - 1);
		}
	}

}
