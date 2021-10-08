
public class LinkedDeque<E> implements Deque<E> {
	
	private int size;
	private Node first;
	private Node last;
	private Node curr;
	
	//node class for LinkedDeque
	private class Node {
		private E element;
		private Node next;
	}
	
	//constructor
	public LinkedDeque() {
		first = last = null;
		size = 0;
	}
	
	//main used for testing
	public static void main(String[] args) {
		LinkedDeque test = new LinkedDeque();
		test.addFirst(1);
		test.addLast(2);
		test.addLast(3);
		
		System.out.println(test.toString());
		System.out.println(test.first());
		System.out.println(test.last());
		System.out.println(test.removeLast());
		System.out.println(test.toString());

	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (size==0);
	}

	@Override
	public E first() {
		return first.element;
	}

	@Override
	public E last() {
		return last.element;
	}

	@Override
	public void addFirst(E e) {
		//create the newNode and place it at the start of the list
		Node newNode = new Node();
		newNode.element = e;
		newNode.next = first;
		first = newNode;
		//if the list is empty the last and first node will be equal
		if(isEmpty())
			last = first;
		size++;
		
	}

	@Override
	public void addLast(E e) {
		//if the list is empty add last and add first are equivalent
		if(isEmpty()) {
			addFirst(e);
			return;
		}
		//insert newNode to the last node in the list
		Node newNode = new Node();
		newNode.element = e;
		newNode.next = null;
		last.next = newNode;
		last = newNode;
		size++;
		
	}

	@Override
	public E removeFirst() {
		//save the removed element
		E removed = first.element;
		
		//make the current first node equal the next in the list, effectively removing it
		first = first.next;
		if(first == null) {//when the list is empty after this, last and first will be null
			last = null;
		}
		size--;
		//return removed element
		return removed;
	}

	@Override
	public E removeLast() {
		//save the removed element
		E removed = last.element;
		//use pointer node to cycle through the list
		curr = first;
		while(curr != null) {
			if(last.equals(curr.next)) {
				//when the 2nd last node is found replace the last node with it
				curr.next = null;
				last = curr;
				break;
			}
			curr = curr.next;
		}
		size--;
		return removed;
	}

	//toString method for testing
	public String toString() {
		String result = "";
		curr = first;
		
		while(curr != null) {
			result += curr.element;
			curr = curr.next;
		}
		
		return result;
	}
}
