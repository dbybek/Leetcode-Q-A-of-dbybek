import java.util.Scanner;

//3689. Maximum Total Subarray Value I (Medium)
//---------------------------------------------
//You are given an integer array nums of length n and an integer k.
//You need to choose exactly k non-empty subarrays nums[l..r] of nums.
//Subarrays may overlap, and the exact same subarray (same l and r) can be chosen more than once.
//The value of a subarray nums[l..r] is defined as: max(nums[l..r]) - min(nums[l..r]).
//The total value is the sum of the values of all chosen subarrays.
//Return the maximum possible total value you can achieve.
//
//Constraints:
//-----------
//1 <= n == nums.length <= 5 * 10^​​​​​​​4
//0 <= nums[i] <= 10^9
//1 <= k <= 10^5

public class MaximumTotalSubarrayValueI 
{
	public long maxTotalValue(int[] nums, int k)
	{
		int mx = -1, mn = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            mx = Math.max(nums[i],mx);
            mn = Math.min(nums[i],mn);
        }
        return (long)(mx-mn)*k;
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
		MaximumTotalSubarrayValueI Res = new MaximumTotalSubarrayValueI();
		System.out.print(Res.maxTotalValue(arr, k));
	}
}
