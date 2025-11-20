import java.util.ArrayList;

public class DLinkedList {

	private class Node {
		private int value;
		private Node nextNode;
		private Node prevNode;

		public Node(int v) {
			value = v;
			nextNode = null;
			prevNode = null;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int v) {
			value = v;
		}

		public Node getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node n) {
			nextNode = n;
		}

		public Node getPrevNode() {
			return prevNode;
		}

		public void setPrevNode(Node n) {
			prevNode = n;
		}

	}

	// Holds a reference to the head and tail of the list
	private Node headNode;
	private Node tailNode;

	public DLinkedList() {
		headNode = null;
		tailNode = null;
	}

	public Object getHeadValue() {
		if (headNode == null)
			return null;
		return headNode.value;
	}

	public Object getTailValue() {
		if (tailNode == null)
			return null;
		return tailNode.value;
	}

	public void addAtHead(int o) {
		Node newNode = new Node(o);
		newNode.setNextNode(headNode);
		if (headNode != null)
			headNode.setPrevNode(newNode);
		headNode = newNode;
		// special case for empty list
		if (tailNode == null)
			tailNode = newNode;
	}

	public void addAtTail(int o) {
		Node newNode = new Node(o);
		// this means that headNode == null too!
		if (tailNode == null) {
			tailNode = newNode;
			headNode = newNode;
		} else {
			newNode.setPrevNode(tailNode);
			tailNode.setNextNode(newNode);
			tailNode = newNode;
		}
	}

	public int deleteAtHead() {
		// list is empty
		if (headNode == null) {
			headNode = null;
			tailNode = null;
			return -1;
		}
		// singleton: must update tailnode too
		if (headNode == tailNode) {
			int res = headNode.getValue();
			headNode = null;
			tailNode = null;
			return res;
		}

		int res = headNode.getValue();
		headNode = headNode.getNextNode();
		headNode.setPrevNode(null);
		return res;
	}

	public int deleteAtTail() {
		// list is empty
		if (tailNode == null) {
			headNode = null;
			tailNode = null;
			return -1;
		}
		// singleton: must update tailnode too
		if (headNode == tailNode) {
			int res = tailNode.getValue();
			headNode = null;
			tailNode = null;
			return res;
		}
		int res = tailNode.getValue();
		tailNode = tailNode.getPrevNode();
		tailNode.setNextNode(null);
		return res;
	}

	public int delete(Node n) {
		if (n == null)
			return -1;
		Node next = n.getNextNode();
		Node prev = n.getPrevNode();
		int val = n.getValue();
		if (prev != null)
			prev.setNextNode(next);
		if (next != null)
			next.setPrevNode(prev);
		// deleting at the end
		if (n == tailNode)
			tailNode = prev;
		// deleteing at beginning
		if (n == headNode)
			headNode = next;
		return val;
	}

	public void insertAfter(Node n, int val) {
		if (n == null) { // this is the headNode
			addAtHead(val);
			return;
		}
		Node next = n.getNextNode();
		Node newNode = new Node(val);
		newNode.setPrevNode(n);
		newNode.setNextNode(next);
		n.setNextNode(newNode);
		if (next == null) { // insert at tail
			tailNode = newNode;
		} else {
			next.setPrevNode(newNode);
		}
	}

	// computes the size of the list
	public int size() {
		if (headNode == null)
			return 0;
		Node n = headNode;
		int size = 0;
		while (n != null) {
			size++;
			n = n.getNextNode();
		}
		return size;
	}

	// Predicate to check if the linked list is sorted
	public boolean isSorted() {
		if (headNode == null || headNode.nextNode == null)
			return true;
		Node i = headNode.nextNode;
		while (i != null) {
			if (i.getValue() < i.getPrevNode().getValue())
				return false;
			i = i.nextNode;
		}
		return true;
	}

	// toString methods to override printing of object
	public String toString() {
		Node n = headNode;
		StringBuffer buf = new StringBuffer();
		while (n != null) {
			buf.append(n.getValue());
			buf.append(" ");
			n = n.getNextNode();
		}
		return buf.toString();
	}

	/**
	 * Sorted the doubly linked list using the insertion-sort algorithm.
	 * 
	 * This is Question 5
	 * 
	 * Look at how insertionSort in ArraySort.java does insertion sort on arrays.
	 * The task is to perform the same algorithm, but sorting nodes linked together
	 * in a doubly linked list.
	 * 
	 * Where N is the number of elements in the list the complexity is:
	 *
	 * O(n^2)
	 * 
	 * Because: Similar to the bubble sort; there are two loops being used, there is a chance that the first and second loop can loop for n amount of times. The more values in the list
	 * the longer it will take the code to compile.
	 */
	public void insertionSort() {

		if (headNode == null || headNode.nextNode == null) {
		//If statement which makes sure the list is not empty or only 1 value.
			return;
			//If the condition is met then nothing is returned.
		}
		
		Node currentNode = headNode.nextNode;
		//Declares a new node which will represent the current node (will begin as the second node).
		
		while (currentNode != null) {
		//A while loop which will continue to loop whilst the current node is not null/continue to loop until the end of the list.
			Node next = currentNode.nextNode;
			//Declares a new node next which represents the next node from the current node.
			Node previous = currentNode.prevNode;
			//Declares a new node previous which represents the previous node from the current ndoe.
			int value = currentNode.getValue();
			//Declares a int variable value which will store the value of the current node.
			
			if (previous.getValue() <= value) {
			//If statement which checks of the previous nodes value is smaller or equal to the current nodes value/checks if the value does not need swapped.
				currentNode = next;
				//If the condition is met then the current node will be set to the next node on the list.
			} else {
				
				delete(currentNode);
				//Will delete the current node;
				
				while (previous != null && previous.getValue() > value) {
				//A while loop which will continue to loop until the point of insertion is found.
					previous = previous.prevNode;
					//Sets the previous variable to the node before itself.
				}
				
				if (previous == null) {
				//If statement which checks if the value should be inserted at the head.
					insertAfter(null, value);
					//If the condition is met then insert the value at the head.
				} else {
					insertAfter(previous, value);
					//If the condition is not met then insert the value after the previous node.
				}
				
				currentNode = next;
				//Set the current node to the next node.
				
			}
			
			
		}
		
		
	}

	public static void main(String[] args) {
		DLinkedList d = new DLinkedList();
		d.addAtHead(4);
		d.addAtHead(1);
		d.addAtHead(7);
		d.addAtHead(10);
		System.out.println("Before sorting: " + d); // this will call the toString method
		d.insertionSort();
		System.out.println("After sorting: " + d);
	}

}
