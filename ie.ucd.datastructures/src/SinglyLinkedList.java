import java.util.Iterator;

/**
 * A basic singly linked list implementation.
 */
public class SinglyLinkedList<E> implements Cloneable, Iterable<E>, List<E> {
    //---------------- nested Node class ----------------

    /**
     * Node of a singly linked list, which stores a reference to its
     * element and to the subsequent node in the list (or null if this
     * is the last node).
     */
    private static class Node<E> {
    	E element;
    	Node<E> next;
    	
    	public Node(E e, Node<E> n) {
    		element = e;
    		next = n;
    	}
    } //----------- end of nested Node class -----------

    // instance variables of the SinglyLinkedList
    private Node<E> head = null; // head node of the list (or null if empty)
    
    private Node<E> currNode = head; // current node of the list

    private int size = 0; // number of nodes in the list

    public SinglyLinkedList() {
    }              // constructs an initially empty list

    // access methods

    /**
     * Returns the number of elements in the linked list.
     *
     * @return number of elements in the linked list
     */
    public int size() {
        return size;
    }

    /**
     * Tests whether the linked list is empty.
     *
     * @return true if the linked list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
    	currNode = head;
    	for(int n=0;n<i;n++) {
    		currNode = currNode.next;
    	}
        return currNode.element;
    }

    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
    	currNode = head;
    	for(int n=0;n<i;n++) {
    		currNode = currNode.next;
    	}
    	currNode.element = e;
        return currNode.element;
    }

    @Override
    public void add(int n, E e) throws IndexOutOfBoundsException {
    	currNode = head;//initialise the current node as the head
    	//loop through the list until the node before the node to be added is reached
    	for(int i=0;i<n-1;i++) {
    		currNode = currNode.next;
    	}
    	//add the new node
    	Node<E> toAdd = new Node<E>(e,null);
    	//hold the current node in a temporary node
    	Node<E> temp = currNode;
    	currNode = currNode.next;
    	//set the previous node to point to the new node
    	temp.next = toAdd;
    	//point the new node to the next node in the list
    	toAdd.next = currNode;
    	size++;

    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
    	currNode = head;
    	
    	for(int n=0;n<i-1;n++) {
    		currNode = currNode.next;
    	}
    	currNode.next = currNode.next.next;
        size--;
    	return null;
    }

    /**
     * Returns (but does not remove) the first element of the list
     *
     * @return element at the front of the list (or null if empty)
     */
    public E first() {
    	if(size>0) {
    		return head.element;
    	}
    	else 
    		return null;
    }

    /**
     * Returns the last node of the list
     *
     * @return last node of the list (or null if empty)
     */
    public Node<E> getLast() {
        if(size>0) {
        	currNode = head;
        	while(currNode.next != null) {
        		currNode = currNode.next;     	
        	}
        	return currNode;
        }
        else
        	return null;
    }

    /**
     * Returns (but does not remove) the last element of the list.
     *
     * @return element at the end of the list (or null if empty)
     */
    public E last() {
        if(size>0) {
        	currNode = head;
        	while(currNode.next != null) {
        		currNode = currNode.next;      	
        	}
        	return currNode.element;
        }
        else
        	return null;
    }

    // update methods

