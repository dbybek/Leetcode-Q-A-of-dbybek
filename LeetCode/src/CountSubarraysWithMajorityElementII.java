import java.util.Scanner;

//3739. Count Subarrays With Majority Element II (Hard)
//-----------------------------------------------------
//You are given an integer array nums and an integer target.
//Return the number of subarrays of nums in which target is the majority element.
//The majority element of a subarray is the element that appears strictly more than half of the times in that subarray.
//
//Constraints:
//-----------
//1 <= nums.length <= 10^5
//1 <= nums[i] <= 10​​​​​​​^9
//1 <= target <= 10^9

public class CountSubarraysWithMajorityElementII 
{
	public long countMajoritySubarrays(int[] nums, int target)
	{
		int n = nums.length, len = 2*n+2, p = n+1;
		long res = 0;
        long[] freq = new long[len];
        long[] pref = new long[len];
        freq[p] = 1;
        pref[p] = 1;
        for(int i=0;i<n;i++){
            if(nums[i]==target){
                p++;
            }
            else{
                p--;
            }
            freq[p]++;
            pref[p] = pref[p-1]+freq[p];
            res+=pref[p-1];
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
		CountSubarraysWithMajorityElementII Res = new CountSubarraysWithMajorityElementII();
		System.out.print(Res.countMajoritySubarrays(arr, k));
	}
}
