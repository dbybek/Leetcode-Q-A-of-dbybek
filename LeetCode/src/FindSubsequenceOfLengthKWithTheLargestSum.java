import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//2099. Find Subsequence of Length K With the Largest Sum (Easy)
//--------------------------------------------------------------
//You are given an integer array nums and an integer k.
//You want to find a subsequence of nums of length k that has the largest sum.
//
//Return any such subsequence as an integer array of length k.
//
//A subsequence is an array that can be derived from another array by deleting some or
//no elements without changing the order of the remaining elements.
//
//Constraints:
//-----------
//1 <= nums.length <= 1000
//-10^5 <= nums[i] <= 10^5
//1 <= k <= nums.length

public class FindSubsequenceOfLengthKWithTheLargestSum 
{
	public int[] maxSubsequence(int[] nums, int k)
	{
		int n = nums.length;
		int[][] indexNValue = new int[n][2];
		for(int i=0;i<n;i++) {
			indexNValue[i][0] = nums[i];
			indexNValue[i][1] = i;
		}
		
		Arrays.sort(indexNValue, (a,b) -> b[0]-a[0]);
		Arrays.sort(indexNValue, 0, k, Comparator.comparingInt(a->a[1]));
		
		int[] res = new int[k];
		for(int i=0;i<k;i++) {
			res[i] = indexNValue[i][0];
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
		int K = sc.nextInt();
		sc.close();
		FindSubsequenceOfLengthKWithTheLargestSum Res = new FindSubsequenceOfLengthKWithTheLargestSum();
		int[] arr1 = Res.maxSubsequence(arr, K);
		for(int ele:arr1) {
			System.out.print(ele+" ");
		}
	}

}