    /**
     * Adds an element to the front of the list.
     *
     * @param e the new element to add
     */
    public void addFirst(E e) {
    	head = new Node<E>(e, head);
    	size++;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param e the new element to add
     */
    public void addLast(E e) {
    	
    	Node<E> NewLast = new Node<E>(e,null);
    	
    	if(size > 0) {
    		currNode = head;
        	while(currNode.next != null) {
        		currNode = currNode.next;        		      	
        	}
    		currNode.next = NewLast;
    		size++;
    	}
    	else {
    		head = NewLast;
    		size++;
    	}
    		

    }

    /**
     * Removes and returns the first element of the list.
     *
     * @return the removed element (or null if empty)
     */
    public E removeFirst() {
    	
        if(size > 0) {
        	size--;
        	currNode = head;
        	head = head.next;
        	return currNode.element;
        }
        else
        	return null;
    }
    
    /**
     * Removes and returns the last element of the list.
     *
     * @return the removed element (or null if empty)
     */
    
    public E removeLast() {
    	
        if(size > 0) {
        	currNode = head;
        	while(currNode.next.next != null) {
        		currNode = currNode.next;
        	}
        	E temp = currNode.next.element;
        	currNode.next = null;
        	size--;
        	return temp;
        }
        else
        	return null;
    }
    
    //Function to reverse the linked list
    public void reverse() {
    	//stores the previous current and next nodes
    	Node<E> prev = null;
        Node<E> current = head;
        Node<E> next = null;
        
        //loop through the linked list and rearrange the nodes in reverse order
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        //set the head back to the start of the list
        head = prev;
    }
    
    public SinglyLinkedList<E> recursiveCopy(){
    	return recursiveCopy(head,new SinglyLinkedList<E>());
    }
    
    private SinglyLinkedList<E> recursiveCopy(Node<E> node, SinglyLinkedList<E> list) {
    	//check if the current node is null, if so the list has been iterated through
    	if(node == null) {
    		return list;
    	}
    	//add the next element in the original list to the copy
    	list.addLast(node.element);
    	//recursively call the copy for the next node
    	return recursiveCopy(node.next, list);
    	
    }

    @SuppressWarnings({"unchecked"})
    public boolean equals(Object o) {
    	if(o.toString() == toString()) {
    		return true;
    	}
        return false;   // if we reach this, everything matched successfully
    }

    @SuppressWarnings({"unchecked"})
    public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
    	//create the clone list
    	SinglyLinkedList clone = new SinglyLinkedList();
    	//add the head of the list to be cloned
    	clone.addFirst(head.element);
    	
    	//set a pointer to the current node
    	currNode = head.next;
    	//add the needed nodes while there are nodes to add
    	while(currNode != null) {
    		clone.addLast(currNode.element);
    		currNode = currNode.next;
    	}
    	
    	//return the final cloned list
    	return clone;
    }


    /**
     * Produces a string representation of the contents of the list.
     * This exists for debugging purposes only.
     */
    public String toString() {
    	if (head == null) {
    		return "";
    	}
    	String List = "[";
    	currNode = head;
    	List += currNode.element;
    	List += ", ";
    	while (currNode.next != null) {
    		currNode = currNode.next;
   			List += currNode.element;
   			if(currNode.next != null) {
   				List += ", ";
   			}
   			else
   				List += "";
   		}
    	List +="]";
   		return List;
   	}
        

    private class SinglyLinkedListIterator<E> implements Iterator<E> {
     	Node<E> curr = (Node<E>) head;
        int i = 0;
        @Override
        public boolean hasNext() {
        	return curr != null;
        }

        @Override
        public E next() {
        	E ret = (E) curr.element;
            curr = curr.next;
            return ret;
        }
    }

    public Iterator<E> iterator() {
        return new SinglyLinkedListIterator<E>();
    }

    public static void main(String[] args) {
        
    	SinglyLinkedList<Integer> ll = new SinglyLinkedList<Integer>();
    	ll.addFirst(0);
    	ll.addFirst(1);
    	ll.addFirst(3);
    	ll.addFirst(4);
    	ll.addFirst(5);
    	ll.add(3,2);
    	System.out.println(ll);
    	
    	ll.addFirst(-100);
    	ll.addLast(+100);
    	System.out.println(ll);
    	
    	ll.removeFirst();
    	ll.removeLast();
    	System.out.println(ll);
    	
    	ll.remove(2);
    	System.out.println(ll);
    	
    	ll.removeFirst();
    	System.out.println(ll);
    	
    	ll.removeLast();
    	System.out.println(ll);
    	
    	ll.removeFirst();
    	System.out.println(ll);
    	
    	ll.addFirst(9999);
    	ll.addFirst(8888);
    	ll.addFirst(7777);
    	System.out.println(ll);	
    	System.out.println(ll.get(0));
    	System.out.println(ll.get(1));
    	System.out.println(ll.get(2));
    	System.out.println(ll);
    	
    	SinglyLinkedList<String> sll = new SinglyLinkedList<String>();

        String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

        for (String s : alphabet) {
            sll.addFirst(s);
            sll.addLast(s);
        }
        System.out.println(sll.toString());

        for (String s : sll) {
            System.out.print(s + ", ");
        }
    }
}

