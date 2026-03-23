import java.util.Scanner;

//101. Symmetric Tree (Easy)
//--------------------------
//Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
//
//Constraints:
//-----------
//The number of nodes in the tree is in the range [1, 1000].
//-100 <= Node.val <= 100

public class SymmetricTree 
{
	private boolean isMirror(TreeNode leftNode, TreeNode rightNode) {
        if(leftNode==null && rightNode==null){
            return true;
        }

        if(leftNode==null || rightNode==null) {
            return false;
        }

        if (leftNode.val != rightNode.val){
            return false;
        }

        return isMirror(leftNode.left, rightNode.right) && isMirror(leftNode.right, rightNode.left);
    }
	
	public boolean isSymmetric(TreeNode root)
	{
		return isMirror(root.left, root.right);
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
		TreeNode root = new TreeNode(sc.nextInt(), node1, node2);
		sc.close();
		SymmetricTree Res = new SymmetricTree();
		System.out.print(Res.isSymmetric(root));
	}
}
