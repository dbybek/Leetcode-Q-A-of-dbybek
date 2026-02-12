import java.util.Scanner;

//1480. Running Sum of 1d Array(Easy)
//-----------------------------------
//Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
//Return the running sum of nums.
//
//Constraints:
//-----------
//1 <= nums.length <= 1000
//-10^6 <= nums[i] <= 10^6

public class RunningSumOf1dArray 
{
	public int[] runningSum(int[] nums) 
	{
        int n = nums.length;
        int[] res = new int[n];
        res[0] = nums[0];
        for(int i=1;i<n;i++){
            res[i] = res[i-1]+nums[i];
        }
        return res;
    }
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr1 = new int[N];
		for(int i=0;i<N;i++) {
			arr1[i] = sc.nextInt();
		}
		sc.close();
		RunningSumOf1dArray Res = new RunningSumOf1dArray();
		int[] arr2 = Res.runningSum(arr1);
		for(int ele:arr2) {
			System.out.print(ele+" ");
		}
	}
}
