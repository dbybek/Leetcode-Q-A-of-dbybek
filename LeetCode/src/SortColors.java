import java.util.Scanner;

//75. Sort Colors (Medium)
//------------------------
//Given an array nums with n objects colored red, white, or blue,
//sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
//We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
//
//You must solve this problem without using the library's sort function.
//
//Constraints:
//-----------
//n == nums.length
//1 <= n <= 300
//nums[i] is either 0, 1, or 2.

public class SortColors {

	public void sortColors(int[] nums) 
	{
//		Approach I: Take the counts of 0,1,2 and then make save them accordingly into the array:
//		----------------------------------------------------------------------------------------
//        int zeroCount = 0, oneCount = 0;
//        for(int ele:nums) {
//        	if(ele==0) {
//        		zeroCount++;
//        	}
//        	else if(ele==1) {
//        		oneCount++;
//        	}
//        }
//        
//        for(int i=0;i<nums.length;i++) {
//        	if(zeroCount>0) {
//        		nums[i] = 0;
//        		zeroCount--;
//        	}
//        	else if(oneCount>0) {
//        		nums[i] = 1;
//        		oneCount--;
//        	}
//        	else {
//        		nums[i] = 2;
//        	}
//        }
//        
//		Approach II: Take 3 values low, mid and high where low should be the position of next '0', mid should be the position 
//                   of next '1' and high should be the position of next '2'. Then keep on swapping the values accordingly.:
//		--------------------------------------------------------------------------------------------------------------------
        
        int low = 0, mid = 0, high = nums.length-1, temp = 0;

        while(mid<=high) {
        	if(nums[mid]==0) {
        		temp = nums[low];
        		nums[low] = nums[mid];
        		nums[mid] = temp;
        		low++;
        		mid++;
        	}
        	else if(nums[mid]==1) {
        		mid++;
        	}
        	else {
        		temp = nums[mid];
        		nums[mid] = nums[high];
        		nums[high] = temp;
        		high--;
        	}
        }
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
		System.out.println("Before function call:");
		for(int ele:arr) {
			System.out.print(ele+" ");
		}
		System.out.println();
		SortColors Res = new SortColors();
		Res.sortColors(arr);
		System.out.println("After function call:");
		for(int ele:arr) {
			System.out.print(ele+" ");
		}
	}

}
