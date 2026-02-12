import java.util.*;

//1382. Balance a Binary Search Tree (Medium)
//-------------------------------------------
//Given the root of a binary search tree, return a balanced binary search tree with the same node values.
//If there is more than one answer, return any of them.
//A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.
//
//Constraints:
//-----------
//The number of nodes in the tree is in the range [1, 10^4].
//1 <= Node.val <= 10^5

public class BalanceABinarySearchTree 
{
	private void inOrder(TreeNode node, List<Integer> lst)
    {
        if(node==null){
            return;
        }
        inOrder(node.left,lst);
        lst.add(node.val);
        inOrder(node.right,lst);
    }
	
	private TreeNode balance(List<Integer> lst, int l, int r)
    {
        if(l>r){
            return null;
        }
        int m = (l+r)/2;
        TreeNode res = new TreeNode(lst.get(m));
        res.left = balance(lst,l,m-1);
        res.right = balance(lst,m+1,r);
        return res;
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        inOrder(root,lst);
        return balance(lst, 0, lst.size()-1);
    }
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		TreeNode root = null;
		sc.close();
		BalanceABinarySearchTree Res = new BalanceABinarySearchTree();
		System.out.print(Res.balanceBST(root));
	}
}
