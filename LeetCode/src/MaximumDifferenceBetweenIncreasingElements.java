import java.util.Scanner;

//2016. Maximum Difference Between Increasing Elements (Easy)
//-----------------------------------------------------------
//Given a 0-indexed integer array nums of size n,
//find the maximum difference between nums[i] and nums[j] (i.e., nums[j] - nums[i]), such that 0 <= i < j < n and
//nums[i] < nums[j].
//Return the maximum difference. If no such i and j exists, return -1.
//
//Constraints:
//-----------
//n == nums.length
//2 <= n <= 1000
//1 <= nums[i] <= 10^9

public class MaximumDifferenceBetweenIncreasingElements 
{

	public int maximumDifference(int[] nums)
	{
		int res = -1, n = nums.length, mn = Integer.MAX_VALUE;
		for(int i=0;i<n-1;i++) {
			if(nums[i]<nums[i+1]) {
				mn = Math.min(mn, nums[i]);
				res = Math.max(res, nums[i+1]-mn);
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
		sc.close();
		MaximumDifferenceBetweenIncreasingElements Res = new MaximumDifferenceBetweenIncreasingElements();
		System.out.print(Res.maximumDifference(arr));
	}

}
