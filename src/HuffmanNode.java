import java.util.Comparator;

public class HuffmanNode extends Nodes implements Comparator<HuffmanNode>, Comparable<HuffmanNode> {
	
	private char symbol;
	
	private double weight;
	
	private HuffmanNode next;
	
	private int frequency;
	
	private HuffmanNode left;
	
	private HuffmanNode right;
	
	private StringBuilder binaryCode;
	
	public HuffmanNode(char theSymbol, double theWeight, int theFreq) {
		symbol = theSymbol;
		weight = theWeight;
		frequency = theFreq;
		binaryCode = new StringBuilder();
	}
	
	// construct inner nodes
	public HuffmanNode(char theSymbol, double theWeight) {
		symbol = theSymbol;
		weight = theWeight;
		binaryCode = new StringBuilder();
	}

	@Override
	public int compare(HuffmanNode arg0, HuffmanNode arg1) {
		return arg1.getFrequency() - arg0.getFrequency();
	}

	public double getWeight() {
		return weight;
	}
	
	public HuffmanNode nextNode() {
		return next;
	}
	
	public void setNextNode(HuffmanNode theNode) {
		this.next = theNode;
	}
	
	public char getSymb() {
		return symbol;
	}
	
	public int getFrequency() {
		return frequency;
	}
	
	public void setLeft(HuffmanNode leftNode) {
		this.left = leftNode;
	}
	
	public void setRight(HuffmanNode rightNode) {
		this.right = rightNode;
	}
	
	public HuffmanNode getLeft() {
		return this.left;
	}
	
	public HuffmanNode getRight() {
		return this.right;
	}
	
	public void setBin(StringBuilder binary) {
		binaryCode = new StringBuilder();
		binaryCode.append(binary);
	}
	
	public StringBuilder getBin() {
		return binaryCode;
	}
	
	public String binToString() {
		return binaryCode.toString();
	}

	@Override
	public int compareTo(HuffmanNode arg0) {
		return ((Integer) this.frequency).compareTo((Integer) arg0.frequency);
	}

}
