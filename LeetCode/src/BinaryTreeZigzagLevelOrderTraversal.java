import java.util.*;

//103. Binary Tree Zigzag Level Order Traversal(Medium)
//-----------------------------------------------------
//Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
//(i.e., from left to right, then right to left for the next level and alternate between).
//
//Constraints:
//-----------
//The number of nodes in the tree is in the range [0, 2000].
//-100 <= Node.val <= 100

public class BinaryTreeZigzagLevelOrderTraversal 
{
	public List<List<Integer>> zigzagLevelOrder(TreeNode root)
	{
		List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int ind = 0;
        while(!q.isEmpty()){
            int s = q.size();
            LinkedList<Integer> temp = new LinkedList<>();
            for(int i=0;i<s;i++){
                TreeNode currNode = q.poll();
                if(ind%2==0){
                    temp.add(currNode.val);
                }
                else{
                    temp.addFirst(currNode.val);
                }
                if(currNode.left!=null){
                    q.offer(currNode.left);
                }
                if(currNode.right!=null){
                    q.offer(currNode.right);
                }
            }
            ind++;
            res.add(new ArrayList<>(temp));
        }
        return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		TreeNode node4 = new TreeNode(sc.nextInt());
		TreeNode node3 = new TreeNode(sc.nextInt());
		TreeNode node2 = new TreeNode(sc.nextInt(),node3,node4);
		TreeNode node1 = new TreeNode(sc.nextInt());
		TreeNode root = new TreeNode(sc.nextInt(),node1,node2);
		sc.close();
		BinaryTreeZigzagLevelOrderTraversal Res = new BinaryTreeZigzagLevelOrderTraversal();
		List<List<Integer>> lst = Res.zigzagLevelOrder(root);
		for(List<Integer> l:lst) {
			for(int ele:l) {
				System.out.print(ele+" ");
			}
			System.out.println();
		}
	}
}
