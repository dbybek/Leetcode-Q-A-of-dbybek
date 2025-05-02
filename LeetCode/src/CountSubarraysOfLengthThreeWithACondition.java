import java.util.Scanner;

//3392. Count Subarrays of Length Three With a Condition (Easy)
//-------------------------------------------------------------
//Given an integer array nums,
//return the number of subarrays of length 3 such that 
//the sum of the first and third numbers equals exactly half of the second number.
//
//Constraints:
//-----------
//3 <= nums.length <= 100
//-100 <= nums[i] <= 100

public class CountSubarraysOfLengthThreeWithACondition {

	public int countSubarrays(int[] nums) 
	{
        int n=nums.length-3,res=0;
		for(int i=0;i<=n;i++) {
			if((nums[i]+nums[i+2])*2==nums[i+1]) {
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
		sc.close();
		CountSubarraysOfLengthThreeWithACondition Res = new CountSubarraysOfLengthThreeWithACondition();
		System.out.print(Res.countSubarrays(arr));
	}

}
