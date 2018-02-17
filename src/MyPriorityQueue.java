import java.util.ArrayList;

// Christin Scott
/**
 * Modeled on Java's PriorityQueue.
 * @author CMGS
 *
 * @param <HuffmanNode>
 */
public class MyPriorityQueue<T> {

	private ArrayList<HuffmanNode> theChars = new ArrayList<HuffmanNode>();

	private Object front, back;

	private int myCurrentSize;
	
	private int index;

	public MyPriorityQueue() {
		front = back = null;
		index = -1;
	}

	//	public boolean add(Object node) {
	//		if (node instanceof HuffmanNode) {
	//			this.add(node);
	//			return true;
	//		} else {
	//			return false;
	//		}
	//	}

	public boolean add(Object theNode) {
		boolean returnBool = false;
		HuffmanNode currentNode = (HuffmanNode) front;
		HuffmanNode previousNode = (HuffmanNode) back;
		int count = 0;
		if (front == null) {
			front = back = /*(Object)(Object)*/theNode;
			myCurrentSize++;
			index++;
			return true;
		} else if (((HuffmanNode) theNode).getFrequency() < ((HuffmanNode) front).getFrequency()) {
			((HuffmanNode) theNode).setNextNode((HuffmanNode) front);
			front = theNode;
			myCurrentSize++;
			index++;
			return true;
		} else {
			while (!returnBool) {
				if (((HuffmanNode) theNode).getFrequency() < currentNode.getFrequency()) {
					((HuffmanNode) theNode).setNextNode(previousNode.nextNode());
					previousNode.setNextNode((HuffmanNode) theNode);
					myCurrentSize++;
					index++;
					return true;
				} else if (((HuffmanNode) theNode).getFrequency() >= currentNode.getFrequency()) {
					// if at end, add after current node, return true
					if (currentNode.nextNode() == null) {
						currentNode.setNextNode((HuffmanNode) theNode);
						myCurrentSize++;
						index++;
						back = theNode;
						return true;
					} else {
						// move on
						previousNode = currentNode;
						currentNode = currentNode.nextNode();
						count++;
					}
				} 
			}
		}
		return returnBool;
	}

	public void remove(Object theNode) {
		HuffmanNode currentNode = (HuffmanNode) front;
		HuffmanNode previousNode = currentNode;
		HuffmanNode nodeToRemove = (HuffmanNode) theNode;
		while (currentNode != nodeToRemove && currentNode != null) {
			previousNode = currentNode;
			currentNode = currentNode.nextNode();
		}
		if (currentNode == null) {
			System.out.println("Character not found");
		}
		if (currentNode == nodeToRemove) {
			if (currentNode == (HuffmanNode) front) {
				front = (Object) currentNode.nextNode();
				myCurrentSize--;
				index--;
			} else {
				previousNode.setNextNode(currentNode.nextNode());
				myCurrentSize--;
				index--;
			}
		}

	}

	public int size() {
		return myCurrentSize;
	}

	public Object peek() {
		return front;
	}

	public ArrayList toArray() {
		HuffmanNode currentNode = (HuffmanNode) front;
		ArrayList returnArr = new ArrayList();
		for (int i = 0; i < myCurrentSize; i++) {
			returnArr.add(currentNode);
			currentNode = currentNode.nextNode();
		}
		return returnArr;
	}

	public Object getBack() {
		return back;
	}

	public Object pop() {
		Object temp = front;
		front = (Object) ((HuffmanNode) front).nextNode();
		myCurrentSize--;
		return temp;
	}
	
	public Object get(int theIndex) {
		if (theIndex > myCurrentSize) {
		HuffmanNode currentNode = (HuffmanNode) front;
		for (int i = 0; i <= theIndex; i++) {
			currentNode = currentNode.nextNode();
		}
		return (Object) currentNode;
		} else {
			//throw exception
			return null;
		}
	}
}
