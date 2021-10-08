/*
 */

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * An implementation of a priority queue using an array-based heap.
 */

public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {

	protected ArrayList<Entry<K, V>> heap = new ArrayList<>();
	/**
	 * Creates an empty priority queue based on the natural ordering of its keys.
	 */
	public HeapPriorityQueue() {
		super();
	}

	/**
	 * Creates an empty priority queue using the given comparator to order keys.
	 * 
	 * @param comp comparator defining the order of keys in the priority queue
	 */
	public HeapPriorityQueue(Comparator<K> comp) {
		super(comp);
	}

	/**
	 * Creates a priority queue initialized with the respective key-value pairs. The
	 * two arrays given will be paired element-by-element. They are presumed to have
	 * the same length. (If not, entries will be created only up to the length of
	 * the shorter of the arrays)
	 * 
	 * @param keys   an array of the initial keys for the priority queue
	 * @param values an array of the initial values for the priority queue
	 */
	public HeapPriorityQueue(K[] keys, V[] values) {
		for(int i=0; i<keys.length && i<values.length;i++) {
			PQEntry<K,V> entry = new PQEntry<K,V>(keys[i],values[i]);
			heap.set(i, entry);
		}
	}

	// protected utilities
	protected int parent(int j) {
		if(j>0 && j<heap.size())
			return (j-1)/2;
		else
			return 0;
	}

	protected int left(int j) {
		return 2*j+1;
	}

	protected int right(int j) {
		return 2*j+2;
	}

	protected boolean hasLeft(int j) {
		if((2*j+1) < heap.size()) {
			return true;
		}
		return false;
	}

	protected boolean hasRight(int j) {
		if((2*j+2) < heap.size()) {
			return true;
		}
		return false;
	}

	/** Exchanges the entries at indices i and j of the array list. */
	protected void swap(int i, int j) {
		Entry<K, V> temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);
		return;
	}

	/**
	 * Moves the entry at index j higher, if necessary, to restore the heap
	 * property.
	 */
	protected void upheap(int j) {
		//check if the parent of j is greater than j
		if(j > 0 && compare(heap.get(parent(j)) , heap.get(j)) == 1) {
			// Swap parent and current node
			swap(parent(j), j);

			// Update i to parent of i
			j = parent(j);
			upheap(j);//recursive call to the rest of the tree
		}
	}

	/**
	 * Moves the entry at index j lower, if necessary, to restore the heap property.
	 */
	protected void downheap(int j) {
		//check if the entry at index j is valid
		if(j < heap.size()){
			//variables for the parent, left, and right nodes
		    int p = j;
		    int l = left(p);
		    int r = right(p);
		    int size = heap.size();
		    //check if the right child needs to be swapped
		    if(r<size && compare(heap.get(r), heap.get(p))==-1 && compare(heap.get(r), heap.get(l))==-1){
		        swap(r,p);
		        downheap(r);//recursive call
		    }//check if the left child needs to be swapped otherwise
		    else if(l<size && compare(heap.get(l), heap.get(p))==-1){
		        swap(l,p);
		        downheap(l);//recursive call
		    }
		}

	}

	/** Performs a bottom-up construction of the heap in linear time. */
	protected void heapify() {
		// TODO
		//current placeholder creates heap
		for(int i=0; i<heap.size();i++) {
			upheap(i);
		}
	}

	// public methods

	/**
	 * Returns the number of items in the priority queue.
	 * 
	 * @return number of items
	 */
	@Override
	public int size() {
		return heap.size();
	}

	/**
	 * Returns (but does not remove) an entry with minimal key.
	 * 
	 * @return entry having a minimal key (or null if empty)
	 */
	@Override
	public Entry<K, V> min() {
		return heap.get(0);
	}

	/**
	 * Inserts a key-value pair and return the entry created.
	 * 
	 * @param key   the key of the new entry
	 * @param value the associated value of the new entry
	 * @return the entry storing the new key-value pair
	 * @throws IllegalArgumentException if the key is unacceptable for this queue
	 */
	@Override
	public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
		// TODO
		PQEntry<K,V> toAdd = new PQEntry<K,V>(key, value);
		heap.add(toAdd);
		upheap(heap.size()-1);
		return toAdd;
	}

	/**
	 * Removes and returns an entry with minimal key.
	 * 
	 * @return the removed entry (or null if empty)
	 */
	@Override
	public Entry<K, V> removeMin() {
		Entry<K,V> min = min();
		heap.remove(0);
		heapify();
		return min;
	}
	
	public String toString() {
		return heap.toString();
	}

	/** Used for debugging purposes only */
	private void sanityCheck() {
		for (int j = 0; j < heap.size(); j++) {
			int left = left(j);
			int right = right(j);
			System.out.println("-> " +left + ", " + j + ", " + right);
			Entry<K, V> e_left, e_right;
			e_left = left < heap.size() ? heap.get(left) : null;
			e_right = right < heap.size() ? heap.get(right) : null;
			if (left < heap.size() && compare(heap.get(left), heap.get(j)) < 0) {
				System.out.println("Invalid left child relationship");
				System.out.println("=> " + e_left + ", " + heap.get(j) + ", " + e_right);
			}
			if (right < heap.size() && compare(heap.get(right), heap.get(j)) < 0) {
				System.out.println("Invalid right child relationship");
				System.out.println("=> " + e_left + ", " + heap.get(j) + ", " + e_right);
			}
		}
	}

	public static < T > String toBinaryTreeString(PriorityQueue<T> pq) {
		LinkedBinaryTree<T> bt = new LinkedBinaryTree<>();
//		bt.createLevelOrder(new ArrayList<T>(pq));
//		BinaryTreePrinter< T > btp = new BinaryTreePrinter<>(bt);
//		return btp.print();
		return null;
	}

	public static void main(String[] args) {
		
		Integer[] arr = new Integer[] {35,26,15,24,33,4,12,1,23,21,2,5};
		HeapPriorityQueue<Integer, String> pq = new HeapPriorityQueue<>();

		for(Integer i : arr) pq.insert(i, Integer.toString(i));
		
		pq.sanityCheck();
		System.out.println(pq.toString());
		
		pq.downheap(0);
		System.out.println(pq.toString());

	}
	
	public static void main_jdk(String [] args) {
		//HeapPriorityQueue<Integer, Integer> pq = new HeapPriorityQueue<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>(new MaxComparator());
		//Integer [] rands = new Integer[]{44,17,88,8,32,65,97,28,54,82,93,21,29,76,68,80};
		Integer[] rands = new Integer[] {35,26,15,24,33,4,12,1,23,21,2,5};
		
		for(Integer i : rands) {
			pq.add(i);
			System.out.println(toBinaryTreeString(pq));
		}
		
		pq.add(34);
		System.out.println(toBinaryTreeString(pq));
	}

	
}
