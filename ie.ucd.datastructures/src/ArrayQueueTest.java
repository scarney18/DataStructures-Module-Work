import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

//test class for ArrayQueue tests all required methods
class ArrayQueueTest {
	

	@Test
	void testFirst() {
		ArrayQueue test = new ArrayQueue(10);
		test.enqueue(1);
		test.enqueue(2);
		
		assertEquals(1, test.first());
	}
	
	@Test
	void testEnque() {
		ArrayQueue test = new ArrayQueue(10);
		test.enqueue(1);
		test.enqueue(2);
		
		assertEquals("12", test.toString());
	}
	
	@Test
	void testDeque() {
		ArrayQueue test = new ArrayQueue(10);
		test.enqueue(1);
		test.enqueue(2);
		
		assertEquals(1, test.dequeue());
		assertEquals("2", test.toString());
	}
	
	@Test
	void testSize() {
		ArrayQueue test = new ArrayQueue(10);
		
		assertEquals(0, test.size());
		
		test.enqueue(1);
		test.enqueue(2);
		
		assertEquals(2, test.size());
	}

	@Test
	void testIsEmpty() {
		ArrayQueue test = new ArrayQueue(10);
		
		assertEquals(true, test.isEmpty());
		
		test.enqueue(1);
		test.enqueue(2);
		
		assertEquals(false, test.isEmpty());
	}
}
