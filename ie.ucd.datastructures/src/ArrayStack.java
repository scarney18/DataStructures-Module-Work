
public class ArrayStack<E> implements Stack<E> {
	
	public static final int CAPACITY = 1000;
	
	private int N = CAPACITY;
	
	private E[] data;
	
	private int t = -1;
	
	public ArrayStack(int cap) {
		N = cap;
		data = (E[]) new Object[cap];
	}
	
	public ArrayStack() {
		this(CAPACITY);
	}
	
	public static void main(String[] args) {
		ArrayStack<Integer> test = new ArrayStack<Integer>(5);
		System.out.println(test.size() + " " +test.isEmpty());
		test.push(1);
		test.push(2);
		test.push(3);
		test.push(4);
		System.out.println(test.size() + " " +test.isEmpty());
		System.out.println(test.toString());
		System.out.println(test.top());
		System.out.println(test.size());
		test.pop();
		System.out.println(test.toString());
		System.out.println(test.top());
		System.out.println(test.size());
		test.push(4);
		test.push(5);
		test.push(6);
		System.out.println(test.toString());
		System.out.println(test.top());
		System.out.println(test.size());
		
	}

	@Override
	public int size() {
		return t+1;
	}

	@Override
	public boolean isEmpty() {
		return (t==-1);
	}

	@Override
	public void push(E e) {
		if(t >= N-1) {
			increaseArray();
		}
		t++;
		this.data[t] = e;
	}

	@Override
	public E top() {
		if(t != -1) {
			return this.data[t];
		}
		else
			return null;
	}

	@Override
	public E pop() {
		if(t != -1) {
			return (this.data[t--]);
		}
		else
			return null;
	}
	
	private void increaseArray() {
        Object[] newArray;

        newArray = (E[]) new Object[N * 2];
        for (int i = 0; i < N; i++) {
            newArray[i] = this.data[i];
        }
        this.data = (E[]) newArray;
    }

	public String toString() {
		String stack = "[";
		for(int i=0; i<t; i++) {
			stack += this.data[i] +", ";
		}
		stack += this.data[t] + "]"; 
		return stack;
	}
}
