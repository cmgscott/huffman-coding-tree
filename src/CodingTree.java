// Christin Scott

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 
 * @author CMGS
 *
 */
public class CodingTree {

	/**  **/
	private static final char[] CHAR_ALPHA_SYMB = "0123456789/.,?><';\":=+-_)(*&^%$#@!~`][}{ ABCDEEFGHIJLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();

	/**  **/
	private String myMsgToCompress;

	/**  **/
	public Map<Character, String> codes;

	/**  **/
	private ArrayList<HuffmanNode> openNodes;

	/**  **/
	public StringBuilder bits;

	/**  **/
	public StringBuilder bits3;

	/**  **/
	List<Byte> encodedMsg;

	/**  **/
	FrequencyCalculator myFrequencyCalculator = new FrequencyCalculator();

	/**  **/
	private double charWeight;

	/**  **/
	private MyPriorityQueue<HuffmanNode> myPriorityQueue;

	/**  **/
	int[] binary = new int[128];

	/**  **/
	int current = 0;

	/**  **/
	ArrayList<HuffmanNode> priorityArray;

	/**  **/
	ArrayList<HuffmanNode> huffmanTree;

	/**  **/
	StringBuilder binaryCode = new StringBuilder();

	/**
	 * 
	 * @param message
	 */
	public CodingTree(String message) {
		myMsgToCompress = message;
		myPriorityQueue = new MyPriorityQueue<HuffmanNode>();
		codes = new HashMap<Character, String>();

		double charCount = FrequencyCalculator.findTotalSymbols(myMsgToCompress);

		for (char c : CHAR_ALPHA_SYMB) {
			int charFrequency = FrequencyCalculator.calculateFreq(c, myMsgToCompress); // calc freq of each character
			myPriorityQueue.add(new HuffmanNode(c, charFrequency / charCount, charFrequency));
		}
		huffmanTree = new ArrayList<HuffmanNode>();
		mergeNodes();

		binaryCode = new StringBuilder();
		generateBinary((HuffmanNode) myPriorityQueue.peek(), binaryCode);

		writeToString();
		writeToFile();
	}

	/**
	 * 
	 */
	private void mergeNodes() {
		while (myPriorityQueue.size() > 1) {
			HuffmanNode lowestNode = (HuffmanNode) myPriorityQueue.poll();
			HuffmanNode secLowestNode = (HuffmanNode) myPriorityQueue.poll();
			HuffmanNode newNode = new HuffmanNode('\t', lowestNode.getWeight() + secLowestNode.getWeight());
			newNode.setLeft(lowestNode);
			newNode.setRight(secLowestNode);
			myPriorityQueue.add(newNode);
			mergeNodes();
		}
	}

	/**
	 * 
	 * @param currentNode
	 * @param theBinCode
	 */
	private void generateBinary(HuffmanNode currentNode, StringBuilder theBinCode) {
		if (currentNode.getLeft() == null) {
			theBinCode.append('0');
			currentNode.setBin(theBinCode);
			codes.put(currentNode.getSymb(), theBinCode.toString());
			theBinCode.deleteCharAt(theBinCode.length()-1);
		} else if (currentNode.getLeft() != null) {
			theBinCode.append('0');
			currentNode.setBin(theBinCode);
			generateBinary(currentNode.getLeft(), currentNode.getBin());
		}
		if (currentNode.getRight() == null) {
			theBinCode.append('1');
			currentNode.setBin(theBinCode);
			codes.put(currentNode.getSymb(), theBinCode.toString());
			theBinCode.deleteCharAt(theBinCode.length()-1);
		} else if (currentNode.getRight() != null) {
			theBinCode.append('1');
			currentNode.setBin(theBinCode);
			generateBinary(currentNode.getRight(), currentNode.getBin());
		}
	}

