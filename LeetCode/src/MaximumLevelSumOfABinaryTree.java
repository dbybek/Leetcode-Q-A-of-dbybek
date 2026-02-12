import java.util.*;

//1161. Maximum Level Sum of a Binary Tree(Medium)
//------------------------------------------------
//Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
//Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
//
//Constraints:
//-----------
//The number of nodes in the tree is in the range [1, 10^4].
//-10^5 <= Node.val <= 10^5

public class MaximumLevelSumOfABinaryTree 
{
	public int maxLevelSum(TreeNode root)
	{
		int res = 0, lvl = 1, mx = Integer.MIN_VALUE;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int sum = 0, size = q.size();
            for(int i=0;i<size;i++){
                TreeNode currNode = q.poll();
                sum+=currNode.val;
                if(currNode.left!=null){
                    q.offer(currNode.left);
                }
                if(currNode.right!=null){
                    q.offer(currNode.right);
                }
            }
            if(mx<sum){
                mx = sum;
                res = lvl;
            }
            lvl++;
        }
        return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		TreeNode node4 = new TreeNode(sc.nextInt());
		TreeNode node3 = new TreeNode(sc.nextInt());
		TreeNode node2 = new TreeNode(sc.nextInt());
		TreeNode node1 = new TreeNode(sc.nextInt(),node3,node4);
		TreeNode root = new TreeNode(sc.nextInt(),node1,node2);
		sc.close();
		MaximumLevelSumOfABinaryTree Res = new MaximumLevelSumOfABinaryTree();
		System.out.print(Res.maxLevelSum(root));
	}
}
