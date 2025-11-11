import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//3350. Adjacent Increasing Subarrays Detection II (Medium)
//---------------------------------------------------------
//Given an array nums of n integers,
//your task is to find the maximum value of k for which there exist two adjacent subarrays of length k each,
//such that both subarrays are strictly increasing.
//Specifically, check if there are two subarrays of length k starting at indices a and b (a < b), where:
//Both subarrays nums[a..a + k - 1] and nums[b..b + k - 1] are strictly increasing.
//The subarrays must be adjacent, meaning b = a + k.
//Return the maximum possible value of k.
//
//A subarray is a contiguous non-empty sequence of elements within an array.
//
//Constraints:
//-----------
//2 <= nums.length <= 2 * 10^5
//-10^9 <= nums[i] <= 10^9

public class AdjacentIncreasingSubarraysDetectionII 
{
	public int maxIncreasingSubarrays(List<Integer> nums)
	{
		int pre = 0, suf = 1, res = 0, n = nums.size();
		for(int i=1;i<n;i++) {
			if(nums.get(i)>nums.get(i-1)) {
				suf++;
			}
			else {
				pre = suf;
				suf = 1;
			}
			res = Math.max(res, Math.max(suf/2, Math.min(pre, suf)));
		}
		return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Integer> lst = new ArrayList<>();
		for(int i=0;i<N;i++) {
			lst.add(sc.nextInt());
		}
		sc.close();
		AdjacentIncreasingSubarraysDetectionII Res = new AdjacentIncreasingSubarraysDetectionII();
		System.out.print(Res.maxIncreasingSubarrays(lst));
	}
}
