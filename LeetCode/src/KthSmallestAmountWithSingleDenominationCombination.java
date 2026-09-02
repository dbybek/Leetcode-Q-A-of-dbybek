import java.util.*;

//3116. Kth Smallest Amount With Single Denomination Combination (Hard)
//---------------------------------------------------------------------
//You are given an integer array coins representing coins of different denominations and an integer k.
//You have an infinite number of coins of each denomination.
//However, you are not allowed to combine coins of different denominations.
//Return the kth smallest amount that can be made using these coins.
//
//Constraints:
//-----------
//1 <= coins.length <= 15
//1 <= coins[i] <= 25
//1 <= k <= 2 * 10^9
//coins contains pairwise distinct integers.

public class KthSmallestAmountWithSingleDenominationCombination 
{
	private long gcd(long a, long b)
	{
		if(b==0) {
			return a;
		}
		return gcd(b,a%b);
	}
	
	private long calculateLcm(long a, long b)
	{
		return a/gcd(a,b)*b;
	}
	
	public long findKthSmallest(int[] coins, int k)
	{
		int n = coins.length;
		List<long[]> subset = new ArrayList<>();
		
		for(int i=1;i<(1<<n);i++) {
			long lcm = 1;
			int bits = 0;
			
			for(int j=0;j<n;j++) {
				if((i & (1<<j)) >0) {
					bits++;
					lcm = calculateLcm(lcm, coins[i]);
				}
			}
			
			subset.add(new long[] {lcm, (bits&1)==1?1:-1});
		}
		
		long mn = 25;
		for(int i=0;i<n;i++) {
			mn = Math.min(mn, coins[i]);
		}
		
		long l = 1, r = mn*(long)k;
		
		while(l < r) {
			long m = l + (r-l)/2;
			long count = 0;
			
			for(long[] sub:subset) {
				if(sub[0] <= m) {
					count+=sub[1] * (m/sub[0]);
				}
			}
			if(count>=k) {
				r = m;
			}
			else {
				l = m+1;
			}
		}
		return l;
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
		KthSmallestAmountWithSingleDenominationCombination Res = new KthSmallestAmountWithSingleDenominationCombination();
		System.out.print(Res.findKthSmallest(arr, k));
	}
}
