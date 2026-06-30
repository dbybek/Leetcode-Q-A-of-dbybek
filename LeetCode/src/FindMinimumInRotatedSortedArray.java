import java.util.Scanner;

//153. Find Minimum in Rotated Sorted Array (Medium)
//--------------------------------------------------
//Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
//For example, the array nums = [0,1,2,4,5,6,7] might become:
//[4,5,6,7,0,1,2] if it was rotated 4 times.
//[0,1,2,4,5,6,7] if it was rotated 7 times.
//Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results 
//in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
//
//Given the sorted rotated array nums of unique elements, return the minimum element of this array.
//
//You must write an algorithm that runs in O(log n) time.
//Constraints:
//-----------
//n == nums.length
//1 <= n <= 5000
//-5000 <= nums[i] <= 5000
//All the integers of nums are unique.
//nums is sorted and rotated between 1 and n times.

public class FindMinimumInRotatedSortedArray 
{
	public int findMin(int[] nums)
	{
		int l = 0, r = nums.length-1;
        while(l<r){
            int mid = l+(r-l)/2;
            if(nums[mid] < nums[r]){
                r = mid;
            }
            else {
                l = mid+1;
            }
        }
        return nums[l];
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
		FindMinimumInRotatedSortedArray Res = new FindMinimumInRotatedSortedArray();
		System.out.print(Res.findMin(arr));
	}
}
