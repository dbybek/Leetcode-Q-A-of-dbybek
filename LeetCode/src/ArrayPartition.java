import java.util.Scanner;

//561. Array Partition (Easy)
//---------------------------
//Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2), ..., (an, bn) 
//such that the sum of min(ai, bi) for all i is maximized. Return the maximized sum.
//
//Constraints:
//-----------
//1 <= n <= 10^4
//nums.length == 2 * n
//-10^4 <= nums[i] <= 10^4

public class ArrayPartition 
{
	public int arrayPairSum(int[] nums)
	{
		int mx = -10001, mn = 10001;
        for(int ele:nums){
            mx = Math.max(mx,ele);
            mn = Math.min(mn,ele);
        }
        int[] freq = new int[mx-mn+1];;
        for(int ele:nums){
            freq[ele-mn]++;
        }
        int res = 0, rem = 1;
        for(int i=0;i<=mx-mn;i++){
            res += ((freq[i]+rem)>>1) * (i+mn);
            rem^=(freq[i]&1);
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
		ArrayPartition Res = new ArrayPartition();
		System.out.print(Res.arrayPairSum(arr));
	}
}
