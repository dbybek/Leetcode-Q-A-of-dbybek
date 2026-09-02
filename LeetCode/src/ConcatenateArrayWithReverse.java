import java.util.Scanner;

//3925. Concatenate Array With Reverse (Easy)
//-------------------------------------------
//You are given an integer array nums of length n.
//Construct a new array ans of length 2 * n such that the first n elements are the same as nums,
//and the next n elements are the elements of nums in reverse order.
//
//Formally, for 0 <= i <= n - 1:
//
//ans[i] = nums[i]
//ans[i + n] = nums[n - i - 1]
//Return an integer array ans.
//
//Constraints:
//-----------
//1 <= nums.length <= 100
//1 <= nums[i] <= 100

public class ConcatenateArrayWithReverse 
{
	public int[] concatWithReverse(int[] nums)
	{
		int[] res = new int[2*nums.length];
        for(int i=0;i<nums.length;i++){
            res[i] = nums[i];
            res[res.length-i-1] = nums[i];
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
		ConcatenateArrayWithReverse Res = new ConcatenateArrayWithReverse();
		int[] arr1 = Res.concatWithReverse(arr);
		for(int i=0;i<N;i++) {
			System.out.print(arr1[i]+" ");
		}
	}
}
