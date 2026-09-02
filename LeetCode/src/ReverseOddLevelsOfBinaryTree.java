import java.util.Scanner;

//2415. Reverse Odd Levels of Binary Tree (Medium)
//------------------------------------------------
//Given the root of a perfect binary tree, reverse the node values at each odd level of the tree.
//For example, suppose the node values at level 3 are [2,1,3,4,7,11,29,18], then it should become [18,29,11,7,4,3,1,2].
//Return the root of the reversed tree.
//A binary tree is perfect if all parent nodes have two children and all leaves are on the same level.
//
//The level of a node is the number of edges along the path between it and the root node.
//
//Constraints:
//-----------
//The number of nodes in the tree is in the range [1, 2^14].
//0 <= Node.val <= 10^5
//root is a perfect binary tree.

public class ReverseOddLevelsOfBinaryTree 
{
	private void reverseOddLevel(TreeNode n1, TreeNode n2, int lvl)
	{
		if(n1==null || n2==null) {
			return;
		}
		
		if(lvl%2==0) {
			int temp = n1.val;
			n1.val = n2.val;
			n2.val = temp;
		}
		
		reverseOddLevel(n1.left, n2.right, lvl+1);
		reverseOddLevel(n1.right, n2.left, lvl+1);
	}
	
	public TreeNode reverseOddLevels(TreeNode root)
	{
		reverseOddLevel(root.left, root.right, 0);
		return root;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		TreeNode node6 = new TreeNode(sc.nextInt());
		TreeNode node5 = new TreeNode(sc.nextInt());
		TreeNode node4 = new TreeNode(sc.nextInt());
		TreeNode node3 = new TreeNode(sc.nextInt());
		TreeNode node2 = new TreeNode(sc.nextInt(), node5, node6);
		TreeNode node1 = new TreeNode(sc.nextInt(), node3, node4);
		TreeNode root = new TreeNode(sc.nextInt(),node1,node2);
		sc.close();
		ReverseOddLevelsOfBinaryTree Res = new ReverseOddLevelsOfBinaryTree();
		System.out.print(Res.reverseOddLevels(root).val);		
	}
}
