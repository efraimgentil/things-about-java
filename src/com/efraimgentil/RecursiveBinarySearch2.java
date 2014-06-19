package com.efraimgentil;

import java.util.Arrays;

public class RecursiveBinarySearch2 {
	
	public static void main(String[] args) {
		
		Comparable<Integer>[] numbers = new Integer[]{10,2,40,522,3,1,994,200,15};
		
		Arrays.sort(numbers);
		Integer[] numbersToFind = new Integer[]{ 2 , 3, 54, 994 , 1};
		
		System.out.println( Arrays.asList(numbers));
		for (Integer toFind : numbersToFind) {
			System.out.println("Number ["+ toFind +"] in position " + binarySearch( numbers , toFind ) );
		}
	}

	private static Integer binarySearch(Comparable[] numbersToFind, Integer toFind) {
		return binarySearch(numbersToFind, toFind , 0 ,  numbersToFind.length -1  );
	}

	private static Integer binarySearch(Comparable[] numbersToFind,
			Integer toFind, int lowestIndex, int higherIndex) {
		//if the range is depleted return -1
		if(lowestIndex > higherIndex)
			return -1;
		
		int middleIndex = (lowestIndex + higherIndex) / 2;
		int compareResult = numbersToFind[middleIndex].compareTo(toFind);
		
		System.out.println("SearchValue:" +  toFind + " MiddleIndex:" +  middleIndex + "{" + numbersToFind[middleIndex] + "} Resultado: " + compareResult );
		if(compareResult == 0)
			return middleIndex;
		else if (compareResult > 0){
			//if the number is bigger than the numberToFind it will cut the search range by half
			//and exclue the index of the number
			return binarySearch(numbersToFind, toFind , lowestIndex  , middleIndex - 1 );
		}else{
			//if the number is lower than the numberToFind it will cut the search range by half
			//and exclude the index of the number
			return binarySearch(numbersToFind, toFind , middleIndex + 1  , higherIndex );
		}
	}
	
}
