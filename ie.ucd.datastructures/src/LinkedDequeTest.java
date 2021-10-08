import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

//testing class which has tests for all required deque methods
class LinkedDequeTest {

	@Test
	void testSize() {
		LinkedDeque<Integer> test = new LinkedDeque<Integer>();
		test.addFirst(1);
		
		assertEquals(1, test.size());
		
		test.addLast(2);
		
		assertEquals(2, test.size());
	}
	
	@Test
	void testIsEmpty() {
		LinkedDeque<Integer> test = new LinkedDeque<Integer>();

		assertEquals(true, test.isEmpty());
		
		test.addFirst(1);
		
		assertEquals(false, test.isEmpty());
	}
	
	@Test
	void testFirst() {
		LinkedDeque<Integer> test = new LinkedDeque<Integer>();
		test.addFirst(2);
		test.addLast(3);
		test.addFirst(1);
		
		assertEquals(1, test.first());
	}
	
	@Test
	void testLast() {
		LinkedDeque<Integer> test = new LinkedDeque<Integer>();
		test.addLast(1);
		test.addLast(2);
		
		assertEquals(2, test.last());
	}
	
	@Test
	void testAddFirst() {
		LinkedDeque<Integer> test = new LinkedDeque<Integer>();
		test.addFirst(1);
		test.addFirst(2);
		test.addFirst(3);
		
		assertEquals("321", test.toString());
	}
	
	@Test
	void testAddLast() {
		LinkedDeque<Integer> test = new LinkedDeque<Integer>();
		test.addLast(1);
		test.addLast(2);
		test.addLast(3);
		
		assertEquals("123", test.toString());
	}
	
	@Test
	void testRemovefirst() {
		LinkedDeque<Integer> test = new LinkedDeque<Integer>();
		test.addLast(1);
		test.addLast(2);
		test.addLast(3);
		
		assertEquals(1, test.removeFirst());
		assertEquals("23", test.toString());
	}
	
	@Test
	void testRemoveLast() {
		LinkedDeque<Integer> test = new LinkedDeque<Integer>();
		test.addLast(1);
		test.addLast(2);
		test.addLast(3);
		
		assertEquals(3, test.removeLast());
		assertEquals("12", test.toString());
	}

}
