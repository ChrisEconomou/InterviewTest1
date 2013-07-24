package com.redant.project;

/**
 * Implementation of a priority queue using a doubly linked list
 * 
 * @author chris economou
 * 
 */
public class InstructionMessageQueue {

	private Node front;
	private Node rear;
	private Node cursor;

	private int size = 0;

	public InstructionMessageQueue() {
		front = null;
		rear = null;
		cursor = null;
	}

	/**
	 * Places a InstructionMessage onto the queue
	 * 
	 * @param InstructionMessage
	 *            to be placed
	 * @return true if message has been placed succesfully , false if not
	 */
	public boolean enque(InstructionMessage message) {

		if (message.isValid()) {
			addMessageToQueue(message);
			size++;

			return true;

		}

		return false;

	}

	/**
	 * Retrieve a message from the front of the queue
	 * 
	 * @return the InstructionMessage from the front of the queue, returns null if no element are on the queue
	 */
	public InstructionMessage dequeue() {
		if (!isEmpty()) {
			InstructionMessage message = front.getMessage();
			if(getQueueSize()==1){
				front=rear=null;
			}else{
				front = front.previous();
				front.next().setPrevious(null);
				front.setNext(null);
			}
			size--;
			return message;
		}
		return null;
	}

	/**
	 * Returns the number of elements in the queue
	 * 
	 * @return queue size
	 */
	public int getQueueSize() {
		return size;
	}

	/**
	 * Removes a message from the queue
	 * 
	 * @param the
	 *            productCode of the message to be removed
	 * @return true if message has been removed successfully, false if message
	 *         doesn't exist
	 */
	public boolean removeMessage(int productCode) {
		cursor = rear.next();
		while (cursor != null) {
			if (isEmpty()) {
				return false;
				// in case the message to remove is in the rear
			} else if (rear.getMessage().equals(productCode)) {
				size--;
				rear.next().setPrevious(null);
				rear = rear.next();

				return true;
				// in case the message to remove is in the front
			} else if (front.getMessage().equals(productCode)) {
				size--;
				front.previous().setNext(null);
				front = front.previous();
				return true;
			} else if (cursor.getMessage().equals(productCode)) {
				size--;
				cursor.previous().setNext(cursor.next());
				cursor.next().setPrevious(cursor.previous());
				return true;
				// message not found , continue iterating
			} else {
				cursor = cursor.next();
			}
		}

		return false;
	}

	/**
	 * Checks if the queue is empty
	 * 
	 * @return true if queue is empty, false if not
	 */
	public boolean isEmpty() {

		if (size > 0) {

			return false;
		}

		return true;
	}

	private void addMessageToQueue(InstructionMessage message) {

		Node newNode = new Node(message);
		if (isEmpty()) {// queue is empty
			rear = newNode;
			front = newNode;

		} else if (newNode.getMessage().compareTo(rear.message) <= 0) {// new
																		// element
																		// lowest
																		// priority

			rear.setPrevious(newNode);
			newNode.setNext(rear);
			rear = newNode;

		} else {
			addToCorrectPosition(message);
		}
	}

	/**
	 * Puts the messages to the correc t position according to its priority
	 * 
	 * @param message
	 */
	private void addToCorrectPosition(InstructionMessage message) {

		cursor = rear;
		Node newNode = new Node(message);

		while (cursor != null) {
			if (cursor.next() == null) {// newNode at the top of the the queue
				cursor.setNext(newNode);
				newNode.setPrevious(cursor);
				front = newNode;
				cursor = null;
			} else if (message.compareTo(cursor.next().getMessage()) > 0) {
				cursor = cursor.next();

			} else {// hooray we found the right position

				newNode.setNext(cursor.next());
				newNode.setPrevious(cursor);

				cursor.next().setPrevious(newNode);
				cursor.setNext(newNode);
				cursor = null;
			}

		}

	}

	/**
	 * class that holds a message instance and connects the parts of the queue
	 * through the next and previous pointer
	 * 
	 * 
	 */
	class Node {
		private InstructionMessage message;
		Node next;
		Node previous;

		public Node(InstructionMessage message) {
			this.message = message;
			this.next = null;

		}

		public void setMessage(InstructionMessage message) {
			this.message = message;
		}

		public InstructionMessage getMessage() {
			return message;
		}

		public void setNext(Node nextNode) {
			this.next = nextNode;

		}

		public Node next() {
			return next;
		}

		public void setPrevious(Node previousNode) {
			this.previous = previousNode;

		}

		public Node previous() {
			return previous;
		}

	}

	@Override
	public String toString() {
		Node node = rear;
		StringBuilder builder = new StringBuilder();
		while (node != null) {
			builder.append(node.getMessage().toString());
			builder.append("\n");
			node = node.next();
		}
		return builder.toString();
	}

}
