import java.util.Scanner;

//3423. Maximum Difference Between Adjacent Elements in a Circular Array (Easy)
//-----------------------------------------------------------------------------
//Given a circular array nums, find the maximum absolute difference between adjacent elements.
//
//Note: In a circular array, the first and last elements are adjacent.
//
//Constraints:
//-----------
//2 <= nums.length <= 100
//-100 <= nums[i] <= 100

public class MaximumDifferenceBetweenAdjacentElementsInACircularArray 
{

	public int maxAdjacentDistance(int[] nums) 
	{
        int n = nums.length, res = Math.abs(nums[n-1]-nums[0]);
        for(int i=0;i<n-1;i++){
            int diff = Math.abs(nums[i]-nums[i+1]);
            res = Math.max(res,diff);
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
		MaximumDifferenceBetweenAdjacentElementsInACircularArray Res = new MaximumDifferenceBetweenAdjacentElementsInACircularArray();
		System.out.print(Res);
	}

}
