package com.redant.project;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class InstructionMessageQueueTest {

	private static InstructionMessageQueue queue;
	static InstructionMessage messageHigh1;
	static InstructionMessage messageHigh2;
	static InstructionMessage messageHigh3;
	static InstructionMessage messageMedium1;
	static InstructionMessage messageMedium2;
	static InstructionMessage messageMedium3;
	static InstructionMessage messageLow1;
	static InstructionMessage messageLow2;
	static InstructionMessage messageLow3;
	static int initialSize;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		queue = new InstructionMessageQueue();
		messageHigh1 = new InstructionMessage(1, 1, 5, 87, 8);
		messageHigh2 = new InstructionMessage(10, 2, 58, 9, 8);
		messageMedium1 = new InstructionMessage(11, 3, 6, 9, 8);
		messageMedium2 = new InstructionMessage(90, 4, 45, 9, 8);
		messageLow1 = new InstructionMessage(91, 5, 9, 9, 8);
		messageLow2 = new InstructionMessage(99, 6, 6, 9, 8);

		queue.enque(messageMedium1);
		queue.enque(messageLow1);
		queue.enque(messageMedium2);
		queue.enque(messageHigh1);
		queue.enque(messageLow2);
		queue.enque(messageHigh2);
		initialSize = 6;
	}

	


	@Test
	public void testGetQueueSize() {

		assertEquals(queue.getQueueSize(), initialSize);
	}

	@Test
	public void testDequeue() {

		assertEquals(queue.dequeue(), messageHigh1);
		assertEquals(queue.dequeue(), messageHigh2);
		assertEquals(queue.dequeue(), messageMedium1);
		assertEquals(queue.dequeue(), messageMedium2);
		assertEquals(queue.dequeue(), messageLow1);
		assertEquals(queue.dequeue(), messageLow2);

	}
/*
 * Test  dequeuing an empty queue
 */
	@Test
	public void testDequeueEmptyQueue() {
		assertEquals(queue.getQueueSize(), 0);
		assertEquals(queue.dequeue(), null);
		assertEquals(queue.removeMessage(2), null);
	}
	/*
	 * Test  removing a message
	 */
	@Test
	public void testRemoveMessage() {
		queue.removeMessage(2);

		assertEquals(queue.getQueueSize(), initialSize - 1);

		queue.removeMessage(1);

		assertEquals(queue.getQueueSize(), initialSize - 2);
		assertEquals(queue.dequeue(), messageMedium1);

	}

	/*
	 * Test  isEmpty function
	 */
	@Test
	public void testIsEmpty() {
		for (int i = 0; i < initialSize; i++) {
			queue.dequeue();
		}
		assertTrue(queue.isEmpty());
	}

}
