import java.util.Scanner;

//1674. Minimum Moves to Make Array Complementary (Medium)
//--------------------------------------------------------
//You are given an integer array nums of even length n and an integer limit.
//In one move, you can replace any integer from nums with another integer between 1 and limit, inclusive.
//The array nums is complementary if for all indices i (0-indexed), nums[i] + nums[n - 1 - i] equals the same number.
//For example, the array [1,2,3,4] is complementary because for all indices i, nums[i] + nums[n - 1 - i] = 5.
//Return the minimum number of moves required to make nums complementary.
//Constraints:
//-----------
//1 <= tasks.length <= 10^5
//1 <= actual​i <= minimumi <= 10^4

public class MinimumMovesToMakeArrayComplementary 
{
	public int minMoves(int[] nums, int limit)
	{
		int n = nums.length;
        int[] dp = new int[2*limit + 2];
        for(int i=0;i<n/2;i++){
            int mn = Math.min(nums[i], nums[n-1-i]), mx = Math.max(nums[i], nums[n-1-i]);
            dp[2]+=2;
            dp[mn+1]-=1;
            dp[mn+mx]-=1;
            dp[mn+mx+1]+=1;
            dp[mx+limit+1]+=1;
        }
        int res = n, m = 0;
        for(int i=2;i<=2*limit;i++){
            m += dp[i];
            res = Math.min(res,m);
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
		MinimumMovesToMakeArrayComplementary Res = new MinimumMovesToMakeArrayComplementary();
		System.out.print(Res.minMoves(arr, k));
	}
}
