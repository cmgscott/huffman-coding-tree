
public class TreeNode extends Nodes {
	
	Nodes left, right;
	
	double myWeight;
	
	public TreeNode(double theWeight) {
		myWeight = myWeight;
		left = right = null;
	}
	
	public void setLeft(Nodes theNode) {
		left = theNode;
	}
	
	public void setRight(Nodes nodes) {
		right = nodes;
	}
	
	public double getWeight() {
		return myWeight;
	}
	
	public Nodes getLeft() {
		return left;
	}
	
	public Nodes getRight() {
		return right;
	}

}
