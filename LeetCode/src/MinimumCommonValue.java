import java.util.Scanner;

//2540. Minimum Common Value (Easy)
//---------------------------------
//Given two integer arrays nums1 and nums2, sorted in non-decreasing order,
//return the minimum integer common to both arrays. If there is no common integer amongst nums1 and nums2, return -1.
//Note that an integer is said to be common to nums1 and nums2 if both arrays have at least one occurrence of that integer.
//Constraints:
//-----------
//1 <= nums1.length, nums2.length <= 10^5
//1 <= nums1[i], nums2[j] <= 10^9
//Both nums1 and nums2 are sorted in non-decreasing order.

public class MinimumCommonValue 
{
	public int getCommon(int[] nums1, int[] nums2)
	{
		int n = nums1.length, m = nums2.length;
        for(int i=0,j=0;i<n && j<m;){
            if(nums1[i]==nums2[j]){
                return nums1[i];
            }
            if(nums1[i]<nums2[j]){
                i++;
            }
            else{
                j++;
            }
        }
        return -1;
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
		MinimumCommonValue Res = new MinimumCommonValue();
		System.out.print(Res.getCommon(arr, arr1));
	}
}
