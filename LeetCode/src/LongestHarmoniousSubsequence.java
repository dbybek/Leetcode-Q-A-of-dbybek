import java.util.*;

//594. Longest Harmonious Subsequence(Easy)
//-----------------------------------------
//We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.
//Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.
//
//Constraints:
//-----------
//1 <= nums.length <= 2 * 10^4
//-10^9 <= nums[i] <= 10^9

public class LongestHarmoniousSubsequence 
{
	public int findLHS(int[] nums)
	{
		int mx = Integer.MIN_VALUE, mn = Integer.MAX_VALUE;
		for(int ele:nums) {
			mx = Math.max(mx, ele);
			mn = Math.min(mn, ele);
		}
		int n = mx-mn+1;
		if(n > 100000) return findLHSUsingMap(nums);
		int[] freq = new int[n];
		for(int ele:nums) {
			freq[ele-mn]++;
		}
		int res = 0;
		for(int i=1;i<n;i++) {
			if(freq[i]!=0 && freq[i-1]!=0) {
				res = Math.max(res, freq[i]+freq[i-1]);
			}
		}
		return res;
	}
	
	private int findLHSUsingMap(int[] nums)
	{
		HashMap<Integer,Integer> hm = new HashMap<>();
		for(int ele:nums) {
			hm.put(ele, hm.getOrDefault(ele, 0)+1);
		}
		int res = 0;
		for(int ele:nums) {
			if(hm.containsKey(ele+1)) {
				res = Math.max(res, hm.get(ele)+hm.get(ele+1));
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
		LongestHarmoniousSubsequence Res = new LongestHarmoniousSubsequence();
		System.out.print(Res.findLHS(arr));
	}

}
