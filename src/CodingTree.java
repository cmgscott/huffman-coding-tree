import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CodingTree {

	private static final char[] CHAR_ALPHA_SYMB = "0123456789/.,?><';\":=+-_)(*&^%$#@!~`][}{' 'ABCDEEFGHIJLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
	
	private String myMsgToCompress;
	
	public Map<Character, String> codes;

	private ArrayList<HuffmanNode> openNodes;
	
	public List<Byte> bits;
	
	FrequencyCalculator myFrequencyCalculator = new FrequencyCalculator();
	
	private double charWeight;
	
	private MyPriorityQueue<HuffmanNode> myPriorityQueue;
	
	ArrayList<Nodes> priorityArray;

	ArrayList<TreeNode> huffmanTree;
	
	public CodingTree(String message) {
		myMsgToCompress = message;
		myPriorityQueue = new MyPriorityQueue();

		double charCount = FrequencyCalculator.findTotalSymbols(myMsgToCompress);
		
		for (char c : CHAR_ALPHA_SYMB) {
			int charFrequency = FrequencyCalculator.calculateFreq(c, myMsgToCompress); // calc freq of each character
			myPriorityQueue.add(new HuffmanNode(c, charFrequency / charCount, charFrequency));
			
//			System.out.println(c + ": " + charWeight);
		}
		priorityArray = myPriorityQueue.toArray();
		huffmanTree = new ArrayList<TreeNode>();
		mergeNodes((HuffmanNode) myPriorityQueue.peek());
		
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
	
	private void mergeNodes(HuffmanNode lowest) {
		while (myPriorityQueue.size() > 1) {
					myPriorityQueue.peek()
//					TreeNode innerNode = new TreeNode(lowest.getWeight() + priorityArray.get(i).getWeight());
//					innerNode.setLeft(lowest);
//					innerNode.setRight(priorityArray.get(i));
//					myPriorityQueue.pop();
//					priorityArray.remove(i);
//					
//					huffmanTree.add(innerNode);
//					priorityArray.add(innerNode);
//					mergeNodes((HuffmanNode) myPriorityQueue.peek());
		}
		System.out.println("i did it second try");
	}

}
