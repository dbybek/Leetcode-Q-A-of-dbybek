import java.util.Scanner;

//1306. Jump Game III (Medium)
//----------------------------
//Given an array of non-negative integers arr, you are initially positioned at start index of the array.
//When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach any index with value 0.
//Notice that you can not jump outside of the array at any time.
//Constraints:
//-----------
//n == nums.length
//1 <= n <= 5000
//-5000 <= nums[i] <= 5000
//nums is sorted and rotated between 1 and n times.

public class JumpGameIII 
{
	private boolean dfs(int[] arr, int ind, int n, boolean[] visited)
	{
        if(ind<0 || ind>=n || visited[ind]){
            return false;
        }
        if(arr[ind]==0){
            return true;
        }
        visited[ind] = true;
        return dfs(arr,ind+arr[ind],n,visited)||dfs(arr,ind-arr[ind],n,visited);
    }
	
	public boolean canReach(int[] arr, int start)
	{
		boolean[] visited = new boolean[arr.length];
        return dfs(arr,start,arr.length,visited);
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
		int s = sc.nextInt();
		sc.close();
		JumpGameIII Res = new JumpGameIII();
		System.out.print(Res.canReach(arr, s));
	}
}
