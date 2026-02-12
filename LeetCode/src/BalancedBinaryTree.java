import java.util.Scanner;

//110. Balanced Binary Tree (Easy)
//--------------------------------
//Given a binary tree, determine if it is height-balanced.
//
//A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never
//differs by more than one.
//
//Constraints:
//-----------
//The number of nodes in the tree is in the range [0, 5000].
//-10^4 <= Node.val <= 10^4

public class BalancedBinaryTree 
{
	private int height(TreeNode node)
    {
        if(node==null){
            return 0;
        }
        int l = height(node.left);
        if(l==-1){
            return -1;
        }
        int r = height(node.right);
        if(r==-1){
            return -1;
        }
        if(Math.abs(l-r)>1){
            return -1;
        }
        return 1+Math.max(l,r);
    }
	
    public boolean isBalanced(TreeNode root) 
    {
        return height(root)!=-1;
    }
    
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		TreeNode root = null;
		sc.close();
		BalancedBinaryTree Res = new BalancedBinaryTree();
		System.out.print(Res.isBalanced(root));
	}
}
