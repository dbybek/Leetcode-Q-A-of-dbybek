import java.util.Scanner;

//2419. Longest Subarray With Maximum Bitwise AND (Medium)
//--------------------------------------------------------
//You are given an integer array nums of size n.
//Consider a non-empty subarray from nums that has the maximum possible bitwise AND.
//In other words, let k be the maximum value of the bitwise AND of any subarray of nums.
//Then, only subarrays with a bitwise AND equal to k should be considered.
//Return the length of the longest such subarray.
//The bitwise AND of an array is the bitwise AND of all the numbers in it.
//A subarray is a contiguous sequence of elements within an array.
//
//Constraints:
//-----------
//1 <= nums.length <= 10^5
//1 <= nums[i] <= 10^6

public class LongestSubarrayWithMaximumBitwiseAND 
{
	public int longestSubarray(int[] nums)
	{
		int mx = 0, ind = -1, n = nums.length;
        for(int i=0;i<n;i++){
            if(mx < nums[i]){
                mx = nums[i];
                ind = i;
            }
        }
        int count = 0, res = 0;
        for(int i=ind;i<n;i++){
            if(nums[i]==mx){
                count++;
            }
            else{
                res = Math.max(count,res);
                count = 0;
            }
        }
        res = Math.max(count,res);
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
		LongestSubarrayWithMaximumBitwiseAND Res = new LongestSubarrayWithMaximumBitwiseAND();
		System.out.print(Res.longestSubarray(arr));
	}
}
