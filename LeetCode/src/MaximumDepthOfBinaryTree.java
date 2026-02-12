import java.util.Scanner;

//104. Maximum Depth of Binary Tree (Easy)
//----------------------------------------
//Given the root of a binary tree, return its maximum depth.
//
//A binary tree's maximum depth is the number of nodes along the longest path
//from the root node down to the farthest leaf node.
//
//Constraints:
//-----------
//The number of nodes in the tree is in the range [0, 10^4].
//-100 <= Node.val <= 100


public class MaximumDepthOfBinaryTree 
{
	public int maxDepth(TreeNode root)
	{
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		TreeNode root = null;
		sc.close();
		MaximumDepthOfBinaryTree Res = new MaximumDepthOfBinaryTree();
		System.out.print(Res.maxDepth(root));
	}
}
