import java.util.ArrayList;

// Christin Scott
/**
 * Modeled on Java's PriorityQueue.
 * @author CMGS
 *
 * @param <HuffmanNode>
 */
public class MyPriorityQueue<T> {
	
	private final static int FRONT_INDEX = 0;
	
	private int backIndex;

	private ArrayList<HuffmanNode> theChars = new ArrayList<HuffmanNode>(128);

	private int myCurrentSize;
	
	private int index;

	public MyPriorityQueue() {
		backIndex = -1;
	}

	//	public boolean add(Object node) {
	//		if (node instanceof HuffmanNode) {
	//			this.add(node);
	//			return true;
	//		} else {
	//			return false;
	//		}
	//	}

	public boolean add(T theNode) {
		boolean returnBool = false;
//		HuffmanNode currentNode = (HuffmanNode) front;
//		HuffmanNode previousNode = (HuffmanNode) back;

//		for (int i = 0; i < theChars.size(); i++) {
//		System.out.print(theChars.get(i).getSymb() + ", ");
//		}
//		System.out.println();
//		System.out.println();
		if (theChars.isEmpty()) {
			backIndex = 0;
			theChars.add((HuffmanNode) theNode);
			return true;
		} else {
			for (int i = 0; i < theChars.size(); i++) {
				if (((HuffmanNode) theNode).getWeight() <= theChars.get(i).getWeight()) {
					theChars.add(i, (HuffmanNode) theNode);
					backIndex++;
					return true;
				} else if (i +1 == theChars.size()) {
					theChars.add(i+1, (HuffmanNode) theNode);
					return true;
					
				}
			}
//			while (!returnBool) {
//				if (((HuffmanNode) theNode).getFrequency() < currentNode.getFrequency()) {
//					((HuffmanNode) theNode).setNextNode(previousNode.nextNode());
//					previousNode.setNextNode((HuffmanNode) theNode);
//					myCurrentSize++;
//					index++;
//					return true;
//				} else if (((HuffmanNode) theNode).getFrequency() >= currentNode.getFrequency()) {
//					// if at end, add after current node, return true
//					if (currentNode.nextNode() == null) {
//						currentNode.setNextNode((HuffmanNode) theNode);
//						myCurrentSize++;
//						index++;
//						back = theNode;
//						return true;
//					} else {
//						// move on
//						previousNode = currentNode;
//						currentNode = currentNode.nextNode();
//					}
//				} 
//			}
		}
		
		return returnBool;
	}

	public void remove(Object theNode) {
//		HuffmanNode currentNode = (HuffmanNode) front;
//		HuffmanNode previousNode = currentNode;
		HuffmanNode nodeToRemove = (HuffmanNode) theNode;
		theChars.remove(nodeToRemove);
//		while (currentNode != nodeToRemove && currentNode != null) {
//			previousNode = currentNode;
//			currentNode = currentNode.nextNode();
//		}
//		if (currentNode == null) {
//			System.out.println("Character not found");
//		}
//		if (currentNode == nodeToRemove) {
//			if (currentNode == (HuffmanNode) front) {
//				front = (Object) currentNode.nextNode();
//				myCurrentSize--;
//				index--;
//			} else {
//				previousNode.setNextNode(currentNode.nextNode());
//				myCurrentSize--;
//				index--;
//			}
//		}

	}

	public int size() {
		return theChars.size();
	}

	public Object peek() {
		return theChars.get(0);
	}

	public ArrayList toArray() {
		return theChars;
	}

	public Object getBack() {
		return theChars.get(backIndex);
	}

	public Object poll() {
		Object temp = theChars.get(0);
		theChars.remove(0);
		backIndex--;
		return temp;
	}
	
	public Object get(int theIndex) {
		return theChars.get(theIndex);
	}
}
