import java.util.Arrays;
import java.util.Scanner;

//3867. Sum of GCD of Formed Pairs (Medium)
//-----------------------------------------
//You are given an integer array nums of length n.
//Construct an array prefixGcd where for each index i:
//
//Let mxi = max(nums[0], nums[1], ..., nums[i]).
//prefixGcd[i] = gcd(nums[i], mxi).
//After constructing prefixGcd:
//
//Sort prefixGcd in non-decreasing order.
//Form pairs by taking the smallest unpaired element and the largest unpaired element.
//Repeat this process until no more pairs can be formed.
//For each formed pair, compute the gcd of the two elements.
//If n is odd, the middle element in the prefixGcd array remains unpaired and should be ignored.
//Return an integer denoting the sum of the GCD values of all formed pairs.
//
//The term gcd(a, b) denotes the greatest common divisor of a and b.
//
//Constraints:
//-----------
//1 <= n == nums.length <= 10^5
//1 <= nums[i] <= 10^​​​​​​​9

public class SumOfGCDOfFormedPairs 
{
	private int gcd(int n, int m)
	{
		if(m==0) {
			return n;
		}
		return gcd(m,n%m);
	}
	
	public long gcdSum(int[] nums)
	{
		int mx = 0;
		int[] prefGcd = new int[nums.length];
		for(int i=0;i<nums.length;i++) {
			if(mx<nums[i]) {
				mx = nums[i];
				prefGcd[i] = mx;
			}
			else {
				prefGcd[i] = gcd(nums[i],mx);
			}
		}
		Arrays.sort(prefGcd);
		long res = 0;
		for(int i=0,j=nums.length-1;i<j;i++,j--) {
			res+=gcd(prefGcd[i], prefGcd[j]);
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
		SumOfGCDOfFormedPairs Res = new SumOfGCDOfFormedPairs();
		System.out.print(Res.gcdSum(arr));
	}
}
