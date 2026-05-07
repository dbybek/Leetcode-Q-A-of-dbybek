import java.util.Scanner;

//198. House Robber (Medium)
//--------------------------
//You are a professional robber planning to rob houses along a street.
//Each house has a certain amount of money stashed,
//the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and
//it will automatically contact the police if two adjacent houses were broken into on the same night.
//Given an integer array nums representing the amount of money of each house,
//return the maximum amount of money you can rob tonight without alerting the police.
//
//Constraints:
//-----------
//1 <= nums.length <= 100
//0 <= nums[i] <= 400

public class HouseRobber 
{
	public int rob(int[] nums)
	{
//		Approach I: DP. TC: O(N), SC: O(N)
//		----------------------------------
//		int n = nums.length;
//        if(n==1){
//            return nums[0];
//        }
//        int[] dp = new int[n];
//        dp[0] = nums[0];
//        dp[1] = Math.max(nums[0], nums[1]);
//        for(int i=2;i<n;i++){
//            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
//        }
//        return dp[n-1];
//        
//		Approach II: Just maths no need for the extra array to store the sum. TC: O(N), SC: O(1)
//		----------------------------------------------------------------------------------------
		int res = 0, prev = 0, temp = 0;
		for(int i=0;i<nums.length;i++) {
			temp = Math.max(res, prev+nums[i]);
			prev = res;
			res = temp;
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
		sc.close();
		HouseRobber Res = new HouseRobber();
		System.out.print(Res.rob(arr));
	}
}
