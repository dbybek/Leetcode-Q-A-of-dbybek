import java.util.Scanner;

//3660. Jump Game IX (Medium)
//---------------------------
//You are given an integer array nums.
//From any index i, you can jump to another index j under the following rules:
//Jump to index j where j > i is allowed only if nums[j] < nums[i].
//Jump to index j where j < i is allowed only if nums[j] > nums[i].
//For each index i,
//find the maximum value in nums that can be reached by following any sequence of valid jumps starting at i.
//
//Return an array ans where ans[i] is the maximum value reachable starting from index i.
//Constraints:
//-----------
//1 <= nums.length <= 10^5
//1 <= nums[i] <= 10^9

public class JumpGameIX 
{
	public int[] maxValue(int[] nums)
	{
		// int n = nums.length;
        // int[] pref = new int[n];
        // pref[0] = nums[0];
        // for(int i=1;i<n;i++){
        //     pref[i] = Math.max(pref[i-1],nums[i]);
        // }
        // int[] suff = new int[n];
        // suff[n-1] = nums[n-1];
        // for(int i=n-2;i>=0;i--){
        //     suff[i] = Math.min(suff[i+1],nums[i]);
        // }
        // int[] res = new int[n];
        // int start = 0;
        // for(int i=0;i<n-1;i++){
        //     if(pref[i] <= suff[i+1]){
        //         for(int j=start;j<=i;j++){
        //             res[j] = pref[i];
        //         }
        //         start = i+1;
        //     }
        // }
        // for(int i=start;i<n;i++){
        //     res[i] = pref[n-1];
        // }
        // return res;
        int n = nums.length, mn = Integer.MAX_VALUE;
        int[] res = new int[n];
        res[0] = nums[0];
        for(int i=1;i<n;i++){
            res[i] = Math.max(res[i - 1], nums[i]);
        }
        for(int i=n-2;i>=0;i--) {
            mn = Math.min(mn, nums[i + 1]);
            if(mn<res[i]) {
                res[i] = res[i+1];
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
		sc.close();
		JumpGameIX Res = new JumpGameIX();
		int[] arr1 = Res.maxValue(arr);
		for(int i=0;i<N;i++) {
			System.out.print(arr1[i]+" ");
		}
	}
}
