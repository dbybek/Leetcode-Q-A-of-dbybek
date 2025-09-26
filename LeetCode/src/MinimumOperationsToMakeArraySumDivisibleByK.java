import java.util.Scanner;

//3512. Minimum Operations to Make Array Sum Divisible by K (Easy)
//----------------------------------------------------------------
//You are given an integer array nums and an integer k. You can perform the following operation any number of times:
//Select an index i and replace nums[i] with nums[i] - 1.
//Return the minimum number of operations required to make the sum of the array divisible by k.
//
//Constraints:
//-----------
//1 <= nums.length <= 1000
//1 <= nums[i] <= 1000
//1 <= k <= 100

public class MinimumOperationsToMakeArraySumDivisibleByK 
{
	public int minOperations(int[] nums, int k)
	{
		int sum = 0, n = nums.length;
		for(int i=0;i<n;i++) {
			sum+=nums[i];
		}
		return sum%k;
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
		int x = sc.nextInt();
		sc.close();
		MinimumOperationsToMakeArraySumDivisibleByK Res = new MinimumOperationsToMakeArraySumDivisibleByK();
		System.out.print(Res.minOperations(arr, x));
	}
}
