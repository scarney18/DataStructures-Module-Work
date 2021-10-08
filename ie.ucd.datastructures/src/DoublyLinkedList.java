import java.util.Iterator;

public class DoublyLinkedList<E> implements List<E> {

    //---------------- nested Node class ----------------
    /**
     * Node of a doubly linked list, which stores a reference to its
     * element and to both the previous and next node in the list.
     */
    private static class Node<E> {
        
    	E element;
    	Node<E> next;
    	Node<E> previous;
    	
    	public Node(E e,Node<E> n,Node<E> p){
    		element = e;
    		next = n;
    		previous = p;
    	}
    	
    } //----------- end of nested Node class -----------

    // instance variables of the DoublyLinkedList
    /** Sentinel node at the beginning of the list */
    private Node<E> header = null;                    // header sentinel

    /** Sentinel node at the end of the list */
    private Node<E> trailer;                   // trailer sentinel
    
    private Node<E> currNode = header;	//current node of the list

    /** Number of elements in the list (not including sentinels) */
    private int size = 0;                      // number of elements in the list

    /** Constructs a new empty list. */
    public DoublyLinkedList() {
    }

    // public accessor methods
    /**
     * Returns the number of elements in the linked list.
     * @return number of elements in the linked list
     */
    public int size() { return size; }

    /**
     * Tests whether the linked list is empty.
     * @return true if the linked list is empty, false otherwise
     */
    public boolean isEmpty() { return size == 0; }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
    	currNode = header;
    	for(int n=0;n<i;n++) {
    		currNode = currNode.next;
    	}
        return currNode.element;
    }

    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
    	currNode = header;
    	for(int n=0;n<i;n++) {
    		currNode = currNode.next;
    	}
    	currNode.element = e;
        return currNode.element;
    }

    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {
    	currNode = header;//initialise the current node as the head
    	//loop through the list until the node before the node to be added is reached
    	for(int n=0;n<i-1;n++) {
    		currNode = currNode.next;
    	}
    	//add the new node
    	Node<E> toAdd = new Node<E>(e,null,null);
    	//hold the current node in a temporary node
    	Node<E> temp = currNode;
    	currNode = currNode.next;
    	//set the previous node to point to the new node
    	temp.next = toAdd;
    	//the new node points to the now previous node
    	toAdd.previous = temp;
    	//point the new node to the next node in the list
    	toAdd.next = currNode;
    	//the next node points to the added node
    	currNode.previous = toAdd;
    	size++;
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
    	currNode = header;
    	
    	for(int n=0;n<i-1;n++) {
    		currNode = currNode.next;
    	}
    	currNode.next = currNode.next.next;
        size--;
    	return null;
    }

    @Override
    public Iterator<E> iterator() {
    	return new DoublyLinkedListIterator<E>();
    }
    
    private class DoublyLinkedListIterator<E> implements Iterator<E> {
   	Node<E> curr = (Node<E>) header;
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

    /**
     * Returns (but does not remove) the first element of the list.
     * @return element at the front of the list (or null if empty)
     */
    public E first() {
    	if(size>0) {
    		return header.element;
    	}
    	return null;
    }

    /**
     * Returns (but does not remove) the last element of the list.
     * @return element at the end of the list (or null if empty)
     */
    public E last() {
    	if(size>0) {
        	currNode = header;
        	while(currNode.next != null) {
        		currNode = currNode.next;      	
        	}
        	return currNode.element;
        }
        else
        	return null;
    }

    // public update methods
    /**
     * Adds an element to the front of the list.
     * @param e   the new element to add
     */
    public void addFirst(E e) {
    	header = new Node<E>(e, header,null);
    	size++;
    }

    /**
     * Adds an element to the end of the list.
     * @param e   the new element to add
     */
    public void addLast(E e) {
    	Node<E> NewLast = new Node<E>(e,null,null);
    	
    	if(size > 0) {
    		currNode = header;
        	while(currNode.next != null) {
        		currNode = currNode.next;        		      	
        	}
    		currNode.next = NewLast;
    		NewLast.previous = currNode;
    		size++;
    	}
    	else {
    		header = NewLast;
    		size++;
    	}
    }

    /**
     * Removes and returns the first element of the list.
     * @return the removed element (or null if empty)
     */
    public E removeFirst() {
    	 if(size > 0) {
    		size--;
         	currNode = header;
         	header = header.next;
         	return currNode.element;
         }
         else
         	return null;
    }

    /**
     * Removes and returns the last element of the list.
     * @return the removed element (or null if empty)
     */
    public E removeLast() {
    	if(size > 0) {
        	currNode = header;
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

    // private update methods
    /**
     * Adds an element to the linked list in between the given nodes.
     * The given predecessor and successor should be neighboring each
     * other prior to the call.
     *
     * @param predecessor   node just before the location where the new element is inserted
     * @param successor     node just after the location where the new element is inserted
     */
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
    	
        Node<E> ToAdd = new Node<E>(e,successor,predecessor);
        size++;
        
    }

    /**
     * Removes the given node from the list and returns its element.
     * @param node    the node to be removed (must not be a sentinel)
     */
    private E remove(Node<E> node) {
    	node.next.previous = null;
    	node.previous.next = null;
    	node.next = null;
    	node.previous = null;
        size--;
    	return node.element;
    }


    /**
     * Produces a string representation of the contents of the list.
     * This exists for debugging purposes only.
     */
    
    public String toString() {
    	if (header == null) {
    		return "";
    	}
    	String List = "[";
    	currNode = header;
    	List += currNode.element;
    	List += ", ";
    	while (currNode.next != null) {
    		
    		currNode = currNode.next;
   			List += currNode.element;
   			if(currNode.next==null) {
   				List+="]";
   			}
   			else {
   				List += ", ";
   			}
   		}
   		return List;
    }

    public static void main(String [] args) {
        //ArrayList<String> all;
        //LinkedList<String> ll;
    	
    	DoublyLinkedList<Integer> ll = new DoublyLinkedList<Integer>();
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
    	
        DoublyLinkedList<String> dll = new DoublyLinkedList<String>();

        String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

        for (String s : alphabet) {
            dll.addFirst(s);
            dll.addLast(s);
        }
        System.out.println(dll.toString());	
    }
} //----------- end of DoublyLinkedList class -----------
