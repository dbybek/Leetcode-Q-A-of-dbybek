import java.util.Scanner;

//1038. Binary Search Tree to Greater Sum Tree (Medium)
//-----------------------------------------------------
//Given the root of a Binary Search Tree (BST),
//convert it to a Greater Tree such that every key of the original BST is changed to
//the original key plus the sum of all keys greater than the original key in BST.
//As a reminder, a binary search tree is a tree that satisfies these constraints:
//
//The left subtree of a node contains only nodes with keys less than the node's key.
//The right subtree of a node contains only nodes with keys greater than the node's key.
//Both the left and right subtrees must also be binary search trees.
//
//Constraints:
//-----------
//The number of nodes in the tree is in the range [1, 100].
//0 <= Node.val <= 100
//All the values in the tree are unique.

 class TreeNode 
 {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
 
public class BinarySearchTreeToGreaterSumTree 
{
	private int sum = 0;
	public TreeNode bstToGst(TreeNode root)
	{
		if(root != null) {
			bstToGst(root.right);
			sum += root.val;
			root.val = sum;
			bstToGst(root.left);
		}
		return root;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		TreeNode head = new TreeNode();
		head.val = 4;
		sc.close();
		BinarySearchTreeToGreaterSumTree Res = new BinarySearchTreeToGreaterSumTree();
		System.out.print(Res.bstToGst(head));
	}
}
