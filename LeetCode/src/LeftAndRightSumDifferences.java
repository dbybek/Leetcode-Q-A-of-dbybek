import java.util.Scanner;

//2574. Left and Right Sum Differences (Easy)
//-------------------------------------------
//You are given a 0-indexed integer array nums of size n.
//Define two arrays leftSum and rightSum where:
//
//leftSum[i] is the sum of elements to the left of the index i in the array nums.
//If there is no such element, leftSum[i] = 0.
//rightSum[i] is the sum of elements to the right of the index i in the array nums.
//If there is no such element, rightSum[i] = 0.
//Return an integer array answer of size n where answer[i] = |leftSum[i] - rightSum[i]|.
//
//Constraints:
//-----------
//1 <= nums.length <= 1000
//1 <= nums[i] <= 10^5

public class LeftAndRightSumDifferences 
{
	public int[] leftRightDifference(int[] nums)
	{
		int n=nums.length,total=0,leftSum=0;
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            total+=nums[i];
        }
        for(int i=0;i<n;i++){
            res[i]=Math.abs(total-nums[i]-leftSum);
            leftSum+=nums[i];
            total-=nums[i];
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
		LeftAndRightSumDifferences Res = new LeftAndRightSumDifferences();
		System.out.print(Res.leftRightDifference(arr));
	}
}
