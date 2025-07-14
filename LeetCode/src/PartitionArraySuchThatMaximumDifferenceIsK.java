import java.util.Scanner;

//2294. Partition Array Such That Maximum Difference Is K (Medium)
//----------------------------------------------------------------
//You are given an integer array nums and an integer k.
//You may partition nums into one or more subsequences such that 
//each element in nums appears in exactly one of the subsequences.
//
//Return the minimum number of subsequences needed such that the difference between the maximum and minimum values 
//in each subsequence is at most k.
//
//A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without
//changing the order of the remaining elements.
//
//Constraints:
//-----------
//1 <= nums.length <= 10^5
//0 <= nums[i] <= 10^5
//0 <= k <= 10^5

public class PartitionArraySuchThatMaximumDifferenceIsK 
{
	public int partitionArray(int[] nums, int k)
	{
		int mx = -1;
		for(int ele:nums) {
			mx = Math.max(ele, mx);
		}
		int[] freq = new int[mx+1];
		for(int ele:nums) {
			freq[ele]++;
		}
		int res = 1, max = -1, min = -1;
		for(int i=0;i<=mx;i++) {
			if(freq[i] > 0) {
				if(min == -1) {
					min = i;
					max = i;
				}
				else {
					max = i;
				}
				if(max-min > k) {
					res++;
					min = i;
				}
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
		int K = sc.nextInt();
		sc.close();
		PartitionArraySuchThatMaximumDifferenceIsK Res = new PartitionArraySuchThatMaximumDifferenceIsK();
		System.out.print(Res.partitionArray(arr, K));
	}

}
