public class ArrayQueue<E> implements Queue<E> {
	
	private int rear;
	private int size = 0;
	private E[] queue;
	
	public ArrayQueue(int cap) {
		rear = 0;
		queue = (E[])(new Object[cap]);
	}
	
	public ArrayQueue() {
		rear = 0;
		queue = (E[])(new Object[10]);
	}

	//main used to test some functions
	public static void main(String[] args) {
		ArrayQueue test = new ArrayQueue(10);
		test.enqueue(1);
		test.enqueue(2);
		test.enqueue(3);
		
		System.out.println(test.toString());
		System.out.println(test.first());
		System.out.println(test.dequeue());
		System.out.println(test.first());
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
		//add the element to the rear of the list and increment rear and size after
		queue[rear++] = e;
		size++;
	}

	@Override
	public E first() {
		return queue[0];
	}

	@Override
	public E dequeue() {
		//save the first element which is to be removed
		E first = queue[0];
		
		//loop through the queue and move each element back one place
		for(int i=0; i<rear; i++) {
			queue[i]=queue[i+1];
		}
		//decrement rear and size and return the removed element
		rear--;
		size--;
		return first;
	}
	
	//toString class used for testing
	public String toString()
	   {
	      String result = "";

	      for (int i=0; i<rear; i++) 
	         result = result + queue[i].toString();

	      return result;
	   }

}
