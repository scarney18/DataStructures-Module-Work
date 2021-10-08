public class LinkedStack<E> implements Stack<E> {
	
	private Node t = null;
	
	public LinkedStack() {
	}
	
	public class Node {
		 
        public Object element;
        public Node next;
 
        public Node(Object Element) {
            this(Element, null);
        }
 
        public Node(Object Element, Node n) {
            element = Element;
            next = n;
        }
    }
 
	public static void main(String[] args) {
		LinkedStack<Integer> test = new LinkedStack<Integer>();
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

	}

	@Override
	public int size() {
		int i=0;
		Node temp = t;
		while(temp != null) {
			i++;
			temp = temp.next;
		}
		return i;
	}

	@Override
	public boolean isEmpty() {
		return (t == null);
	}

	@Override
	public void push(E e) {
		t = new Node(e, t);
	}

	@Override
	public E top() {
		if(isEmpty()) {
			return null;
		}
		return (E) t.element;
	}

	@Override
	public E pop() {
		if(isEmpty()) {
			return null;
		}
		Object temp = t.element;
        t = t.next;
        return (E) temp;
	}
	
	public String toString() {
		String stack = "[";
		Node temp = t;
		while(temp != null) {
			if(temp.next==null) {
				stack += temp.element +"]";
			}
			else {
				stack += temp.element +", ";
			}
			temp = temp.next;
		}
		return stack;
	}
}
