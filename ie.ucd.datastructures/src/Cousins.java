//Q6 answer for Assignment 1
//Student Number: 19349341

public class Cousins {
	
	//defining the nodes for a binary tree
	private static class Node {
		int element;
		Node right,left,parent;//making a node for the left ,right and parent nodes
		
		//defining the constructor for the nodes
		public Node(int e, Node p) {
			element = e;
			parent = p;
			right = null;
			left = null;
		}
	}
	
	//the method to check if two nodes are cousins
	public static boolean checkCousins(Node a, Node b) {
		//first checks if a and b are on the same level using the getLevel helper function
		//then checks if a and b have separate parents because otherwise they are siblings
		if(getLevel(a) == getLevel(b) && a.parent != b.parent) {
			return true;
		}
		return false;
	}
	
	//helper function returns the level of a node in the binary tree
	public static int getLevel(Node a) {
		int level = 1;//instantiate the level with value 1
		//increase the level while a node has a parent and is not null 
		while (a != null && a.parent != null) {
			level++;
			a = a.parent;//set a to the next parent node
		}
		return level;//return the final value of level
	}
	
	//main used for testing the functions
	public static void main(String[] args) {
		//defining the nodes of a binary tree
		Node tree = new Node(26,null);
		tree.right = new Node(6, tree);
		tree.right.right = new Node(6, tree.right);
		tree.left = new Node(7,tree);
		tree.left.left = new Node(3,tree.left);
		tree.left.right = new Node(4,tree.left);
		
		System.out.println(checkCousins(tree,tree.right));//should return false
		System.out.println(checkCousins(tree.left.left, tree.right.right));//return true
		System.out.println(checkCousins(tree.left.left,tree.left.right	));//return false
	}
}
