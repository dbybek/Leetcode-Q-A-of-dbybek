import java.util.Scanner;

//3312. Sorted GCD Pair Queries (Hard)
//------------------------------------
//You are given an integer array nums of length n and an integer array queries.
//Let gcdPairs denote an array obtained by calculating the GCD of all possible pairs (nums[i], nums[j]),
//where 0 <= i < j < n, and then sorting these values in ascending order.
//For each query queries[i], you need to find the element at index queries[i] in gcdPairs.
//Return an integer array answer, where answer[i] is the value at gcdPairs[queries[i]] for each query.
//
//The term gcd(a, b) denotes the greatest common divisor of a and b.
//
//Constraints:
//-----------
//2 <= n == nums.length <= 10^5
//1 <= nums[i] <= 5 * 10^4
//1 <= queries.length <= 10^5
//0 <= queries[i] < n * (n - 1) / 2

public class SortedGCDPairQueries 
{
	public int[] gcdValues(int[] nums, long[] queries)
	{
		int mx = 0;
        for(int ele:nums){
            mx = Math.max(mx,ele);
        }

        int[] freq = new int[mx+1];
        for(int ele:nums){
            freq[ele]++;
        }

        long[] divisorCount = new long[mx+1];
        for(int i=1;i<=mx;i++){
            for(int j=i;j<=mx;j+=i){
                divisorCount[i]+=freq[j];
            }
        }

        long[] pairs = new long[mx+1];
        for(int i=mx;i>0;i--){
            pairs[i] = divisorCount[i]*(divisorCount[i]-1)/2;
            for(int j=i*2;j<=mx;j+=i){
                pairs[i]-=pairs[j];
            }
        }

        long[] pref = new long[mx+1];
        for(int i=1;i<=mx;i++){
            pref[i] = pref[i-1]+pairs[i];
        }

        int[] res = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int low = 1, high = mx;
            while(low<high){
                int mid = low+(high-low)/2;
                if(pref[mid]>=queries[i]+1){
                    high = mid;
                }
                else{
                    low = mid+1;
                }
            }
            res[i] = low;
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
		int M = sc.nextInt();
		long[] arr1 = new long[M];
		for(int i=0;i<M;i++) {
			arr1[i] = sc.nextLong();
		}
		sc.close();
		SortedGCDPairQueries Res = new SortedGCDPairQueries();
		int[] arr2 = Res.gcdValues(arr, arr1);
		for(int ele:arr2) {
			System.out.print(ele+" ");
		}
	}
}
