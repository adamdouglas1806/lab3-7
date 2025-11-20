import java.util.ArrayList;
import java.util.Iterator;

public class ArraySort {

	/** Insertion sort of an array
	 * @param arr the array to be sorted in-place
	 */
	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int cur = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > cur) {
				arr[j + 1] = arr[j--];
				arr[j + 1] = cur;
			}
		}
	}

	/** Insertion sort of an array
	 * 
	 * This is Question 4
	 * 
	 * Where N is the number of elements in the array 'arr' the complexity is:
	 *
	 * O(n^2)
	 * 
	 * Because: Since there is a nested loop the more data/elements that are in the list the longer it will take for the bubble sort to sort the data. Due to the nested loop
	 * the loop on the outside and the loop on the inside will both run n and n-1 times. In other words; the more elements the list has the longer it will take to compile.
	 * 
	 * @param arr the array to be sorted in-place
	 */
	public static void bubbleSort(int[] arr) {

		boolean swaps = true;
		//Declares a new variable swaps which is equal to true;
		int temp;
		//Declares a new variable temp which will later be used to store the arr[i].
		
		while (swaps) {
		//A while loop which will continue to loop whilst swaps = true;
			swaps = false;
			//Sets swaps to false.
			
			for (int i = 0; i < arr.length - 1; i++) {
			//A for loop which will loop the for length of the array arr.
				if (arr[i+1] < arr[i]) {
				//An if statement which checks if the next element in the array is smaller than the current element.
					temp = arr[i];
					//Sets the temp value to the current index.
					arr[i] = arr[i+1];
					//Sets the current index to the next index.
					arr[i+1] = temp;
					//Sets the next index to the temp value (the original current index).
					swaps = true;
					//Sets swaps to true.
				}
			}
		}
		
	}

	/** Quick sort of an array. This method creates a new array with
	 * its values sorted, based on the values in the unsorted input array S.
	 * 
	 * This is Question 6
	 * 
	 * TODO Where N is the number of elements in the array 'S' the complexity is:
	 *
	 * O(?)
	 * 
	 * Because: TODO
	 * 
	 * @param S the unsorted input array
	 * @return the sorted output array
	 */
	public static ArrayList<Integer> quickSort(ArrayList<Integer> S) {

		return null; // TODO
	}

	
	/** predicate to check if array is sorted
	 * @param arr the array to be checked
	 * @return true if the array is sorted, false otherwise
	 */
	public static boolean isSorted(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++)
			if (arr[i] > arr[i + 1])
				return false;
		return true;
	}

	
	/** predicate to check if arrayList is sorted.
	 *  Useful for checking ArrayList<Integer> lists returned
	 *  from Quick Sort.
	 * 
	 * @param arr the array to be checked
	 * @return true is the aray is sorted, flalse otherwise
	 */
	public static boolean isSorted(ArrayList<Integer> arr) {
		Iterator i = arr.iterator();
		int val;
		if (i.hasNext())
			val = (int) i.next();
		else
			return true;
		while (i.hasNext()) {
			int nv = (int) i.next();
			if (val > nv)
				return false;
			val = nv;
		}
		return true;
	}

	
	/** Helper printing methods for testing
	 * @param arr the array to print
	 */
	private static void printIntArray(int[] arr) {
		System.out.print("[ ");
		for (Integer i : arr) {
			System.out.print(i + " ");
		}
		System.out.println(" ]");
	}

	private static void printIntArrayList(ArrayList<Integer> arr) {
		System.out.print("[ ");
		for (Integer i : arr) {
			System.out.print(i + " ");
		}
		System.out.println(" ]");
	}

	public static void main(String[] args) {
		// testing part1
		int[] arr1 = { 5, 4, 3, 2, 1 };
		bubbleSort(arr1);
		printIntArray(arr1);

		// testing part2
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2.add(3);
		arr2.add(1);
		arr2.add(6);
		arr2.add(5);
		ArrayList<Integer> arr2_sorted = quickSort(arr2);
		printIntArrayList(arr2_sorted);
		// {5,4,3,5,1};

	}

}
