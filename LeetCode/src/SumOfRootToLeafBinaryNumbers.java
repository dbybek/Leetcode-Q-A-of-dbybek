import java.util.Scanner;

//1022. Sum of Root To Leaf Binary Numbers (Easy)
//-----------------------------------------------
//You are given the root of a binary tree where each node has a value 0 or 1.
//Each root-to-leaf path represents a binary number starting with the most significant bit.
//For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
//For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
//Return the sum of these numbers.
//
//The test cases are generated so that the answer fits in a 32-bits integer.
//
//Constraints:
//-----------
//The number of nodes in the tree is in the range [1, 1000].
//Node.val is 0 or 1.

public class SumOfRootToLeafBinaryNumbers
{
	private int dfs(TreeNode node, int v)
    {
        if(node==null){
            return 0;
        }
        v = v*2 + node.val;
        if(node.left==null && node.right==null){
            return v;
        }
        return dfs(node.left,v) + dfs(node.right,v);
    }

    public int sumRootToLeaf(TreeNode root) 
    {
        return dfs(root,0);
    }
    
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		TreeNode node6 = new TreeNode(sc.nextInt());
		TreeNode node5 = new TreeNode(sc.nextInt());
		TreeNode node4 = new TreeNode(sc.nextInt());
		TreeNode node3 = new TreeNode(sc.nextInt());
		TreeNode node2 = new TreeNode(sc.nextInt(),node5,node6);
		TreeNode node1 = new TreeNode(sc.nextInt(),node3,node4);
		TreeNode root = new TreeNode(sc.nextInt(),node1,node2);
		sc.close();
		SumOfRootToLeafBinaryNumbers Res = new SumOfRootToLeafBinaryNumbers();
		System.out.print(Res.sumRootToLeaf(root));
	}
}
