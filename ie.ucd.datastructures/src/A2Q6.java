
public class A2Q6 {

	//Node class for the binary tree
	static class Node{
		Node parent, left, right;
		int data;

		Node(Node p,int data){
			parent = p;
			this.data = data;
			left = null;
			right = null;
		}
		Node(int data)
		{
			this.data = data;
			parent = null;
			left = null;
			right = null;
		}
	}
	static class BinaryTree
	{
		Node root;

		//Answer for Question 6
		//The dist function which returns the shortest distance between two nodes in a binary tree
		public int dist(Node one, Node two) {

			//get the lca of the two nodes
			Node lca = LCA(one.data, two.data);
			//variables to hold distance between lca and the nodes one and two
			int distOne=0, distTwo=0;

			//calculating the distances between lca,one and two
			while(one != lca) {
				distOne++;
				one = one.parent;
			}
			while(two != lca) {
				distTwo++;
				two = two.parent;
			}

			//return the distance of one and two to lca summed which is the total distance between the nodes 
			return distOne + distTwo;
		}

		Node LCA(int n1, int n2)
		{
			return LCA(root, n1, n2);
		}

		// Helper function for dist() found from https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
		// This function returns pointer to LCA of two given
		// values n1 and n2. This function assumes that n1 and
		// n2 are present in Binary Tree
		Node LCA(Node node, int n1, int n2)
		{
			// Base case
			if (node == null)
				return null;

			// If either n1 or n2 matches with root's key, report
			// the presence by returning root (Note that if a key is
			// ancestor of other, then the ancestor key becomes LCA
			if (node.data == n1 || node.data == n2)
				return node;

			// Look for keys in left and right subtrees
			Node left_lca = LCA(node.left, n1, n2);
			Node right_lca = LCA(node.right, n1, n2);

			// If both of the above calls return Non-NULL, then one key
			// is present in once subtree and other is present in other,
			// So this node is the LCA
			if (left_lca!=null && right_lca!=null)
				return node;

			// Otherwise check if left subtree or right subtree is LCA
			return (left_lca != null) ? left_lca : right_lca;
		}

		/* testing for example nodes */
		public static void main(String args[])
		{
			/* creating a binary tree and entering the nodes */
			BinaryTree tree = new BinaryTree();
			tree.root = new Node(1);
			tree.root.left = new Node(tree.root,2);
			tree.root.right = new Node(tree.root,3);
			tree.root.left.left = new Node(tree.root.left,4);
			tree.root.left.right = new Node(tree.root.left,5);
			tree.root.right.left = new Node(tree.root.right,6);

			//testing dist() should return 4
			System.out.println("Distance between 4 and 6: "+ tree.dist(tree.root.left.left, tree.root.right.left));

		}
	}
}