	/**
	 * 
	 */
	private void writeToString() {
		bits = new StringBuilder();
		bits3 = new StringBuilder();
		List<StringBuilder> bits4 = new ArrayList<StringBuilder>();
		byte[] getBits = null;
		encodedMsg = new ArrayList<Byte>();

		Set<Character> keySet = codes.keySet();
		Object[] keySetArray = keySet.toArray();
		for (int i = 0; i < keySetArray.length; i++) {
			if (codes.get(keySetArray[i]).length() <= 7) {
				for (int j = 0; j < codes.get(keySetArray[i]).length(); j++) {
					bits.append(codes.get(keySetArray[i]).charAt(j));
				}
				codes.put((Character) keySetArray[i], bits.toString());
				bits = new StringBuilder();
			} else if (codes.get(keySetArray[i]).length() <= 14) {
				for (int j = 0; j < 7; j++) {
					bits.append(codes.get(keySetArray[i]).charAt(j));
				}
				bits.append(" ");
				for (int j = 7; j < codes.get(keySetArray[i]).length(); j++) {
					bits.append(codes.get(keySetArray[i]).charAt(j));
				}
				codes.put((Character) keySetArray[i], bits.toString());
				bits = new StringBuilder();
			} else if (codes.get(keySetArray[i]).length() <= 21) {
				for (int j = 0; j < 7; j++) {
					bits.append(codes.get(keySetArray[i]).charAt(j));
				}
				bits.append(" ");
				for (int j = 7; j < 14; j++) {
					bits.append(codes.get(keySetArray[i]).charAt(j));
				}
				bits.append(" ");
				for (int j = 14; j < codes.get(keySetArray[i]).length(); j++) {
					bits.append(codes.get(keySetArray[i]).charAt(j));
				}
				codes.put((Character) keySetArray[i], bits.toString());
				bits = new StringBuilder();
			} else if (codes.get(keySetArray[i]).length() <= 28) {
				for (int j = 0; j < 7; j++) {
					bits.append(codes.get(keySetArray[i]).charAt(j));
				}
				bits.append(" ");
				for (int j = 7; j < 14; j++) {
					bits.append(codes.get(keySetArray[i]).charAt(j));
				}
				bits.append(" ");
				for (int j = 14; j < 21; j++) {
					bits.append(codes.get(keySetArray[i]).charAt(j));
				}
				bits.append(" ");
				for (int j = 21; j < codes.get(keySetArray[i]).length(); j++) {
					bits.append(codes.get(keySetArray[i]).charAt(j));
				}
				codes.put((Character) keySetArray[i], bits.toString());
				bits = new StringBuilder();
			} else if (codes.get(keySetArray[i]).length() <= 35) {
				for (int j = 0; j < 7; j++) {
					bits.append(codes.get(keySetArray[i]).charAt(j));
				}
				bits.append(" ");
				for (int j = 7; j < 14; j++) {
					bits.append(codes.get(keySetArray[i]).charAt(j));
				}
				bits.append(" ");
				for (int j = 14; j < 21; j++) {
					bits.append(codes.get(keySetArray[i]).charAt(j));
				}
				bits.append(" ");
				for (int j = 21; j < 28; j++) {
					bits.append(codes.get(keySetArray[i]).charAt(j));
				}
				bits.append(" ");
				for (int j = 28; j < codes.get(keySetArray[i]).length(); j++) {
					bits.append(codes.get(keySetArray[i]).charAt(j));
				}
				codes.put((Character) keySetArray[i], bits.toString());
				bits = new StringBuilder();
			} else if (codes.get(keySetArray[i]).length() <= 42) {
				for (int j = 0; j < 7; j++) {
					bits.append(codes.get(keySetArray[i]).charAt(j));
				}
				bits.append(" ");
				for (int j = 7; j < 14; j++) {
					bits.append(codes.get(keySetArray[i]).charAt(j));
				}
				bits.append(" ");
				for (int j = 14; j < 21; j++) {
					bits.append(codes.get(keySetArray[i]).charAt(j));
				}
				bits.append(" ");
				for (int j = 21; j < 28; j++) {
					bits.append(codes.get(keySetArray[i]).charAt(j));
				}
				bits.append(" ");
				for (int j = 28; j < 35; j++) {
					bits.append(codes.get(keySetArray[i]).charAt(j));
				}
				bits.append(" ");
				for (int j = 35; j < codes.get(keySetArray[i]).length(); j++) {
					bits.append(codes.get(keySetArray[i]).charAt(j));
				}
				codes.put((Character) keySetArray[i], bits.toString());
				bits = new StringBuilder();
			} 
		}

		/**
		 * 
		 */
		StringBuilder theBytes = new StringBuilder();
		for (int i = 0; i < myMsgToCompress.length(); i++) { // i goes through each character in text
			if (codes.get(myMsgToCompress.charAt(i)) != null) { // if the char isn't null, which happened sometimes

				if (codes.get(myMsgToCompress.charAt(i)).contains(" ")) { // then code needs multiple bytes, so
					for (int j = 0; j < codes.get(myMsgToCompress.charAt(i)).length(); j++) { // for each char in binary string
//						System.out.println(codes.get(myMsgToCompress.charAt(i)));
						if (codes.get(myMsgToCompress.charAt(i)).charAt(j) != ' ') { // if the char in the binary string isn't space
							// add the char to the stringBuilder
							theBytes.append(codes.get(myMsgToCompress.charAt(i)).charAt(j));
						} else if (codes.get(myMsgToCompress.charAt(i)).charAt(j) == ' ') { // if the char is a space it is a more to come string, and you need to
							// add the current theBytes to make a new Byte and reset the string
							encodedMsg.add(new Byte(Byte.parseByte(theBytes.toString(), 2)));
							theBytes = new StringBuilder();
						}
					}
					theBytes = new StringBuilder();
				} else {
					encodedMsg.add(new Byte(Byte.parseByte(codes.get(myMsgToCompress.charAt(i)), 2)));
				}
			}
		}
	}

	/**
	 * 
	 */
	private void writeToFile() {
		FileOutputStream outFile = null;
//		BufferedWriter outFile2 = null;

		try {
//			outFile2 = new BufferedWriter(new FileWriter("compressed.txt"));
			
			outFile = new FileOutputStream("compressed");
			for (int i = 0; i < encodedMsg.size(); i++) {
				outFile.write(encodedMsg.get(i));
//				outFile2.write(encodedMsg.get(i).toString());
			}
			outFile.write("hello".getBytes());
//			outFile2.close();
			outFile.close();
		} catch (IOException e) {

		}
	}

}
