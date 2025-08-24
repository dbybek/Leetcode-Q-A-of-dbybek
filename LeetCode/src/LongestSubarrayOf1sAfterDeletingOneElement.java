import java.util.Scanner;

//1493. Longest Subarray of 1's After Deleting One Element (Medium)
//-----------------------------------------------------------------
//Given a binary array nums, you should delete one element from it.
//Return the size of the longest non-empty subarray containing only 1's in the resulting array.
//Return 0 if there is no such subarray.
//
//Constraints:
//-----------
//1 <= nums.length <= 10^5
//nums[i] is either 0 or 1.

public class LongestSubarrayOf1sAfterDeletingOneElement 
{
	public int longestSubarray(int[] nums)
	{
//		ApproachI: Keeping a previous count of '1's and adding it to current count of '1's and checking for max.
//		--------------------------------------------------------------------------------------------------------
//		1 extra if clause;
//		int count1 = 0 , count = 0 , maxCount = 0;
//        boolean allOne = true;
//        for (int i = 0;i<nums.length;i++){
//            if (nums[i] == 1){
//                count1++;
//            }
//            else {
//                allOne = false;
//                maxCount = Math.max(maxCount, count1+count);
//                count = count1;
//                count1 = 0;
//            }
//        }
//        if (nums[nums.length - 1] == 1){
//            maxCount = Math.max(maxCount, count1+count);
//        }
//        if (allOne){
//            return count1 - 1;
//        }
//        return maxCount;
        
//		ApproachII: Sliding Window approach. No need for the extra if conditions after the looping.
//		-------------------------------------------------------------------------------------------
		int l = 0, r = 0, zeroInd = -1, maxLen = 0, len = nums.length;
		while(r<len) {
			if(nums[r]==0) {
				if(zeroInd==-1) {
					zeroInd = r;
					r++;
				}
				else {
					maxLen = Math.max(maxLen, r-l-1);
					l = zeroInd + 1;
					zeroInd = -1;
				}
			}
			else {
				r++;
			}
		}
		return Math.max(maxLen, r-l-1);
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
		LongestSubarrayOf1sAfterDeletingOneElement Res = new LongestSubarrayOf1sAfterDeletingOneElement();
		System.out.print(Res.longestSubarray(arr));
	}
}
