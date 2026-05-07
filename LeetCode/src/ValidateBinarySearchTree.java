import java.util.Scanner;

//98. Validate Binary Search Tree (Medium)
//----------------------------------------
//Given the root of a binary tree, determine if it is a valid binary search tree (BST).
//A valid BST is defined as follows:
//The left subtree of a node contains only nodes with keys strictly less than the node's key.
//The right subtree of a node contains only nodes with keys strictly greater than the node's key.
//Both the left and right subtrees must also be binary search trees.
//
//Constraints:
//-----------
//The number of nodes in the tree is in the range [1, 10^4].
//-2^31 <= Node.val <= 2^31 - 1

public class ValidateBinarySearchTree 
{
	private boolean checkBST(TreeNode r, long mx, long mn)
    {
        if(r==null){
            return true;
        }

        if(r.val >= mx || r.val <= mn){
            return false;
        }

        return checkBST(r.left, r.val, mn) && checkBST(r.right, mx, r.val);
    }
	
	public boolean isValidBST(TreeNode root) 
	{
        if(root==null){
            return true;
        }
        return checkBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		TreeNode node2 = new TreeNode(sc.nextInt());
		TreeNode node1 = new TreeNode(sc.nextInt());
		TreeNode root = new TreeNode(sc.nextInt(),node1,node2);
		sc.close();
		ValidateBinarySearchTree Res = new ValidateBinarySearchTree();
		System.out.print(Res.isValidBST(root));
	}
}
