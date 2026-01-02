import java.util.Scanner;

//938. Range Sum of BST(Easy)
//---------------------------
//Given the root node of a binary search tree and two integers low and high,
//return the sum of values of all nodes with a value in the inclusive range [low, high].
//
//Constraints:
//-----------
//The number of nodes in the tree is in the range [1, 2 * 10^4].
//1 <= Node.val <= 10^5
//1 <= low <= high <= 10^5
//All Node.val are unique.

public class RangeSumOfBST 
{
	public int rangeSumBST(TreeNode root, int low, int high)
	{
		if(root==null){
            return 0;
        }
        int res = 0;
        if(low <= root.val && root.val <= high){
            res = root.val + rangeSumBST(root.left,low,high) + rangeSumBST(root.right,low,high);
        }
        else if(root.val < low){
            res = rangeSumBST(root.right,low,high);
        }
        else{
            res = rangeSumBST(root.left,low,high);
        }
        return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		TreeNode node5 = new TreeNode(sc.nextInt(), null, null);
		TreeNode node4 = new TreeNode(sc.nextInt(), null, null);
		TreeNode node3 = new TreeNode(sc.nextInt(), null, null);
		TreeNode node2 = new TreeNode(sc.nextInt(),null,node5);
		TreeNode node1 = new TreeNode(sc.nextInt(),node3,node4);
		TreeNode root = new TreeNode(sc.nextInt(),node1,node2);
		int l = sc.nextInt(), h = sc.nextInt();
		sc.close();
		RangeSumOfBST Res = new RangeSumOfBST();
		System.out.print(Res.rangeSumBST(root, l, h));
	}
}
