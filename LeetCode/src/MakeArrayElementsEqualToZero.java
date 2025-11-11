import java.util.Scanner;

//3354. Make Array Elements Equal to Zero (Easy)
//----------------------------------------------
//You are given an integer array nums.
//Start by selecting a starting position curr such that nums[curr] == 0,
//and choose a movement direction of either left or right.
//After that, you repeat the following process:
//If curr is out of the range [0, n - 1], this process ends.
//If nums[curr] == 0, move in the current direction by incrementing curr if you are moving right,
//or decrementing curr if you are moving left.
//Else if nums[curr] > 0:
//Decrement nums[curr] by 1.
//Reverse your movement direction (left becomes right and vice versa).
//Take a step in your new direction.
//A selection of the initial position curr and
//movement direction is considered valid if every element in nums becomes 0 by the end of the process.
//
//Return the number of possible valid selections.
//
//Constraints:
//-----------
//1 <= nums.length <= 100
//0 <= nums[i] <= 100
//There is at least one element i where nums[i] == 0.

public class MakeArrayElementsEqualToZero 
{
	public int countValidSelections(int[] nums)
	{
		int sum = 0, leftSum = 0, res = 0;
        for(int ele:nums){
            sum+=ele;
        }
        for(int ele:nums){
            int rightSum = sum-leftSum-ele;
            if(ele==0){
                if(leftSum==rightSum){
                    res+=2;
                }
                else if(leftSum==rightSum-1 || leftSum-1==rightSum){
                    res++;
                }
            }
            leftSum+=ele;
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
		MakeArrayElementsEqualToZero Res = new MakeArrayElementsEqualToZero();
		System.out.print(Res.countValidSelections(arr));
	}
}
