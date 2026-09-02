import java.util.Scanner;

//2265. Count Nodes Equal to Average of Subtree (Medium)
//------------------------------------------------------
//Given the root of a binary tree,
//return the number of nodes where the value of the node is equal to the average of the values in its subtree.
//Note:
//
//The average of n elements is the sum of the n elements divided by n and rounded down to the nearest integer.
//A subtree of root is a tree consisting of root and all of its descendants.
//
//Constraints:
//-----------
//The number of nodes in the tree is in the range [1, 1000].
//0 <= Node.val <= 1000

public class CountNodesEqualToAverageOfSubtree 
{
	int res = 0;
    private int[] dfs(TreeNode node)
    {
        if(node==null){
            return new int[]{0, 0};
        }
        int[] leftSum = dfs(node.left), rightSum = dfs(node.right);
        if((leftSum[0]+rightSum[0]+node.val)/(leftSum[1]+rightSum[1]+1) == node.val){
            res++;
        }
        return new int[]{leftSum[0]+rightSum[0]+node.val, leftSum[1]+rightSum[1]+1};
    }
    
	public int averageOfSubtree(TreeNode root)
	{
		dfs(root);
        return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		TreeNode node5 = new TreeNode(sc.nextInt());
		TreeNode node4 = new TreeNode(sc.nextInt());
		TreeNode node3 = new TreeNode(sc.nextInt());
		TreeNode node2 = new TreeNode(sc.nextInt(), null, node5);
		TreeNode node1 = new TreeNode(sc.nextInt(), node3, node4);
		TreeNode root = new TreeNode(sc.nextInt(), node1, node2);
		sc.close();
		CountNodesEqualToAverageOfSubtree Res = new CountNodesEqualToAverageOfSubtree();
		System.out.print(Res.averageOfSubtree(root));
	}
}
