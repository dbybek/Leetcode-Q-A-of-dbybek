import java.util.Scanner;

//1846. Maximum Element After Decreasing and Rearranging (Medium)
//---------------------------------------------------------------
//You are given an array of positive integers arr.
//Perform some operations (possibly none) on arr so that it satisfies these conditions:
//The value of the first element in arr must be 1.
//The absolute difference between any 2 adjacent elements must be less than or equal to 1.
//In other words, abs(arr[i] - arr[i - 1]) <= 1 for each i where 1 <= i < arr.length (0-indexed).
//abs(x) is the absolute value of x.
//There are 2 types of operations that you can perform any number of times:
//
//Decrease the value of any element of arr to a smaller positive integer.
//Rearrange the elements of arr to be in any order.
//Return the maximum possible value of an element in arr after performing the operations to satisfy the conditions.
//
//Constraints:
//-----------
//1 <= arr.length <= 10^5
//1 <= arr[i] <= 10^9

public class MaximumElementAfterDecreasingAndRearranging 
{
	public int maximumElementAfterDecrementingAndRearranging(int[] arr)
	{
		int n = arr.length, res = 1;
        int[] freq = new int[n+1]; 
        for (int i=0;i<n;i++) {
            freq[Math.min(n,arr[i])]++; 
        }
        for (int i=2;i<n+1;i++) {
            res = Math.min(i,res+freq[i]);
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
		MaximumElementAfterDecreasingAndRearranging Res = new MaximumElementAfterDecreasingAndRearranging();
		System.out.print(Res.maximumElementAfterDecrementingAndRearranging(arr));
	}
}
