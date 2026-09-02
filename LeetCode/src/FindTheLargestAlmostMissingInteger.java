import java.util.Scanner;

//3471. Find the Largest Almost Missing Integer (Easy)
//----------------------------------------------------
//You are given an integer array nums and an integer k.
//An integer x is almost missing from nums if x appears in exactly one subarray of size k within nums.
//Return the largest almost missing integer from nums. If no such integer exists, return -1.
//A subarray is a contiguous sequence of elements within an array.
//
//Constraints:
//-----------
//1 <= nums.length <= 50
//0 <= nums[i] <= 50
//1 <= k <= nums.length

public class FindTheLargestAlmostMissingInteger 
{
	public int largestInteger(int[] nums, int k)
	{
		int mx = -1, res = -1, n = nums.length;
        int[] freq = new int[51];
        for(int i=0;i<n;i++){
            freq[nums[i]]++;
            mx = Math.max(nums[i],mx);
        }
        if(k==1){
            for(int i=50;i>=0;i--){
                if(freq[i]==1){
                    return i;
                }
            }
            return -1;
        }
        else if (k==n){
            return mx;
        }
        if(freq[nums[0]]==1){
            res = Math.max(res, nums[0]);
        }
        if(freq[nums[n-1]]==1){
            res = Math.max(res, nums[n-1]);
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
		FindTheLargestAlmostMissingInteger Res = new FindTheLargestAlmostMissingInteger();
		System.out.print(Res.largestInteger(arr, k));
	}
}
