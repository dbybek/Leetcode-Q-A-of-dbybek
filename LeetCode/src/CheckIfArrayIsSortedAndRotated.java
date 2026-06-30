import java.util.Scanner;

//1752. Check if Array Is Sorted and Rotated (Easy)
//-------------------------------------------------
//Given an array nums, return true if the array was originally sorted in non-decreasing order,
//then rotated some number of positions (including zero). Otherwise, return false.
//There may be duplicates in the original array.
//
//Note: An array A rotated by x positions results in an array B of the same length such that B[i] == A[(i+x) % A.length]
//for every valid index i.
//Constraints:
//-----------
//1 <= nums.length <= 100
//1 <= nums[i] <= 100

public class CheckIfArrayIsSortedAndRotated 
{
	public boolean check(int[] nums)
	{
		int count = 0, n = nums.length;
		for(int i=0;i<n-1;i++) {
			if(nums[i] > nums[i+1]) {
				count++;
			}
		}
		if(nums[0] < nums[n-1]) {
			count++;
		}
		return count<=1;
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
		CheckIfArrayIsSortedAndRotated Res = new CheckIfArrayIsSortedAndRotated();
		System.out.print(Res.check(arr));
	}
}
