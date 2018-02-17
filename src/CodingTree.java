import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class CodingTree {

	private static final char[] CHAR_ALPHA_SYMB = "0123456789/.,?><';\":=+-_)(*&^%$#@!~`][}{' 'ABCDEEFGHIJLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
	
	private String myMsgToCompress;
	
	public Map<Character, String> codes;

	private ArrayList<HuffmanNode> openNodes;
	
	public List<Byte> bits;
	
	FrequencyCalculator myFrequencyCalculator = new FrequencyCalculator();
	
	private double charWeight;
	
	private PriorityQueue<HuffmanNode> myPriorityQueue;
	
	int[] binary = new int[128];
	int current = 0;
	
	ArrayList<Nodes> priorityArray;

	ArrayList<TreeNode> huffmanTree;

	StringBuilder binaryCode = new StringBuilder();
	
	public CodingTree(String message) {
		myMsgToCompress = message;
		myPriorityQueue = new PriorityQueue();
		codes = new HashMap<Character, String>();

		double charCount = FrequencyCalculator.findTotalSymbols(myMsgToCompress);
		
		for (char c : CHAR_ALPHA_SYMB) {
			int charFrequency = FrequencyCalculator.calculateFreq(c, myMsgToCompress); // calc freq of each character
			myPriorityQueue.add(new HuffmanNode(c, charFrequency / charCount, charFrequency));
			
//			System.out.println(c + ": " + charWeight);
		}
//		priorityArray = myPriorityQueue.toArray();
		huffmanTree = new ArrayList<TreeNode>();
		mergeNodes();
		
		binaryCode = new StringBuilder();
		generateBinary(myPriorityQueue.peek(), binaryCode);
		
		System.out.println(codes.get(']'));
		
		/**Testing Code**/
//		double sum = 0;
//		HuffmanNode currentNode = (HuffmanNode) myPriorityQueue.peek();
//		for (int i = 0; i < priorityArray.size(); i++) {
//			sum+= currentNode.getWeight();
//			System.out.println((priorityArray.get(i)).getSymb() + ": " + priorityArray.get(i).getWeight());
//			currentNode = currentNode.nextNode();
//		}
//		System.out.println("Array size: " + priorityArray.size());
//		System.out.println("Sum is: " + sum);
//		FrequencyCalculator.printTotalSymbols();
	}
	
	private void mergeNodes() {
		while (myPriorityQueue.size() > 1) {
					HuffmanNode lowestNode = myPriorityQueue.poll();
					HuffmanNode secLowestNode = myPriorityQueue.poll();
					HuffmanNode newNode = new HuffmanNode(lowestNode.getWeight() + secLowestNode.getWeight());
					newNode.setLeft(lowestNode);
					newNode.setRight(secLowestNode);
					myPriorityQueue.add(newNode);
					mergeNodes();
		}
	}
	
	private void generateBinary(HuffmanNode currentNode, StringBuilder theBinCode) {
		if (currentNode.getLeft() == null) {
			theBinCode.append('0');
			currentNode.setBin(theBinCode);
			codes.put(currentNode.getSymb(), theBinCode.toString());
		} else if (currentNode.getLeft() != null) {
			theBinCode.append('0');
			currentNode.setBin(theBinCode);
			generateBinary(currentNode.getLeft(), theBinCode);
		}
		if (currentNode.getRight() == null) {
			theBinCode.append('1');
			currentNode.setBin(theBinCode);
			codes.put(currentNode.getSymb(), theBinCode.toString());
		} else if (currentNode.getRight() != null) {
			theBinCode.append('1');
			currentNode.setBin(theBinCode);
			generateBinary(currentNode.getRight(), theBinCode);
		}
		System.out.println(currentNode.getSymb() + ": " + currentNode.binToString());
	}

}
