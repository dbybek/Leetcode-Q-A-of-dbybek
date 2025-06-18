import java.util.*;

//2616. Minimize the Maximum Difference of Pairs (Medium)
//-------------------------------------------------------
//You are given a 0-indexed integer array nums and an integer p.
//Find p pairs of indices of nums such that the maximum difference amongst all the pairs is minimized.
//Also, ensure no index appears more than once amongst the p pairs.
//Note that for a pair of elements at the index i and j,
//the difference of this pair is |nums[i] - nums[j]|, where |x| represents the absolute value of x.
//
//Return the minimum maximum difference among all p pairs. We define the maximum of an empty set to be zero.
//
//Constraints:
//-----------
//1 <= nums.length <= 10^5
//0 <= nums[i] <= 10^9
//0 <= p <= (nums.length)/2

public class MinimizeTheMaximumDifferenceOfPairs 
{
	public int minimizeMax(int[] nums, int p) 
	{
		if (p == 0) {
			return 0;
		}
		Arrays.sort(nums);
		int n = nums.length, left = 0, right = nums[n-1]-nums[0];
		while(left < right) {
			int mid = left + (right - left)/2, pairs = 0;
			for(int i=1;i<n;i++) {
				if(nums[i]-nums[i-1] <= mid) {
					pairs++;
					i++;
				}
			}
			if(pairs >= p) {
				right = mid;
			}
			else {
				left = mid+1;
			}
		}
		return left;
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
		MinimizeTheMaximumDifferenceOfPairs Res = new MinimizeTheMaximumDifferenceOfPairs();
		System.out.print(Res.minimizeMax(arr, k));
	}

}
