import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class CodingTree {

	private static final char[] CHAR_ALPHA_SYMB = "0123456789/.,?><';\":=+-_)(*&^%$#@!~`][}{ ABCDEEFGHIJLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
	
	private String myMsgToCompress;
	
	public Map<Character, String> codes;

	private ArrayList<HuffmanNode> openNodes;
	
	public List<Byte> bits;
	
	FrequencyCalculator myFrequencyCalculator = new FrequencyCalculator();
	
	private double charWeight;
	
	private MyPriorityQueue<HuffmanNode> myPriorityQueue;
	
	int[] binary = new int[128];
	int current = 0;
	
	ArrayList<HuffmanNode> priorityArray;

	ArrayList<HuffmanNode> huffmanTree;

	StringBuilder binaryCode = new StringBuilder();
	
	public CodingTree(String message) {
		myMsgToCompress = message;
		myPriorityQueue = new MyPriorityQueue<HuffmanNode>();
		codes = new HashMap<Character, String>();

		double charCount = FrequencyCalculator.findTotalSymbols(myMsgToCompress);
		
		for (char c : CHAR_ALPHA_SYMB) {
			int charFrequency = FrequencyCalculator.calculateFreq(c, myMsgToCompress); // calc freq of each character
			myPriorityQueue.add(new HuffmanNode(c, charFrequency / charCount, charFrequency));
			
//			System.out.println(c + ": " + charWeight);
		}
		huffmanTree = new ArrayList<HuffmanNode>();
		mergeNodes();
		
		binaryCode = new StringBuilder();
		generateBinary((HuffmanNode) myPriorityQueue.peek(), binaryCode);
		
		Set<Character> keySet = codes.keySet();
		Object[] keySetArray = keySet.toArray();
		for (int i = 0; i < keySet.size(); i++) {
		System.out.println((Character) keySetArray[i]);
		}
	}
	
	private void mergeNodes() {
		while (myPriorityQueue.size() > 1) {
					HuffmanNode lowestNode = (HuffmanNode) myPriorityQueue.poll();
					HuffmanNode secLowestNode = (HuffmanNode) myPriorityQueue.poll();
					HuffmanNode newNode = new HuffmanNode('\t', lowestNode.getWeight() + secLowestNode.getWeight());
					newNode.setLeft(lowestNode);
					newNode.setRight(secLowestNode);
					myPriorityQueue.add(newNode);
//					System.out.println("| " + "left: " + lowestNode.getSymb() + " | right: " + secLowestNode.getSymb() + " |");
					mergeNodes();
		}
	}
	
	private void generateBinary(HuffmanNode currentNode, StringBuilder theBinCode) {
		if (currentNode.getRight() == null) {
			theBinCode.append('1');
			currentNode.setBin(theBinCode);
			codes.put(currentNode.getSymb(), theBinCode.toString());
			theBinCode.deleteCharAt(theBinCode.length()-1);
		} 
		if (currentNode.getRight() != null) {
			theBinCode.append('1');
			currentNode.setBin(theBinCode);
			generateBinary(currentNode.getRight(), currentNode.getBin());
		}
		if (currentNode.getLeft() == null) {
			theBinCode.append('0');
			currentNode.setBin(theBinCode);
			codes.put(currentNode.getSymb(), theBinCode.toString());
			theBinCode.deleteCharAt(theBinCode.length()-1);
		} 
		if (currentNode.getLeft() != null) {
			theBinCode.append('0');
			currentNode.setBin(theBinCode);
			generateBinary(currentNode.getLeft(), currentNode.getBin());
		}
//		System.out.println(currentNode.getSymb() + ": " + currentNode.binToString());
	}
	
	private void removeBlankNodes() {
		Set<Character> keySet = codes.keySet();
		for (int i = 0; i < keySet.size(); i++) {
		}
	}

}
