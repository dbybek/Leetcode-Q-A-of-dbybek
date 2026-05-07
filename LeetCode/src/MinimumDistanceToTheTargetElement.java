import java.util.Scanner;

//1848. Minimum Distance to the Target Element(Easy)
//--------------------------------------------------
//Given an integer array nums (0-indexed) and two integers target and start,
//find an index i such that nums[i] == target and abs(i - start) is minimized.
//Note that abs(x) is the absolute value of x.
//Return abs(i - start).
//
//It is guaranteed that target exists in nums.
//
//Constraints:
//-----------
//1 <= nums.length <= 1000
//1 <= nums[i] <= 10^4
//0 <= start < nums.length
//target is in nums.

public class MinimumDistanceToTheTargetElement 
{
	public int getMinDistance(int[] nums, int target, int start)
	{
		int res = 1001;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                res = Math.min(res, Math.abs(i-start));
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
		int tar = sc.nextInt(), str = sc.nextInt();
		sc.close();
		MinimumDistanceToTheTargetElement Res = new MinimumDistanceToTheTargetElement();
		System.out.print(Res.getMinDistance(arr, tar, str));
	}
}
