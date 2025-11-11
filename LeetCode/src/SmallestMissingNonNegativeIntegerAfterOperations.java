import java.util.Scanner;

//2598. Smallest Missing Non-negative Integer After Operations (Medium)
//---------------------------------------------------------------------
//You are given a 0-indexed integer array nums and an integer value.
//In one operation, you can add or subtract value from any element of nums.
//For example, if nums = [1,2,3] and value = 2, you can choose to subtract value from nums[0] to make nums = [-1,2,3].
//The MEX (minimum excluded) of an array is the smallest missing non-negative integer in it.
//For example, the MEX of [-1,2,3] is 0 while the MEX of [1,0,3] is 2.
//Return the maximum MEX of nums after applying the mentioned operation any number of times.
//
//Constraints:
//-----------
//1 <= nums.length, value <= 10^5
//-10^9 <= nums[i] <= 10^9

public class SmallestMissingNonNegativeIntegerAfterOperations 
{
	public int findSmallestInteger(int[] nums, int value)
	{
		int n = nums.length;
        int[] count = new int[value];
        for(int i=0;i<n;i++){
            count[(nums[i]%value+value)%value]++;
        }
        int res = 0;
        while(count[res%value]-->0){
            res++;
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
		int k = sc.nextInt();
		sc.close();
		SmallestMissingNonNegativeIntegerAfterOperations Res = new SmallestMissingNonNegativeIntegerAfterOperations();
		System.out.print(Res.findSmallestInteger(arr, k));
	}
}
