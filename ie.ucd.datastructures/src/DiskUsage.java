//Q5 answer for Assignment 1
//Student Number: 19349341

public class DiskUsage {
	
	//helper function which returns the total sum of all elements in a binary tree from the root Node
	public static int sumTree(Node tree) {
		if(tree == null)
			return 0;//base case for the function
		else//recursive call for the left and right element of the root given
			return (sumTree(tree.left) + tree.element + sumTree(tree.right));
	}
	
	public static boolean isDiskUsage(Node tree) {//function checks if a given tree is a valid DiskUsage tree
		
		int leftSum=0,rightSum=0;//variables for the sum of the left and right of the tree
		
		if(tree == null || tree.left == null && tree.right == null) {
			return true;//return true for a leaf node and an empty tree
		}
		
		else {
			leftSum = sumTree(tree.left);//call on the helper function to get the sums
			rightSum = sumTree(tree.right);
		}
		//if the node given equals the sum of it's child nodes' tree and the children are also disk usage trees return true
		if((tree.element == leftSum + rightSum)
			&& isDiskUsage(tree.left) && isDiskUsage(tree.right)) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Node tree = new Node(26);//creating binary trees for testing
		tree.right = new Node(6);
		tree.right.right = new Node(6);
		tree.left = new Node(7);
		tree.left.left = new Node(3);
		tree.left.right = new Node(4);
		
		Node tree2 = new Node(0);
		
		Node tree3 = new Node(10);
		tree3.left = new Node(4);
		tree3.right = new Node(5);
		
		System.out.println(isDiskUsage(tree));//should return true
		System.out.println(isDiskUsage(tree2));//should return true
		System.out.println(isDiskUsage(tree3));//should return false
	}
	
	private static class Node {//defining the nodes for a binary tree
		int element;
		Node right,left;
		
		public Node(int e) {
			element = e;
			right = null;
			left = null;
		}
	}
}


