import java.util.ArrayList;

// Christin Scott
/**
 * Modeled on Java's PriorityQueue.
 * @author CMGS
 *
 * @param <HuffmanNode>
 */
public class MyPriorityQueue<T> {

	/**  **/
	private final static int FRONT_INDEX = 0;

	/**  **/
	private int backIndex;

	/**  **/
	private ArrayList<HuffmanNode> theChars = new ArrayList<HuffmanNode>(128);

	/**  **/
	private int myCurrentSize;

	/**  **/
	private int index;

	/**
	 * 
	 */
	public MyPriorityQueue() {
		backIndex = -1;
	}

	/**
	 * 
	 * @param theNode
	 * @return
	 */
	public boolean add(T theNode) {
		boolean returnBool = false;
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
		}
		
		return returnBool;
	}

	/**
	 * 
	 * @param theNode
	 */
	public void remove(Object theNode) {
		HuffmanNode nodeToRemove = (HuffmanNode) theNode;
		theChars.remove(nodeToRemove);
	}

	/**
	 * 
	 * @return
	 */
	public int size() {
		return theChars.size();
	}

	/**
	 * 
	 * @return
	 */
	public Object peek() {
		return theChars.get(0);
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList toArray() {
		return theChars;
	}

	/**
	 * 
	 * @return
	 */
	public Object getBack() {
		return theChars.get(backIndex);
	}

	/**
	 * 
	 * @return
	 */
	public Object poll() {
		Object temp = theChars.get(0);
		theChars.remove(0);
		backIndex--;
		return temp;
	}
	
	/**
	 * 
	 * @param theIndex
	 * @return
	 */
	public Object get(int theIndex) {
		return theChars.get(theIndex);
	}
}
