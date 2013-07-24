package com.redant.project;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class InstructionMessageTest {

	private static InstructionMessageQueue queue;
	static InstructionMessage message1;
	static InstructionMessage message2;
	static InstructionMessage message3;
	static InstructionMessage message4;
	static InstructionMessage message5;
	static InstructionMessage message6;
	static InstructionMessage message7;
	static InstructionMessage high;
	static InstructionMessage medium;
	static InstructionMessage low;

	/*
	 * InstructionType 0 < n < 100 ProductCode 0 < n Quantity 0 < n UOM 0 <= n <
	 * 256 TimeStamp 0 < n
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		queue = new InstructionMessageQueue();
		// InstructionType 0 < n < 100 high priority
		message1 = new InstructionMessage(-1, 1, 5, 87, 8);
		message2 = new InstructionMessage(101, 1, 5, 87, 8);
		// ProductCode 0 < n
		message3 = new InstructionMessage(1, 0, 5, 87, 8);
		// Quantity 0 < n
		message4 = new InstructionMessage(1, 1, 0, 87, 8);
		// UOM 0 <= n < 256
		message5 = new InstructionMessage(1, 3, 5, -1, 8);
		message6 = new InstructionMessage(1, 1, 5, 256, 8);
		// TimeStamp 0 < n
		message7 = new InstructionMessage(1, 1, 5, 87, 0);

		high=new InstructionMessage(1, 1, 5, 87, 0);
		medium=new InstructionMessage(59, 50, 5, 87, 0);
		low=new InstructionMessage(93,92, 5, 87, 0);
		
	}
/*
 * Test the validation check
 */
	@Test
	public void testIsValid() {
		assertFalse(message1.isValid());
		assertFalse(message2.isValid());
		assertFalse(message3.isValid());
		assertFalse(message4.isValid());
		assertFalse(message5.isValid());
		assertFalse(message6.isValid());
		assertFalse(message7.isValid());
		
	}
	
	@Test
	public void enqueueInvalidMessages(){
		queue.enque(message1);
		queue.enque(message2);
		queue.enque(message3);
		queue.enque(message4);
		queue.enque(message5);
		queue.enque(message6);
		assertTrue(queue.isEmpty());
		assertEquals(queue.getQueueSize(),0);
	}

	/*
	 * Test the compare to functionality
	 */
	@Test
	public void testCompareTo() {
		assertEquals(high.compareTo(medium),1);
		assertEquals(high.compareTo(low),1);
		assertEquals(high.compareTo(high),0);
		
		assertEquals(medium.compareTo(medium),0);
		assertEquals(medium.compareTo(low),1);
		assertEquals(medium.compareTo(high),-1);
		
		assertEquals(low.compareTo(medium),-1);
		assertEquals(low.compareTo(low),0);
		assertEquals(low.compareTo(high),-1);
		
	}

}
