import java.util.Scanner;

//396. Rotate Function (Medium)
//-----------------------------
//You are given an integer array nums of length n.
//Assume arrk to be an array obtained by rotating nums by k positions clock-wise.
//We define the rotation function F on nums as follow:
//F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1].
//Return the maximum value of F(0), F(1), ..., F(n-1).
//
//The test cases are generated so that the answer fits in a 32-bit integer.
//Constraints:
//-----------
//n == nums.length
//1 <= n <= 10^5
//-100 <= nums[i] <= 100

public class RotateFunction 
{
	public int maxRotateFunction(int[] nums)
	{
		int n = nums.length, sum = 0, F = 0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            F+=i*nums[i];
        }
        int res = F;
        for(int i=1;i<n;i++){
            F+=sum-(n*nums[n-i]);
            res = Math.max(res,F);
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
		RotateFunction Res = new RotateFunction();
		System.out.print(Res.maxRotateFunction(arr));
	}
}
