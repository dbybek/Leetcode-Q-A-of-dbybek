import java.util.Scanner;

//3355. Zero Array Transformation I (Medium)
//------------------------------------------
//You are given an integer array nums of length n and a 2D array queries, where queries[i] = [li, ri].
//
//For each queries[i]:
//
//Select a subset of indices within the range [li, ri] in nums.
//Decrement the values at the selected indices by 1.
//A Zero Array is an array where all elements are equal to 0.
//
//Return true if it is possible to transform nums into a Zero Array after processing all the queries sequentially,
//otherwise return false.
//
//Constraints:
//-----------
//1 <= nums.length <= 10^5
//0 <= nums[i] <= 10^5
//1 <= queries.length <= 10^5
//queries[i].length == 2
//0 <= li <= ri < nums.length

public class ZeroArrayTransformation1 
{
	
	public boolean isZeroArray(int[] nums, int[][] queries) 
	{
        int n = nums.length;
        int[] diff = new int[n];
        for(int[] ele:queries) {
        	if(ele[0]<n) {
        		diff[ele[0]]++;
        	}
        	if(ele[1]+1<n) {
        		diff[ele[1]+1]--;
        	}
        }
        int count = 0;
        for(int i=0;i<n;i++) {
        	count += diff[i];
        	if(nums[i]>count) {
        		return false;
        	}
        }
        return true;
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
		int Q = sc.nextInt();
		int[][] arr1 = new int[Q][2];
		for(int i=0;i<N;i++) {
			arr1[i][0] = sc.nextInt();
			arr1[i][1] = sc.nextInt();
		}
		sc.close();
		ZeroArrayTransformation1 Res = new ZeroArrayTransformation1();
		System.out.print(Res.isZeroArray(arr, arr1));
	}

}
