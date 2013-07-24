Interview Test 1
==============

A big company supplies goods to small businesses and has a back office system that handles updates to its product data. Internally, updates are referred to as instructions and at the core of the system is the Instruction Processor, which, as the name suggests, is responsible for processing the instructions.
Instructions originate with the Product Induction Management (PIM) system that communicates with the BSCL back office via the Internet. 

The instructions are received by Input Nodes that package the incoming data as an Instruction Message. As the work of the Instruction Processor is very complex, it takes some time to process each instruction and so incoming instruction messages are first placed into the Instruction Queue. Messages are queued in priority order and to alleviate the load on the Instruction Processor the Instruction Queue also validates the Instruction Messages.


The InstructionQueue:
- Supports any number of InstructionMessages 
- Prioritises InstructionMessages according to the table below
- Has a method that returns the number of InstructionMessages on it
- Has a method for placing InstructionMessages onto the queue
- Has a method for removing InstructionMessages from the queue
- Has a method for retrieving the InstructionMessage at the front of the queue
- Has a method for determining if the queue is empty
- Throws an InvalidMessageException if an invalid InstructionMessage is placed on it

The InstructionMessage has the following structure:

Property	Type	Validation
- InstructionType	Integer	0 < n < 100
- ProductCode	Integer	0 < n
- Quantity	Integer	0 < n
- UOM	Integer	0 <= n < 256
- TimeStamp	Integer	0 < n
- Priorities

InstructionType	Priority
- 0 < n < 11	High
- 10 < n < 91	Medium
- 90 < n < 100	Low
Task
As part of the development team, you have been asked to develop the code for the Instruction Queue class:
-	The task should take you no more than 60 minutes.
-	You will provide the solution in an appropriate technology. 
-	The solution should be sent to the supplied email address as a zip file attachment containing the solution. Everything required to compile and run the solution (not the IDE) should be included. 
-	As part of the solution you should provide a means for the assessor to verify its correctness.
