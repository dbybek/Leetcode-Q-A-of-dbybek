import java.util.HashMap;
import java.util.Scanner;

//2958. Length of Longest Subarray With at Most K Frequency (Medium)
//------------------------------------------------------------------
//You are given an integer array nums and an integer k.
//The frequency of an element x is the number of times it occurs in an array.
//An array is called good if the frequency of each element in this array is less than or equal to k.
//Return the length of the longest good subarray of nums.
//A subarray is a contiguous non-empty sequence of elements within an array.
//
//Constraints:
//-----------
//1 <= nums.length <= 50
//1 <= nums[i] <= 50

public class LengthOfLongestSubarrayWithAtMostKFrequency 
{
	public int maxSubarrayLength(int[] nums, int k)
	{
		HashMap<Integer, Integer> hm = new HashMap<>();
        int res = 0, s = 0;
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
            while(hm.get(nums[i])>k){
                hm.put(nums[s], hm.get(nums[s])-1);
                s++;
            }
            res = Math.max(res, i-s+1);
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
		int k = sc.nextInt();
		sc.close();
		LengthOfLongestSubarrayWithAtMostKFrequency Res = new LengthOfLongestSubarrayWithAtMostKFrequency();
		System.out.print(Res.maxSubarrayLength(arr, k));
	}
}
