import java.util.Scanner;

//3740. Minimum Distance Between Three Equal Elements I (Easy)
//------------------------------------------------------------
//You are given an integer array nums.
//A tuple (i, j, k) of 3 distinct indices is good if nums[i] == nums[j] == nums[k].
//
//The distance of a good tuple is abs(i - j) + abs(j - k) + abs(k - i), where abs(x) denotes the absolute value of x.
//
//Return an integer denoting the minimum possible distance of a good tuple. If no good tuples exist, return -1.
//
//Constraints:
//-----------
//1 <= n == nums.length <= 100
//1 <= nums[i] <= n

public class MinimumDistanceBetweenThreeEqualElementsI 
{
	public int minimumDistance(int[] nums)
	{
		Integer[] dp = new Integer[nums.length + 1], dp1 = new Integer[nums.length + 1];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (dp[nums[i]] != null) {
                res = Math.min(res, 2 * (i - dp[nums[i]]));
            }
            dp[nums[i]] = dp1[nums[i]];
            dp1[nums[i]] = i;
        }
        return res < Integer.MAX_VALUE ? res : -1;
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
		MinimumDistanceBetweenThreeEqualElementsI Res = new MinimumDistanceBetweenThreeEqualElementsI();
		System.out.print(Res.minimumDistance(arr));
	}
}
