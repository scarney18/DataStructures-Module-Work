public class LinkedQueue<E> implements Queue<E> {
	
	private int size;
	private Node first;
	private Node last;
	private Node curr;
	
	private class Node {
		private E element;
		private Node next;
	}

	public LinkedQueue() {
		first = null;
		last = null;
		size = 0;
	}

	public static void main(String[] args) {
		LinkedQueue test = new LinkedQueue();
		test.enqueue(1);
		test.enqueue(2);
		test.enqueue(3);
		
		System.out.println(test.toString());
		System.out.println(test.first());
		System.out.println(test.dequeue());
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
	public void enqueue(E e) {
		Node newNode = new Node();
		newNode.element = e;
		newNode.next = null;
		
		if(size == 0) {
			first = newNode;
		}
		else
			last.next = newNode;
		
		last = newNode;
		size++;
	}

	@Override
	public E first() {
		return first.element;
	}

	@Override
	public E dequeue() {
		E removed = first.element;
		
		first = first.next;
		if(first == null) {
			last = null;
		}
		size--;
		return removed;
	}
	
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
