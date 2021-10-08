
public class ArrayDeque<E> implements Deque<E> {

	private int size;
	private int rear;
	private E[] Deque;
	
	public ArrayDeque() {
		Deque = (E[])(new Object[10]);
		rear = 0;
		size = 0;
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
		return Deque[0];
	}

	@Override
	public E last() {
		return Deque[size-1];
	}

	@Override
	public void addFirst(E e) {
		for(int i=0; i<size; i++) {
			Deque[i+1] = Deque[i];
		}
		Deque[0] = e;
		rear++;
		size++;
	}

	@Override
	public void addLast(E e) {
		Deque[size] = e;
		size++;
		rear++;
		
	}

	@Override
	public E removeFirst() {
		E removed = Deque[0];
		for(int i=0; i<size; i++) {
			Deque[i] = Deque[i+1];
		}
		return removed;
	}

	@Override
	public E removeLast() {
		E removed = Deque[rear--];
		size--;
		
		return removed;
	}

}
