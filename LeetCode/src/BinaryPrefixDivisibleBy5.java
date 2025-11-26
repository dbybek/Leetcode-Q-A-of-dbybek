import java.util.*;

//1018. Binary Prefix Divisible By 5 (Easy)
//-----------------------------------------
//You are given a binary array nums (0-indexed).
//We define xi as the number whose binary representation is the subarray nums[0..i]
//(from most-significant-bit to least-significant-bit).
//For example, if nums = [1,0,1], then x0 = 1, x1 = 2, and x2 = 5.
//Return an array of booleans answer where answer[i] is true if xi is divisible by 5.
//
//Constraints:
//-----------
//1 <= nums.length <= 10^5
//nums[i] is either 0 or 1.

public class BinaryPrefixDivisibleBy5 
{
	public List<Boolean> prefixesDivBy5(int[] nums)
	{
		List<Boolean> res = new ArrayList<>();
		int x = 0;
		for(int ele:nums) {
			x = (x*2)+ele;
            x = x%5;
            res.add(x==0);
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
		BinaryPrefixDivisibleBy5 Res = new BinaryPrefixDivisibleBy5();
		System.out.print(Res.prefixesDivBy5(arr));
	}
}
