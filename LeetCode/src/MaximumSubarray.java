import java.util.Scanner;

//53. Maximum Subarray (Medium)
//-----------------------------
//Given an integer array nums, find the subarray with the largest sum, and return its sum.
//
//Constraints:
//-----------
//1 <= nums.length <= 10^5
//-10^4 <= nums[i] <= 10^4

public class MaximumSubarray 
{
	public int maxSubArray(int[] nums)
	{
		int res = Integer.MIN_VALUE, sum = 0;
        for(int ele:nums){
            sum+=ele;
            res = Math.max(sum,res);
            if(sum<0){
                sum = 0;
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
		MaximumSubarray Res = new MaximumSubarray();
		System.out.print(Res.maxSubArray(arr));
	}
}
