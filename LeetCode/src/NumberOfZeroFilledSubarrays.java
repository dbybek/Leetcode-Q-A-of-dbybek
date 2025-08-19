import java.util.Scanner;

//2348. Number of Zero-Filled Subarrays (Medium)
//----------------------------------------------
//Given an integer array nums, return the number of subarrays filled with 0.
//A subarray is a contiguous non-empty sequence of elements within an array.
//
//Constraints:
//-----------
//1 <= nums.length <= 10^5
//-10^9 <= nums[i] <= 10^9

public class NumberOfZeroFilledSubarrays 
{
	public long zeroFilledSubarray(int[] nums)
	{
		int count = 0;
		long res = 0;
		for(int ele:nums) {
			if(ele==0) {
				count++;
			}
			else {
				count = 0;
			}
			res += count;
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
		NumberOfZeroFilledSubarrays Res = new NumberOfZeroFilledSubarrays();
		System.out.print(Res);
	}
}
