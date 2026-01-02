import java.util.Arrays;
import java.util.Scanner;

//3381. Maximum Subarray Sum With Length Divisible by K (Medium)
//--------------------------------------------------------------
//You are given an array of integers nums and an integer k.
//Return the maximum sum of a subarray of nums, such that the size of the subarray is divisible by k.
//
//Constraints:
//-----------
//1 <= k <= nums.length <= 2 * 10^5
//-10^9 <= nums[i] <= 10^9

public class MaximumSubarraySumWithLengthDivisibleByK 
{
	public long maxSubarraySum(int[] nums, int k)
	{
		int n = nums.length;
		long[] minSoFar = new long[k];
		Arrays.fill(minSoFar, Long.MAX_VALUE/2);
		minSoFar[k-1] = 0;
		long res = Long.MIN_VALUE, prefSum = 0;
		for(int i=0;i<n;i++) {
			prefSum += nums[i];
			res = Math.max(res, prefSum-minSoFar[i%k]);
			minSoFar[i%k] = Math.min(minSoFar[i%k], prefSum);
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
		int k = sc.nextInt();
		sc.close();
		MaximumSubarraySumWithLengthDivisibleByK Res = new MaximumSubarraySumWithLengthDivisibleByK();
		System.out.print(Res.maxSubarraySum(arr, k));
	}
}
