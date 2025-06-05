import java.util.Scanner;

//1298. Maximum Candies You Can Get from Boxes (Hard)
//---------------------------------------------------
//You have n boxes labeled from 0 to n - 1. You are given four arrays: status, candies, keys, and containedBoxes where:
//
//status[i] is 1 if the ith box is open and 0 if the ith box is closed,
//candies[i] is the number of candies in the ith box,
//keys[i] is a list of the labels of the boxes you can open after opening the ith box.
//containedBoxes[i] is a list of the boxes you found inside the ith box.
//You are given an integer array initialBoxes that contains the labels of the boxes you initially have.
//You can take all the candies in any open box and you can use the keys in it to open new boxes and
//you also can use the boxes you find in it.
//
//Return the maximum number of candies you can get following the rules above.
//
//Constraints:
//-----------
//n == status.length == candies.length == keys.length == containedBoxes.length
//1 <= n <= 1000
//status[i] is either 0 or 1.
//1 <= candies[i] <= 1000
//0 <= keys[i].length <= n
//0 <= keys[i][j] < n
//All values of keys[i] are unique.
//0 <= containedBoxes[i].length <= n
//0 <= containedBoxes[i][j] < n
//All values of containedBoxes[i] are unique.
//Each box is contained in one box at most.
//0 <= initialBoxes.length <= n
//0 <= initialBoxes[i] < n

public class MaximumCandiesYouCanGetFromBoxes 
{
	public void dfs(int box,int[] status, int[][] keys, int[][] containedBoxes, boolean[] visited) 
	{
		visited[box] = true;
		for(int key:keys[box]) {
			if(key==box) {
				continue;
			}
			status[key] = 1;
		}
		
		for(int containedBox:containedBoxes[box]) {
			if(!visited[containedBox]) {
				dfs(containedBox,status,keys,containedBoxes,visited);
			}
		}
	}

	public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) 
	{
        int res = 0, n = status.length;
        boolean[] visited = new boolean[n];
        for(int ele:initialBoxes) {
        	dfs(ele,status,keys,containedBoxes,visited);
        }
        for(int i=0;i<n;i++) {
        	if(visited[i] && status[i]==1) {
        		res += candies[i];
        	}
        }
        return res;
    }
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		int[] arr1 = new int[N];
		for(int i=0;i<N;i++) {
			arr1[i] = sc.nextInt();
		}
		int[][] arr2 = new int[N][];
		for(int i=0;i<N;i++) {
			int M = sc.nextInt();
			for(int j=0;j<M;j++) {
				arr2[i][j] = sc.nextInt();
			}
		}
		int[][] arr3 = new int[N][];
		for(int i=0;i<N;i++) {
			int M = sc.nextInt();
			for(int j=0;j<M;j++) {
				arr3[i][j] = sc.nextInt();
			}
		}
		int M = sc.nextInt();
		int[] arr4 = new int[M];
		for(int i=0;i<M;i++) {
			arr4[i] = sc.nextInt();
		}
		sc.close();
		MaximumCandiesYouCanGetFromBoxes Res = new MaximumCandiesYouCanGetFromBoxes();
		System.out.print(Res.maxCandies(arr, arr1, arr2, arr3, arr4));
	}

}
