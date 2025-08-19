import java.util.Scanner;

//2044. Count Number of Maximum Bitwise-OR Subsets (Medium)
//---------------------------------------------------------
//Given an integer array nums, find the maximum possible bitwise OR of a subset of nums and
//return the number of different non-empty subsets with the maximum bitwise OR.
//
//An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b.
//Two subsets are considered different if the indices of the elements chosen are different.
//
//The bitwise OR of an array a is equal to a[0] OR a[1] OR ... OR a[a.length - 1] (0-indexed).
//
//Constraints:
//-----------
//1 <= nums.length <= 16
//1 <= nums[i] <= 10^5

public class CountNumberOfMaximumBitwiseORSubsets 
{
	private int countSubsets(int[] num, int mx, int ind, int currOr)
	{
		if(ind==num.length) {
			return currOr==mx?1:0;
		}
		int include = countSubsets(num,mx,ind+1,currOr|num[ind]);
		int exclude = countSubsets(num,mx,ind+1,currOr);
		return include+exclude;
	}
	
	public int countMaxOrSubsets(int[] nums)
	{
		int mxOr = 0;
		for(int ele:nums) {
			mxOr |= ele;
		}
		return countSubsets(nums,mxOr,0,0);
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
		CountNumberOfMaximumBitwiseORSubsets Res = new CountNumberOfMaximumBitwiseORSubsets();
		System.out.print(Res.countMaxOrSubsets(arr));
	}
}
