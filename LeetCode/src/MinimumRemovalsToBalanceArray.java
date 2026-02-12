import java.util.*;

//3634. Minimum Removals to Balance Array (Medium)
//------------------------------------------------
//You are given an integer array nums and an integer k.
//An array is considered balanced if the value of its maximum element is at most k times the minimum element.
//You may remove any number of elements from nums​​​​​​​ without making it empty.
//Return the minimum number of elements to remove so that the remaining array is balanced.
//Note: An array of size 1 is considered balanced as its maximum and minimum are equal,
//and the condition always holds true.
//
//Constraints:
//-----------
//1 <= nums.length <= 10^5
//1 <= nums[i] <= 10^9
//1 <= k <= 10^5

public class MinimumRemovalsToBalanceArray 
{
	public int minRemoval(int[] nums, int k) 
	{
        Arrays.sort(nums);
        int l = 0, mxSize = 0, n = nums.length;
        for(int r=0;r<n;r++){
            while(l<=r && (long)nums[r] > (long)nums[l]*k){
                l++;
            }
            mxSize = Math.max(mxSize, r-l+1);
        }
        return n-mxSize;
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
		MinimumRemovalsToBalanceArray Res = new MinimumRemovalsToBalanceArray();
		System.out.print(Res.minRemoval(arr, k));
	}
}
