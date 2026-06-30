import java.util.Scanner;

//2770. Maximum Number of Jumps to Reach the Last Index (Medium)
//--------------------------------------------------------------
//You are given a 0-indexed array nums of n integers and an integer target.
//You are initially positioned at index 0. In one step, you can jump from index i to any index j such that:
//
//0 <= i < j < n
//-target <= nums[j] - nums[i] <= target
//Return the maximum number of jumps you can make to reach index n - 1.
//
//If there is no way to reach index n - 1, return -1.
//Constraints:
//-----------
//2 <= nums.length == n <= 1000
//-10^9 <= nums[i] <= 10^9
//0 <= target <= 2 * 10^9

public class MaximumNumberOfJumpsToReachTheLastIndex 
{
	public int maximumJumps(int[] nums, int target)
	{
		int n = nums.length;
		int[]dp = new int[n];
		for(int i=1;i<n;i++) {
			dp[i] = -1;
			for(int j=0;j<i;j++) {
				if(dp[i]>=0 && (-1*target)<=(nums[i]-nums[j]) && (nums[i]-nums[j])<=target) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		return dp[n-1];
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
		int k = sc.nextInt();
		sc.close();
		MaximumNumberOfJumpsToReachTheLastIndex Res = new MaximumNumberOfJumpsToReachTheLastIndex();
		System.out.println(Res.maximumJumps(arr, k));
	}
}
