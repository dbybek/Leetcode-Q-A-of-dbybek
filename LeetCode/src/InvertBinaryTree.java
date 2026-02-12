import java.util.Scanner;

//226. Invert Binary Tree (Easy)
//------------------------------
//Given the root of a binary tree, invert the tree, and return its root.
//
//Constraints:
//-----------
//The number of nodes in the tree is in the range [0, 100].
//-100 <= Node.val <= 100

public class InvertBinaryTree 
{
	private void invertTreeHelper(TreeNode node)
	{
        if(node==null){
            return;
        }
        invertTreeHelper(node.left);
        invertTreeHelper(node.right);
        if(node.left!=null || node.right!=null){
            TreeNode tempNode = node.left;
            node.left = node.right;
            node.right = tempNode;
        }
    }
	
	public TreeNode invertTree(TreeNode root) 
	{
//		Approach I: Recursive Approach after swapping. Takes more space.
//		----------------------------------------------------------------
//        if(root==null){
//             return null;
//        }
//        TreeNode temp = root.left;
//        root.left = root.right;
//        root.right = temp;
//
//        invertTree(root.left);
//        invertTree(root.right);
//        return root;
//		
//		Appraoch II: Recursive Approach before swapping. Better space complexity.
//		-------------------------------------------------------------------------
        if(root==null){
            return root;
        }
        invertTreeHelper(root);
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
		TreeNode node2 = new TreeNode(sc.nextInt(),node5,node6);
		TreeNode node1 = new TreeNode(sc.nextInt(),node3,node4);
		TreeNode root = new TreeNode(sc.nextInt(),node1,node2);
		sc.close();
		InvertBinaryTree Res = new InvertBinaryTree();
		TreeNode temp = Res.invertTree(root);
		System.out.print(temp);
	}
}
