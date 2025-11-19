import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DLinkedListTest {

	DLinkedList dl;
	
	@Before
	public void setup(){
		dl = new DLinkedList();
	}
	
	@Test
	public void testIsSortedEmpty() {
		assertTrue(dl.isSorted());
	}

	@Test
	public void testIsSortedTrue() {
		dl.addAtTail(1);
		dl.addAtTail(2);
		dl.addAtTail(3);
		dl.addAtTail(5);
		assertTrue(dl.isSorted());
	}
	
	@Test
	public void testIsSortedFalse() {
		dl.addAtTail(1);
		dl.addAtTail(2);
		dl.addAtTail(5);
		dl.addAtTail(4);
		assertFalse(dl.isSorted());
	}
	
	@Test
	public void testSizeEmpty() {
		assertEquals(0,dl.size());
	}

	@Test
	public void testSizeOne() {
		dl.addAtTail(1);
		assertEquals(1,dl.size());
	}
	
	@Test
	public void testSizeThree() {
		dl.addAtTail(1);
		dl.addAtTail(2);
		dl.addAtTail(5);
		assertEquals(3,dl.size());
	}
	
	@Test
	public void testInsertionSortEmpty() {
		// don't add any values to the linked list dl
		
		// now call the insertionSort() method on dl
		dl.insertionSort();
		
		// test the size of the empty linked list
		assertEquals("The size of the empty linked list is 0", 0, dl.size());
		//Expected 0 and checks for the size of the linked list dl.
		
		// test that the list is sorted
		assertTrue("The empty list is sorted", dl.isSorted());
		//The expected result is true and it checks for the boolean result from the method isSorted in DLinkedList for the linked list dl.
	}
	
	@Test
	public void testInsertionSortOrdered() {
		// add some numbers to the head and tail of
		// the list dl, such that the list is ordered
		dl.addAtHead(2);
		//Adds the number 2 to the head of the list dl.
		dl.addAtHead(1);
		//Adds the number 1 to the head of the list dl.
		dl.addAtTail(3);
		//Adds the number 3 to the tail of the list dl.
		
		// now call the insertionSort() method on dl
		dl.insertionSort();
				
		// test the size of the linked list
		assertEquals("The size of the linked list is 3", 3, dl.size());
		//Expected 3 and checks for the size of the linked list dl.
				
		// test that the list is sorted
		assertTrue("The list is sorted", dl.isSorted());
		//The expected result is true and it checks for the boolean result from the method isSorted in DLinkedList for the linked list dl.
	}
	
	@Test
	public void testInsertionSortRandom() {
		// add some numbers to the head and tail of
		// the list dl, such that the list is unordered
		dl.addAtHead(1);
		//Adds the number 1 to the head of the list dl.
		dl.addAtHead(5);
		//Adds the number 5 to the head of the list dl.
		dl.addAtTail(3);
		//Adds the number 3 to the tail of the list dl.
		System.out.println(dl);
		// now call the insertionSort() method on dl
					
		// test the size of the linked list
		dl.insertionSort();
		
		// test that the list is sorted
		assertTrue("The list is sorted", dl.isSorted());
		//The expected result is true and it checks for the boolean result from the method isSorted in DLinkedList for the linked list dl.
	}
	
}
