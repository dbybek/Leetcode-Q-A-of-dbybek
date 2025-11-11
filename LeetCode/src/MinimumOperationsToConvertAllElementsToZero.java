import java.util.*;

//3542. Minimum Operations to Convert All Elements to Zero (Medium)
//-----------------------------------------------------------------
//You are given an array nums of size n, consisting of non-negative integers.
//Your task is to apply some (possibly zero) operations on the array so that all elements become 0.
//In one operation, you can select a subarray [i, j] (where 0 <= i <= j < n) and
//set all occurrences of the minimum non-negative integer in that subarray to 0.
//
//Return the minimum number of operations required to make all elements in the array 0.
//
//Constraints:
//-----------
//1 <= n == nums.length <= 10^5
//0 <= nums[i] <= 10^5

public class MinimumOperationsToConvertAllElementsToZero 
{
	public int minOperations(int[] nums)
	{
		int[] stk = new int[nums.length + 1];
        int top = 0,res = 0;
        for (int i=0;i<nums.length;i++) {
            while (stk[top] > nums[i]) {
                top--;
                res++;
            }
            if (stk[top] != nums[i]){
                stk[++top] = nums[i];
            }
        }
        return res+top;
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
		MinimumOperationsToConvertAllElementsToZero Res = new MinimumOperationsToConvertAllElementsToZero();
		System.out.print(Res.minOperations(arr));
	}
}
