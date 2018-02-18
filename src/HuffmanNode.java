// Christin Scott

/**
 * 
 * @author Christin Scott
 *
 */
public class HuffmanNode {
	/** the character. inner nodes of huffman tree have a tab for the symbol. **/
	private char symbol;

	/** the weight, or ratio of character occurrences to total character count. **/
	private double weight;

	/** the total amount of times the character occurs in the text. **/
	private int frequency;

	/** the left node for the huffman tree. **/
	private HuffmanNode left;

	/** the right node for the huffman tree. **/
	private HuffmanNode right;

	/** the binary code for the character. **/
	private StringBuilder binaryCode;
	
	/**
	 * The overloaded three parameter constructor for a HuffmanNode. Calls the two parameter constructor, and assigns a 
	 * value to the frequency. Used to create the nodes for the PriorityQueue.
	 * @param theSymbol the character
	 * @param theWeight the frequency ratio
	 * @param theFreq the total count of characters in text
	 */
	public HuffmanNode(char theSymbol, double theWeight, int theFreq) {
		this(theSymbol, theWeight);
		frequency = theFreq;
	}
	
	/**
	 * The overloaded two parameter constructor for a HuffmanNode. Used to create merged nodes with no frequency value.
	 * Frequency left null to help differentiate between the two nodes in lieu of two class inheriting from a super
	 * class.
	 * @param theSymbol the character (should be '\t' for easy identification)
	 * @param theWeight the frequency ratio
	 */
	public HuffmanNode(char theSymbol, double theWeight) {
		symbol = theSymbol;
		weight = theWeight;
		binaryCode = new StringBuilder();
	}

	/**
	 * 
	 * @return
	 */
	public double getWeight() {
		return weight;
	}
	
	/**
	 * 
	 * @return
	 */
	public char getSymb() {
		return symbol;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getFrequency() {
		return frequency;
	}
	
	/**
	 * 
	 * @param leftNode
	 */
	public void setLeft(HuffmanNode leftNode) {
		this.left = leftNode;
	}
	
	/**
	 * 
	 * @param rightNode
	 */
	public void setRight(HuffmanNode rightNode) {
		this.right = rightNode;
	}
	
	/**
	 * 
	 * @return
	 */
	public HuffmanNode getLeft() {
		return this.left;
	}
	
	/**
	 * 
	 * @return
	 */
	public HuffmanNode getRight() {
		return this.right;
	}
	
	/**
	 * 
	 * @param binary
	 */
	public void setBin(StringBuilder binary) {
		binaryCode = new StringBuilder();
		binaryCode.append(binary);
	}
	
	/**
	 * 
	 * @return
	 */
	public StringBuilder getBin() {
		return binaryCode;
	}
	
	/**
	 * 
	 * @return
	 */
	public String binToString() {
		return binaryCode.toString();
	}

}
