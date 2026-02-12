import java.util.Scanner;

//3065. Minimum Operations to Exceed Threshold Value I(Easy)
//----------------------------------------------------------
//You are given a 0-indexed integer array nums, and an integer k.
//In one operation, you can remove one occurrence of the smallest element of nums.
//Return the minimum number of operations needed so that all elements of the array are greater than or equal to k.
//
//Constraints:
//-----------
//1 <= nums.length <= 50
//1 <= nums[i] <= 10^9
//1 <= k <= 10^9
//The input is generated such that there is at least one index i such that nums[i] >= k.

public class MinimumOperationsToExceedThresholdValueI 
{
	public int minOperations(int[] nums, int k) 
	{
        int res = 0;
        for(int ele:nums){
            if(ele<k){
                res++;
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
		int k = sc.nextInt();
		sc.close();
		MinimumOperationsToExceedThresholdValueI Res = new MinimumOperationsToExceedThresholdValueI();
		System.out.print(Res.minOperations(arr, k));
	}
}
