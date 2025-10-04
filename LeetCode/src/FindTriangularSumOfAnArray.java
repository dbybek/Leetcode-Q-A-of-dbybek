import java.util.Scanner;

//2221. Find Triangular Sum of an Array (Medium)
//----------------------------------------------
//You are given a 0-indexed integer array nums, where nums[i] is a digit between 0 and 9 (inclusive).
//
//The triangular sum of nums is the value of the only element present in nums after the following process terminates:
//Let nums comprise of n elements. If n == 1, end the process.
//Otherwise, create a new 0-indexed integer array newNums of length n - 1.
//For each index i, where 0 <= i < n - 1,
//assign the value of newNums[i] as (nums[i] + nums[i+1]) % 10, where % denotes modulo operator.
//Replace the array nums with newNums.
//Repeat the entire process starting from step 1.
//Return the triangular sum of nums.
//
//Constraints:
//-----------
//1 <= nums.length <= 1000
//0 <= nums[i] <= 9

public class FindTriangularSumOfAnArray 
{
	public int triangularSum(int[] nums)
	{
		int n = nums.length;
		for(int i=1;i<n;i++) {
			for(int j=0;j<n-i;j++) {
				nums[j] = (nums[j]+nums[j+1])%10;
			}
		}
		return nums[0];
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
		FindTriangularSumOfAnArray Res = new FindTriangularSumOfAnArray();
		System.out.print(Res.triangularSum(arr));
	}
}
