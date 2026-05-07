import java.util.Scanner;

//1855. Maximum Distance Between a Pair of Values (Medium)
//--------------------------------------------------------
//You are given two non-increasing 0-indexed integer arrays nums1​​​​​​ and nums2​​​​​​.
//A pair of indices (i, j), where 0 <= i < nums1.length and 0 <= j < nums2.length,
//is valid if both i <= j and nums1[i] <= nums2[j]. The distance of the pair is j - i​​​​.
//Return the maximum distance of any valid pair (i, j).
//If there are no valid pairs, return 0.
//An array arr is non-increasing if arr[i-1] >= arr[i] for every 1 <= i < arr.length.
//
//Constraints:
//-----------
//1 <= nums1.length, nums2.length <= 10^5
//1 <= nums1[i], nums2[j] <= 10^5
//Both nums1 and nums2 are non-increasing.

public class MaximumDistanceBetweenAPairOfValues 
{
	public int maxDistance(int[] nums1, int[] nums2)
	{
		int res = 0, l1 = nums1.length, l2 = nums2.length, i = 0, j = 0;
        while(i<l1 && j<l2){
            if(nums1[i] <= nums2[j]) {
            	res = Math.max(res, j-i);
            	j++;
            }
            else {
            	i++;
            	j++;
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
		int M = sc.nextInt();
		int[] arr1 = new int[M];
		for(int i=0;i<M;i++) {
			arr1[i] = sc.nextInt();
		}
		sc.close();
		MaximumDistanceBetweenAPairOfValues Res = new MaximumDistanceBetweenAPairOfValues();
		System.out.print(Res.maxDistance(arr, arr1));
	}
}
