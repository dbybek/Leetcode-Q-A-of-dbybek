import java.util.Scanner;

//114. Flatten Binary Tree to Linked List (Medium)
//------------------------------------------------
//Given the root of a binary tree, flatten the tree into a "linked list":
//The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list
//and the left child pointer is always null.
//The "linked list" should be in the same order as a pre-order traversal of the binary tree.
//
//Constraints:
//-----------
//m == grid.length
//n == grid[i].length
//1 <= m, n <= 500
//grid consists only of lowercase English letters.

public class FlattenBinaryTreeToLinkedList 
{
	public void flatten(TreeNode root)
	{
		TreeNode currNode = root;
        while(currNode!=null){
            if(currNode.left!=null){
                TreeNode prevNode = currNode.left;
                while(prevNode.right!=null){
                    prevNode = prevNode.right;
                }
                prevNode.right = currNode.right;
                currNode.right = currNode.left;
                currNode.left = null;
            }
            currNode = currNode.right;
        }
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
		FlattenBinaryTreeToLinkedList Res = new FlattenBinaryTreeToLinkedList();
		Res.flatten(root);
		TreeNode temp = root;
		while(temp!=null) {
			System.out.print(temp.val+" ");
			temp = temp.right;
		}
	}
}
