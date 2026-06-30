import java.util.Scanner;

//33. Search in Rotated Sorted Array (Medium)
//-------------------------------------------
//There is an integer array nums sorted in ascending order (with distinct values).
//Prior to being passed to your function,
//nums is possibly left rotated at an unknown index k (1 <= k < nums.length) such that
//the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
//For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].
//Given the array nums after the possible rotation and an integer target,
//return the index of target if it is in nums, or -1 if it is not in nums.
//You must write an algorithm with O(log n) runtime complexity.
//Constraints:
//-----------
//1 <= nums.length <= 5000
//-10^4 <= nums[i] <= 10^4
//All values of nums are unique.
//nums is an ascending array that is possibly rotated.
//-10^4 <= target <= 10^4

public class SearchInRotatedSortedArray 
{
	public int search(int[] nums, int target)
	{
		int l = 0, r = nums.length-1;
		while(l<=r) {
			int mid = (r+l)/2;
			if(nums[mid]==target) {
				return mid;
			}
			if(nums[l] <= nums[mid]) {
				if(nums[l] <= target && nums[mid] > target) {
					r = mid-1;
				}
				else {
					l = mid+1;
				}
			}
			else {
				if(nums[mid] < target && nums[r] >= target) {
					l = mid+1;
				}
				else {
					r = mid-1;
				}
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
		int k = sc.nextInt();
		sc.close();
		SearchInRotatedSortedArray Res = new SearchInRotatedSortedArray();
		System.out.print(Res.search(arr, k));
	}
}
