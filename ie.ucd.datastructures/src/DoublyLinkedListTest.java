import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DoublyLinkedListTest {

	@Test
	void testSize() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		assertEquals(0, ll.size());
		ll.addFirst(0);
		assertEquals(1, ll.size());
	}

	@Test
	void testIsEmpty() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		assertEquals(true, ll.isEmpty());
		ll.addFirst(0);
		assertEquals(false, ll.isEmpty());
		ll.removeFirst();
		assertEquals(true, ll.isEmpty());
	}

	@Test
	void testFirst() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		ll.addFirst(-1);
		assertEquals(-1, ll.first());
		
		ll.removeFirst();
		assertEquals(null, ll.first());
		
		
	}

	@Test
	void testLast() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		ll.addFirst(-1);

		assertEquals(-1, ll.last());

		ll.addFirst(-2);
		assertEquals(-1, ll.last());
		
		ll.addLast(-3);
		assertEquals(-3, ll.last());
	}


	@Test
	void testRemoveLast() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		ll.addFirst(-1);
		ll.addFirst(-2);
		assertEquals(-1, ll.removeLast());
	}

	@Test
	void testGet() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		for(int i = 0; i < 5; ++i) ll.addFirst(i);

		assertEquals(1, ll.get(3));
	}

	@Test
	void testRemove() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		for(int i = 0; i < 5; ++i) ll.addFirst(i);

		ll.remove(1);
		assertEquals("[4, 2, 1, 0]", ll.toString());
	}

	@Test
	void testAdd() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
			for(int i = 0; i < 5; ++i) ll.addFirst(i);

		ll.add(2, -1);
		assertEquals("[4, 3, -1, 2, 1, 0]", ll.toString());
	}

	@Test
	void testToString() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		for(int i = 0; i < 5; ++i) ll.addFirst(i);

		assertEquals("[4, 3, 2, 1, 0]", ll.toString());
	}

	@Test
	void testIterator() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		for(int i = 0; i < 5; ++i) ll.addFirst(i);
		
		ArrayList<Integer> buf = new ArrayList<>();
		for(Integer i : ll) {
			buf.add(i);
		}
		assertEquals("[4, 3, 2, 1, 0]", buf.toString());
	}

}
