package Exercise;
/* Topic: Use 'Quick Sort' to sort 2 arrays A and B in increasing order with range from user input. Merge array A and B --> array C.
 * Use 'Bubble Sort' to sort array C in decreasing order.
 * Author: Nam Cap
 * Start Date: 25/5/23
 * End Date: 25/5/23
 * Version: 1.0
 * */
import java.util.Arrays;
import java.util.Scanner;

public class SortingExericise {
	final static int MIN = -50;
	final static int MAX = 50;
	
//	get all random values for array
	public static int[] getValues(int number) {
		int arr[] = new int[number];
		
		for(int i = 0; i< arr.length; i++) {
			arr[i] = MIN + (int)(Math.random()*((MAX - MIN )+1)); // get random value for arr[i]
		}
		
		return arr;
	}
//	print all values from array
	public static void printArray(int []arr) {
		
		for(int a: arr){
			System.out.print(a + " ");
		}
	}
	
//	Quick Sort method for increasing array
	public static int[] quickSort(int arr[], int left, int right) {
		int i, j, x;
		x = arr[(left + right)/2];
		i = left; 
		j = right;
		
		do { 
//			run from left --> middle (forward)
			while(arr[i] < x) {
				i++;
			}
//			run from right --> middle (backward)
			while(arr[j] > x) {
				j--;
			}
			
//			we sort value arr[indexLeft] and arr[indexRight] if 2 values is wrong position
			if(i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
			
		} while(i < j);
		if(left < j) 
		{
			quickSort(arr, left, j); // recursion left --> middle
		}
		if(i < right) {
			quickSort(arr, i, right); // recursion right --> middle
		}
		return arr;
	}
	
	public static int[] bubbleSort(int arr[]) {
		int i,j;
		
		for(i = 0; i< arr.length-1; i++) { // get value from last index - 1
			for(j = arr.length -1; j >i; j--) { // j run from last index to > i
				if(arr[j] > arr[j-1]) {
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the range of array A: ");
		int rangeA = scanner.nextInt();
		int arrayA [] = getValues(rangeA);
		System.out.print("Enter the range of array B: ");
		int rangeB = scanner.nextInt();
		int arrayB[] = getValues(rangeB);
		System.out.println("\nArray A with range " +rangeA +" is: ");
		printArray(arrayA);
		System.out.println("\n\nArray B with range "+ rangeB+" is: ");
		printArray(arrayB);
		
		System.out.println("\n\nWe are using Quick Sort for sort increasing array A ");
		int quickSortA [] = quickSort(arrayA, 0, arrayA.length - 1);
		System.out.println("Array A after used Quick Sort is: ");
		printArray(quickSortA);
		
		System.out.println("\n\nWe are using Quick Sort for sort increasing array B ");
		int quickSortB [] = quickSort(arrayB, 0, arrayB.length - 1);
		System.out.println("Array B after used Quick Sort is: ");
		printArray(quickSortB);
		
		// merging 2 arrays A and B
		int []mergeArray = new int[arrayA.length + arrayB.length];
		System.arraycopy(arrayA, 0, mergeArray, 0, arrayA.length);
		System.arraycopy(arrayB, 0, mergeArray, arrayA.length,arrayB.length);
		System.out.println("\n\nNew array merged from array A and array B is\n" + Arrays.toString(mergeArray));
		int []quickSortMerge = bubbleSort(mergeArray);
		System.out.println("\n\nNew array in order of decreasing values by using Bubble Sort is: " );
		printArray(quickSortMerge);
		scanner.close();
	}
}
