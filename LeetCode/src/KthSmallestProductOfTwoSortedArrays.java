import java.util.Scanner;

//2040. Kth Smallest Product of Two Sorted Arrays (Hard)
//------------------------------------------------------
//Given two sorted 0-indexed integer arrays nums1 and nums2 as well as an integer k,
//return the kth (1-based) smallest product of nums1[i] * nums2[j] where 0 <= i < nums1.length and 0 <= j < nums2.length.
//
//Constraints:
//-----------
//1 <= nums1.length, nums2.length <= 5 * 10^4
//-10^5 <= nums1[i], nums2[j] <= 10^5
//1 <= k <= nums1.length * nums2.length
//nums1 and nums2 are sorted.

public class KthSmallestProductOfTwoSortedArrays 
{
	private long productsCount(int[] num1, int[] num2, long M)
	{
		long cnt = 0;
		for(int ele:num1) {
			if(ele==0) {
				if(M>=0) {
					cnt += num2.length;
				}
				continue;
			}
			
			int low = 0, high = num2.length;
			while(low < high) {
				int mid = low + (high-low)/2;
				long product = (long)ele*(long)num2[mid];
				if(product <= M) {
					if(ele > 0) {
						low = mid + 1;
					}
					else {
						high = mid;
					}
				}
				else {
					if(ele > 0) {
						high = mid;
					}
					else {
						low = mid + 1;
					}
				}
			}
			cnt += (ele>0)?low:num2.length-low;
		}
		return cnt;
	}
	
	public long kthSmallestProduct(int[] nums1, int[] nums2, long k)
	{
		long left = -10000000000l, right = 10000000000l;
		while(left < right) {
			long mid = left + (right-left)/2;
			if(productsCount(nums1,nums2,mid)<k) {
				left = mid + 1;
			}
			else {
				right = mid;
			}
		}
		return left;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		int[] arr1 = new int[N];
		for(int i=0;i<N;i++) {
			arr1[i] = sc.nextInt();
		}
		int[] arr2 = new int[M];
		for(int i=0;i<M;i++) {
			arr2[i] = sc.nextInt();
		}
		long K = sc.nextInt();
		sc.close();
		KthSmallestProductOfTwoSortedArrays Res = new KthSmallestProductOfTwoSortedArrays();
		System.out.print(Res.kthSmallestProduct(arr1, arr2, K));
	}

}
