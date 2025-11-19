import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ArraySortTest {

	@Test
	public void testIsSortedEmpty() {
		int[] arr = {};
		assertTrue(ArraySort.isSorted(arr));
	}

	@Test
	public void testIsSortedTrue() {
		int[] arr = { 1, 2, 3, 67, 78 };
		assertTrue(ArraySort.isSorted(arr));
	}

	@Test
	public void testIsSortedFalse() {
		int[] arr = { 1, 2, 7, 5, 3 };
		assertFalse(ArraySort.isSorted(arr));
	}

	@Test
	public void testIsSortedArrayListEmpty() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		assertTrue(ArraySort.isSorted(arr));
	}

	@Test
	public void testIsSortedArrayListTrue() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(5);
		assertTrue(ArraySort.isSorted(arr));
	}

	@Test
	public void testIsSortedArrayListFalse() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(5);
		arr.add(4);
		assertFalse(ArraySort.isSorted(arr));
	}

	@Test
	public void testInsertionSortOrdered() {
		int[] arr = { 1, 2, 3, 4 };
		// step 1: sort the array with ArraySort.insertionSort(arr)
		ArraySort.insertionSort(arr);
		//Calls the insertionSort method in the ArraySort class and passes through an array which should be sorted using insertion sort.

		// step 2: check the length of the array
		assertEquals("The length of the array is 4", 4, arr.length);
		//The expected result is 4 and it checks for the length of the array arr.

		// step 2: check if the array is sorted
		assertTrue("The array is sorted", ArraySort.isSorted(arr));
		//The expected result is True and it checks if the array arr has been sorted by using the isSorted method.
	}

	@Test
	public void testInsertionSortRandom() {
		int[] arr = { 4, 2, 1, 8 };
		// step 1: sort the array with ArraySort.insertionSort(arr)
		ArraySort.insertionSort(arr);
		//Calls the insertionSort method in the ArraySort class and passes through an array which should be sorted using insertion sort.

		// step 2: check the length of the array
		assertEquals("The length of the array is 4", 4, arr.length);
		//The expected result is 4 and it checks for the length of the array arr.

		// step 2: check if the array is sorted
		assertTrue("The array is sorted", ArraySort.isSorted(arr));
		//The expected result is True and it checks if the array arr has been sorted by using the isSorted method.
	}

	@Test
	public void testBubbleSortEmpty() {
		int[] arr = {};
		ArraySort.bubbleSort(arr);
		assertTrue(arr.length == 0);
	}

	@Test
	public void testBubbleSortRandom() {
		int[] arr = { 5, 1, 4, 2, 8 };
		// step 1: sort the array with ArraySort.bubbleSort(arr)
		ArraySort.bubbleSort(arr);
		//Calls the bubbleSort method in the ArraySort class and passes through an array which should be sorted using bubble sort.

		// step 2: check the length of the array
		assertEquals("The length of the array is 5", 5, arr.length);
		//The expected result is 5 and it checks for the length of the array arr.

		assertTrue("The array is sorted", ArraySort.isSorted(arr));
		//The expected result is True and it checks if the array arr has been sorted by using the isSorted method.
	}

	@Test
	public void testBubbleSortOrdered() {
		int[] arr = { 1, 2, 3, 4 };
		// step 1: sort the array with ArraySort.bubbleSort(arr)
		ArraySort.bubbleSort(arr);
		//Calls the bubbleSort method in the ArraySort class and passes through an array which should be sorted using bubble sort.
		
		// step 2: check the length of the array
		assertEquals("The length of the array is 4", 4, arr.length);
		//The expected result is 4 and it checks for the length of the array arr.

		// step 2: check if the array is sorted
		assertTrue("The array is sorted", ArraySort.isSorted(arr));
		//The expected result is True and it checks if the array arr has been sorted by using the isSorted method.
	}

	@Test
	public void testQuickSortSorted() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		arr.add(5);
		ArrayList<Integer> arr_sorted = ArraySort.quickSort(arr);
		List<Integer> expectedList = Arrays.asList(1, 2, 3, 4, 5);
		assertEquals(expectedList, arr_sorted);
	}

	@Test
	public void testQuickSortRandom() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(5);
		arr.add(2);
		arr.add(9);
		arr.add(5);
		ArrayList<Integer> arr_sorted = ArraySort.quickSort(arr);
		List<Integer> expectedList = Arrays.asList(1, 2, 5, 5, 9);
		assertEquals(expectedList, arr_sorted);
	}

	@Test
	public void testQuickSortEmpty() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<Integer> arr_sorted = ArraySort.quickSort(arr);
		List<Integer> expectedList = Arrays.asList();
		assertEquals(expectedList, arr_sorted);
	}
}
