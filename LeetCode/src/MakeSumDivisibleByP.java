import java.util.*;

//1590. Make Sum Divisible by P (Medium)
//--------------------------------------
//Given an array of positive integers nums, remove the smallest subarray (possibly empty)
//such that the sum of the remaining elements is divisible by p. It is not allowed to remove the whole array.
//Return the length of the smallest subarray that you need to remove, or -1 if it's impossible.
//
//A subarray is defined as a contiguous block of elements in the array.
//
//Constraints:
//-----------
//1 <= nums.length <= 10^5
//1 <= nums[i] <= 10^9
//1 <= p <= 10^9

public class MakeSumDivisibleByP 
{
	public int minSubarray(int[] nums, int p)
	{
		int n = nums.length;
		int[] prefixSum = new int[n+1];
		for(int i=1;i<=n;i++) {
			prefixSum[i] = (prefixSum[i-1]+nums[i-1])%p;
		}
		if(prefixSum[n]==0) {
			return 0;
		}
		HashMap<Integer,Integer> hm = new HashMap<>();
		hm.put(0, 0);
		int res = n+1;
		for(int i=1;i<=n;i++) {
			int temp = (prefixSum[i]-prefixSum[n]+p)%p;
			if(hm.containsKey(temp)) {
				res = Math.min(res, i-hm.get(temp));
			}
			hm.put(prefixSum[i],i);
		}
		return (res>=n)?-1:res;
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
		MakeSumDivisibleByP Res = new MakeSumDivisibleByP();
		System.out.print(Res.minSubarray(arr, k));
	}
}
