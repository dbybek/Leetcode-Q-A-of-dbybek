import java.util.*;

//2196. Create Binary Tree From Descriptions(Medium)
//--------------------------------------------------
//You are given a 2D integer array descriptions where descriptions[i] = [parenti, childi, isLefti]
//indicates that parenti is the parent of childi in a binary tree of unique values. Furthermore,
//If isLefti == 1, then childi is the left child of parenti.
//If isLefti == 0, then childi is the right child of parenti.
//Construct the binary tree described by descriptions and return its root.
//
//The test cases will be generated such that the binary tree is valid.
//
//Constraints:
//-----------
//1 <= descriptions.length <= 10^4
//descriptions[i].length == 3
//1 <= parenti, childi <= 10^5
//0 <= isLefti <= 1
//The binary tree described by descriptions is valid.

public class CreateBinaryTreeFromDescriptions 
{
	public TreeNode createBinaryTree(int[][] descriptions)
	{
		HashMap<Integer,TreeNode> hm = new HashMap<>();
        TreeNode temp = null;
        for(int i=0;i<descriptions.length;i++){
            if(!hm.containsKey(descriptions[i][0])){
                hm.put(descriptions[i][0], new TreeNode(descriptions[i][0]));
            }
            if(!hm.containsKey(descriptions[i][1])){
                temp = new TreeNode(descriptions[i][1]);
                hm.put(descriptions[i][1],temp);
            }
            else{
                temp = hm.get(descriptions[i][1]);
            }
            if(descriptions[i][2]==1){
                hm.get(descriptions[i][0]).left = temp;
            }
            else{
                hm.get(descriptions[i][0]).right = temp;
            }
        }
        for(int i=0;i<descriptions.length;i++){
            if(hm.containsKey(descriptions[i][1])){
                hm.put(descriptions[i][1],null);
            }
        }
        TreeNode root = null;
        for(Integer ele:hm.keySet()){
            if(hm.get(ele)!=null){
                root = hm.get(ele);
                break;
            }
        }
        return root;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][3];
		for(int i=0;i<N;i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			arr[i][2] = sc.nextInt();
		}
		sc.close();
		CreateBinaryTreeFromDescriptions Res = new CreateBinaryTreeFromDescriptions();
		TreeNode Root = Res.createBinaryTree(arr);
		System.out.print(Root);
	}
}
