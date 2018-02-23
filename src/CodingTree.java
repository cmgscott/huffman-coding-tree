// Christin Scott

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The CodingTree class as required by the assignment. Handles the initial creation of priority queue, building the
 * Huffman Tree, generating the binary for each character, and writing the newly encoded text to a new file.
 * @author Christin Scott
 *
 */
public class CodingTree {

	/** the text to compress **/
	private String myMsgToCompress;

	/** the map of generated binary codes for each character **/
	public Map<Character, String> codes;

	/** the bitstring of encoded text **/
	public StringBuilder bits;

	/** the encodedMsg cast to characters **/
	private List<Character>encodedMsg;

	/** the priority queue for the Huffman Tree **/
	private MyPriorityQueue<HuffmanNode> myPriorityQueue;

	/**
	 * The constructor for the class. Constructor accepts the orignial text as a string, and the original file size.
	 * The constructor also handles calculating the total number of characters in the original message and builds the
	 * initial priority queue. It also calls the methods that complete the Huffman encoding.
	 * @param message the original message
	 * @param theOrgFileSize the original file size in bytes.
	 */
	public CodingTree(String message) {
		myMsgToCompress = message;
		myPriorityQueue = new MyPriorityQueue<HuffmanNode>();
		codes = new HashMap<Character, String>();

		double charCount = FrequencyCalculator.findTotalSymbols(myMsgToCompress);

		/** array of all characters to encode **/
		final char[] CHAR_ALPHA_SYMB = ("0123456789/.,?><';\":=+-_)(*&^%$#@!~`][}{ ABCDEEFGHIJLMNOPQRSTUVWXYZabcdefghij"
				+ "klmnopqrstuvwxyz\t\r").toCharArray();

		for (char c : CHAR_ALPHA_SYMB) {
			int charFrequency = FrequencyCalculator.calculateFreq(c, myMsgToCompress); // calc freq of each character
			myPriorityQueue.add(new HuffmanNode(c, charFrequency / charCount, charFrequency));
		}

		buildHuffmanTree();

		/** the binary code generated **/
		StringBuilder binaryCode = new StringBuilder();
		generateBinary((HuffmanNode) myPriorityQueue.peek(), binaryCode);

		writeToString();
	}

	/**
	 * Recursive method that builds the Huffman Tree starting with the highest priority nodes in the priority queue.
	 */
	private void buildHuffmanTree() {
		while (myPriorityQueue.size() > 1) {
			HuffmanNode lowestNode = (HuffmanNode) myPriorityQueue.poll();
			HuffmanNode secLowestNode = (HuffmanNode) myPriorityQueue.poll();
			HuffmanNode newNode = new HuffmanNode('\t', lowestNode.getWeight() + secLowestNode.getWeight());
			newNode.setLeft(lowestNode);
			newNode.setRight(secLowestNode);
			myPriorityQueue.add(newNode);
			buildHuffmanTree();
		}
	}

	/**
	 * Recursive method that generates a binary encoding for each character from the Huffman Tree.
	 * @param currentNode the current node in the tree
	 * @param theBinCode the currently generated binary
	 */
	private void generateBinary(HuffmanNode currentNode, StringBuilder theBinCode) {
		if (currentNode.getRight() == null && currentNode.getLeft() == null) {
			currentNode.setBin(theBinCode);
			codes.put(currentNode.getSymb(), currentNode.binToString());
			theBinCode.deleteCharAt(theBinCode.length()-1);
		} else {
			if (currentNode.getRight() != null) {
				currentNode.setBin(theBinCode);
				generateBinary(currentNode.getRight(), currentNode.setBin(currentNode.getBin().append('1')));
			}
			if (currentNode.getLeft() != null) {
				currentNode.setBin(theBinCode);
				generateBinary(currentNode.getLeft(), currentNode.setBin(currentNode.getBin().append('0')));
			}
		}
	}

	/**
	 * Method that populates an array with the encoded message.
	 */
	private void writeToString() {
		bits = new StringBuilder();
		encodedMsg = new ArrayList<Character>();
		for (int i = 0; i < myMsgToCompress.length(); i++) {
			if (codes.get(myMsgToCompress.charAt(i)) != null) {
				bits.append(codes.get(myMsgToCompress.charAt(i)));
			}
		}

		for (int i = 0; i < bits.length() / 8 * 8; i+=8) {
			char tempChar = (char) Byte.parseByte(bits.subSequence(i, i + 7).toString(), 2);
			encodedMsg.add(tempChar);
		}
		if (bits.length() % 8 != 0) {
			encodedMsg.add((char) Integer.parseInt(bits.subSequence(bits.length() / 8 * 8, bits.length()).toString()));
		}
	}
	
	public Map<Character, String> getCodes() {
		return codes;
	}
	
	public List<Character> getEncodedMsg() {
		return encodedMsg;
	}
}
