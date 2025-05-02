import java.util.Scanner;

//2962. Count Subarrays Where Max Element Appears at Least K Times (Medium)
//-------------------------------------------------------------------------
//You are given an integer array nums and a positive integer k.
//Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.
//A subarray is a contiguous sequence of elements within an array.
//
//Constraints:
//-----------
//1 <= nums.length <= 10^5
//1 <= nums[i] <= 10^^6
//1 <= k <= 10^5

public class CountSubarraysWhereMaxElementAppearsAtLeastKTimes {

	public long countSubarrays(int[] nums, int k) 
	{
        int mx=0,n=nums.length;
		for(int ele:nums) {
			mx=Math.max(mx,ele);
		}
		boolean add=true;
		long res=0;
		int l=0,r=0,count=0;
		while(r<n) {
			if(add) {
				if(nums[r]==mx) {
					count++;
				}
			}
			if(count==k) {
				res+=n-r;
				if(nums[l]==mx) {
					count--;
				}
				l++;
				add=false;
				if(l==r && count!=k) {
					r++;
					add=true;
				}
			}
			else {
				r++;
				add=true;
			}
		}
		return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		int K = sc.nextInt();
		sc.close();
		CountSubarraysWhereMaxElementAppearsAtLeastKTimes Res = new CountSubarraysWhereMaxElementAppearsAtLeastKTimes();
		System.out.print(Res.countSubarrays(arr, K));
	}

}
