// Christin Scott

/**
 * The HuffmanNode class creates the nodes for the Huffman Tree.
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
	 * This method gets the weight of the node.
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}
	
	/**
	 * This method gets the symbol of the node.
	 * @return the symbol
	 */
	public char getSymb() {
		return symbol;
	}
	
	/**
	 * This method gets the frequency of the node.
	 * @return the frequency
	 */
	public int getFrequency() {
		return frequency;
	}
	
	/**
	 * This method sets the left child of the node in the Huffman Tree.
	 * @param leftNode the node to set as left child
	 */
	public void setLeft(HuffmanNode leftNode) {
		this.left = leftNode;
	}
	
	/**
	 * This method sets the right child of the node in the Huffman Tree.
	 * @param rightNode the node to set as right child
	 */
	public void setRight(HuffmanNode rightNode) {
		this.right = rightNode;
	}
	
	/**
	 * This method gets the left child of the node.
	 * @return the left child of the node
	 */
	public HuffmanNode getLeft() {
		return this.left;
	}
	
	/**
	 * This method gets the right child of the node.
	 * @return the right child of the node
	 */
	public HuffmanNode getRight() {
		return this.right;
	}
	
	/**
	 * This method sets the binary code of the character based on the position in the Huffman Tree.
	 * @param binary the binary code generated
	 */
	public StringBuilder setBin(StringBuilder binary) {
		binaryCode = new StringBuilder();
		binaryCode.append(binary);
		return binaryCode;
	}
	
	/**
	 * This method gets the nodes binary code.
	 * @return the binary code
	 */
	public StringBuilder getBin() {
		return binaryCode;
	}
	
	/**
	 * This method gets the string representation of the binary code.
	 * @return the binary code
	 */
	public String binToString() {
		return binaryCode.toString();
	}

}
