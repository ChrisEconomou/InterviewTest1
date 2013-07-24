package com.redant.project;


/**
 * class the hold the message information
 * @author christos.oikonomou
 *
 */
public class InstructionMessage implements Comparable<InstructionMessage> {

	private static final int HIGH = 1;
	private static final int MEDIUM = 2;
	private static final int LOW = 3;

	private int instructionType;
	private int productCode;
	private int quantity;
	private int uom;
	private int timestamp;
	private int priority;

	public InstructionMessage(int instructionType, int productCode,
			int quantity, int uom, int timestamp) {

		setInstructionType(instructionType);
		setProductCode(productCode);
		setQuantity(quantity);
		setUom(uom);
		setTimestamp(timestamp);
		setPriority(instructionType);
	}

	public int getInstructionType() {
		return instructionType;
	}

	public void setInstructionType(int instructionType) {
		this.instructionType = instructionType;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getUom() {
		return uom;
	}

	public void setUom(int uom) {
		this.uom = uom;
	}

	public int getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int instructionType) {
		if (instructionType < 11) {
			this.priority = HIGH;
		} else if (instructionType < 91) {
			this.priority = MEDIUM;
		} else {
			this.priority = LOW;
		}

	}

	private String priorityToString(int priority) {

		switch (priority) {
		case HIGH:
			return "High";
		case MEDIUM:
			return "Medium";
		}
		return "LOW";
	}

	/**
	 * Validate a InstructionMessage
	 * 
	 * @param a
	 *            InstructionMessage to be validated
	 * @return true if InstructionMessage is valid, false if it is invalid
	 */
	public boolean isValid() {

		try {
			validateMessage(this);

		} catch (InvalidMessageException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return false;
		}

		return true;
	}
/**
 * checks if message is valid, throws InvalidMessageException if it is not
 */
	private void validateMessage(InstructionMessage message)
			throws InvalidMessageException {

		if (message.getInstructionType() <= 0
				|| message.getInstructionType() >= 100)
			throw new InvalidMessageException("The instructionType of message "
					+ String.valueOf(message.getProductCode()) + " is invalid");

		if (message.getProductCode() <= 0)
			throw new InvalidMessageException("The getProductCode of message "
					+ String.valueOf(message.getProductCode()) + " is invalid");

		if (message.getQuantity() <= 0)
			throw new InvalidMessageException("The getProductCode of message "
					+ String.valueOf(message.getProductCode()) + " is invalid");

		if (message.getUom() < 0 || message.getUom() >= 256)
			throw new InvalidMessageException("The uom of of message "
					+ String.valueOf(message.getProductCode()) + " is invalid");

		if (message.getTimestamp() <= 0)
			throw new InvalidMessageException("The timeStamp of message "
					+ String.valueOf(message.getProductCode()) + " is invalid");

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InstructionMessage [instructionType=");
		builder.append(instructionType);
		builder.append(", productCode=");
		builder.append(productCode);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", uom=");
		builder.append(uom);
		builder.append(", timestamp=");
		builder.append(timestamp);
		builder.append(", priority=");
		builder.append(priorityToString(priority));
		builder.append("]");
		// TODO Auto-generated method stub
		return builder.toString();
	}

	/**
	 * compare 2 messages
	 * 
	 * @return 0 if messages are of equal priority 1 if current message is of
	 *         highest priority of the parameter message -1 if current message
	 *         is of lowest priority of the parameter message
	 */
	@Override
	public int compareTo(InstructionMessage another) {

		// 0<n<11 High
		// 10<n<91 Medium
		// 90<n<100 Low

		int p = another.priority - this.priority;
		if (p > 0) {
			return 1;
		} else if (p < 0) {
			return -1;
		}
		return 0;
	}

	public boolean equals(int productCode) {

		return this.productCode == productCode;

	}
}
