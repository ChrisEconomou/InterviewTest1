package com.redant.project;

public class Main {

	static InstructionMessageQueue queue;
	static InstructionMessage messageHigh1;
	static InstructionMessage messageHigh2;
	static InstructionMessage messageHigh3;
	static InstructionMessage messageMedium1;
	static InstructionMessage messageMedium2;
	static InstructionMessage messageMedium3;
	static InstructionMessage messageLow1;
	static InstructionMessage messageLow2;
	static InstructionMessage messageLow3;

	public static void main(String[] args) {

		// create queue
		queue = new InstructionMessageQueue();

		// create messages
		messageHigh1 = new InstructionMessage(1, 1, 5, 87, 8);
		messageHigh2 = new InstructionMessage(10, 2, 58, 9, 8);
		messageHigh3 = new InstructionMessage(10, 3, 58, 9, 8);
		messageMedium1 = new InstructionMessage(11, 4, 6, 9, 8);
		messageMedium2 = new InstructionMessage(90, 5, 45, 9, 8);
		messageMedium3 = new InstructionMessage(67, 6, 45, 9, 8);
		messageLow1 = new InstructionMessage(91, 7, 7, 9, 8);
		messageLow2 = new InstructionMessage(99, 8, 8, 9, 8);
		messageLow3 = new InstructionMessage(91, 9, 78, 9, 8);

		System.out.println("Is queue empty ?" + queue.isEmpty());
		System.out.println("Alright then lets add some messages");

		// add messages
		queue.enque(messageMedium1);
		queue.enque(messageLow1);
		queue.enque(messageMedium2);
		queue.enque(messageHigh1);
		queue.enque(messageLow2);
		queue.enque(messageHigh2);
		queue.enque(messageHigh3);
		queue.enque(messageMedium3);
		queue.enque(messageLow3);

		checkSize();
		printElements();

		
		dequeue(3);

		checkSize();

		// remove failed
		removeMessage(65);

		// remove failed
		removeMessage(7);

		checkSize();
		printElements();

		dequeue(queue.getQueueSize());

		checkSize();
	

	}

	static void removeMessage(int productCode) {
		System.out.println("Trying to remove message with productCode "+productCode);
		if (queue.removeMessage(productCode)) {
			System.out.println("Congrats Your message  was removed ");
		} else {
			System.out.println("Your message doesnt exist in the queue ");
		}
	}

	static void checkSize() {
		System.out.println("The queue size now is : " + queue.getQueueSize());
	}

	static void printElements() {
		System.out.println("The queue contains these elements\n"
				+ queue.toString());
	}

	static void dequeue(int size) {

		for (int i = 0; i < size; i++) {
			System.out.println("dequeue: " + queue.dequeue().toString());
		}

	}

}
