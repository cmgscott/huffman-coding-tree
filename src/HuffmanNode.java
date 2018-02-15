
public class HuffmanNode extends Nodes {
	
	private char symbol;
	
	private double weight;
	
	private HuffmanNode next;
	
	private int frequency;
	
	public HuffmanNode(char theSymbol, double theWeight, int theFreq) {
		symbol = theSymbol;
		weight = theWeight;
		frequency = theFreq;
	}
	
	// construct inner nodes
	public HuffmanNode(double theWeight) {
		weight = theWeight;
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

}
