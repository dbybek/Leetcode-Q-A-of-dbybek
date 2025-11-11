import java.util.Scanner;

//1526. Minimum Number of Increments on Subarrays to Form a Target Array (Hard)
//-----------------------------------------------------------------------------
//You are given an integer array target.
//You have an integer array initial of the same size as target with all elements initially zeros.
//In one operation you can choose any subarray from initial and increment each value by one.
//
//Return the minimum number of operations to form a target array from initial.
//
//The test cases are generated so that the answer fits in a 32-bit integer.
//
//Constraints:
//-----------
//1 <= target.length <= 10^5
//1 <= target[i] <= 10^5


public class MinimumNumberOfIncrementsOnSubarraysToFormATargetArray 
{
	public int minNumberOperations(int[] target)
	{
//		Approach I: If we traverse from left to right while keeping track of how much increament is required for each value
//		            only when the value is target[i] > taregt[i-1], then we would get all the extra subarrays needed for the
//		            higher values without increasing the efforts for the lower values which have already reached target.
//		--------------------------------------------------------------------------------------------------------------------
		int res = target[0], n = target.length;
		for(int i=1;i<n;i++) {
			if(target[i]>target[i-1]) {
				res+=target[i]-target[i-1];
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
		MinimumNumberOfIncrementsOnSubarraysToFormATargetArray Res = new MinimumNumberOfIncrementsOnSubarraysToFormATargetArray();
		System.out.print(Res.minNumberOperations(arr));
	}
}
