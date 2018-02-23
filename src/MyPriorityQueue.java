import java.util.ArrayList;

// Christin Scott
/**
 * The bonus implementation of the priority queue. Modeled on Java's PriorityQueue.
 * @author Christin Scott
 * @param <T> the element type
 */
public class MyPriorityQueue<T> {

	/** points to the back of the queue. **/
	private int backIndex;

	/** the array of elements **/
	private ArrayList<T> theChars = new ArrayList<T>(128);

	/**
	 * The priority queue constructor. Initializes the back index to -1.
	 */
	public MyPriorityQueue() {
		backIndex = -1;
	}

	/**
	 * The add method. Adds the node to the queue based on its priority.
	 * @param theNode
	 * @return
	 */
	public boolean add(T theNode) {
		/** return value for the method **/
		boolean returnBool = false;
		if (theChars.isEmpty()) {
			backIndex = 0;
			theChars.add(theNode);
			return true;
		} else {
			for (int i = 0; i < theChars.size(); i++) {
				if (((HuffmanNode) theNode).getWeight() <= ((HuffmanNode) theChars.get(i)).getWeight()) {
					theChars.add(i, theNode);
					backIndex++;
					return true;
				} else if (i +1 == theChars.size()) {
					theChars.add(i+1, theNode);
					return true;
					
				}
			}
		}
		return returnBool;
	}

	/**
	 * This method removes the specified node from the queue.
	 * @param theNode the node to be removed
	 */
	public void remove(T theNode) {
		theChars.remove(theNode);
	}

	/**
	 * This method gets the size of the queue.
	 * @return the size of the queue
	 */
	public int size() {
		return theChars.size();
	}

	/**
	 * This method returns but doesn't remove the top item of the queue.
	 * @return the top element in the queue
	 */
	public Object peek() {
		return theChars.get(0);
	}

	/**
	 * This method converts the queue to an array.
	 * @return the queue as an array
	 */
	@SuppressWarnings("unchecked")
	public T[] toArray() {
		return (T[]) theChars.toArray();
	}

	/**
	 * This method returns but doesn't dequeue the back of the queue.
	 * @return the last element in the queue
	 */
	public Object getBack() {
		return theChars.get(backIndex);
	}

	/**
	 * This method removes and returns the top element (dequeue).
	 * @return the top element of the queue
	 */
	public Object poll() {
		Object temp = theChars.get(0);
		theChars.remove(0);
		backIndex--;
		return temp;
	}
	
	/**
	 * This method gets the element at the index passed as parameter.
	 * @param theIndex the index to return
	 * @return the element at index position
	 */
	public Object get(int theIndex) {
		return theChars.get(theIndex);
	}
}
