import java.util.Scanner;

//3756. Concatenate Non-Zero Digits and Multiply by Sum II (Medium)
//-----------------------------------------------------------------
//You are given a string s of length m consisting of digits.
//You are also given a 2D integer array queries, where queries[i] = [li, ri].
//For each queries[i], extract the substring s[li..ri]. Then, perform the following:
//Form a new integer x by concatenating all the non-zero digits from the substring in their original order.
//If there are no non-zero digits, x = 0.
//Let sum be the sum of digits in x. The answer is x * sum.
//Return an array of integers answer where answer[i] is the answer to the ith query.
//
//Since the answers may be very large, return them modulo 109 + 7.
//
//Constraints:
//-----------
//1 <= m == s.length <= 10^5
//s consists of digits only.
//1 <= queries.length <= 10^5
//queries[i] = [li, ri]
//0 <= li <= ri < m

public class ConcatenateNonZeroDigitsAndMultiplyBySumII 
{
	// Fast Binary Exponentiation: computes (a^b) % MOD
    private long power(long a, long b) 
    {
        long p = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
            	p = (p*a)%1000000007;
            }
            a = (a*a)%1000000007;
            b>>= 1;
        }
        return p;
    }
    
	public int[] sumAndMultiply(String s, int[][] queries)
	{
//		long[] pref = new long[s.length()];
//        pref[0] = s.charAt(0)-'0';
//        for(int i=1;i<s.length();i++){
//            pref[i] = pref[i-1]+(long)(s.charAt(i)-'0');
//        }
//        int[] res = new int[queries.length];
//        for(int i=0;i<queries.length;i++) {
//        	long x = 0;
//        	for(int j=queries[i][0];j<=queries[i][1];j++) {
//        		if(s.charAt(j)!='0') {
//        			x*=10;
//        			x+=(long)(s.charAt(j)-'0');
//        		}
//        	}
//        	long sum = (queries[i][0]>0)?pref[queries[i][1]]-pref[queries[i][0]-1]:pref[queries[i][1]];
//        	res[i] = (int)(((sum%1000000007)*(x%1000000007))%1000000007);
//        	res[i] = (int)((sum*x)%1000000007);
//        }
//        return res;
		int n = s.length();
        // Prefix sum of non-zero digits
        long[] prefSum = new long[n];
        // Prefix number formed by concatenating non-zero digits (mod MOD)
        long[] prefNonZeroNum = new long[n];
        // Prefix count of non-zero digits
        long[] prefNonZeroCnt = new long[n];
        // Build prefix arrays
        for (int i = 0; i < n; i++) {
            int digit = s.charAt(i) - '0';
            // Copy previous prefix values
            if (i > 0) {
                prefSum[i] = prefSum[i - 1];
                prefNonZeroNum[i] = prefNonZeroNum[i - 1];
                prefNonZeroCnt[i] = prefNonZeroCnt[i - 1];
            }
            // Ignore zeros since they don't contribute
            if (digit != 0) {
                // Update prefix digit sum
                prefSum[i] = (prefSum[i-1]+digit)%1000000007;
                // Increase count of non-zero digits
                prefNonZeroCnt[i] = prefNonZeroCnt[i-1]+1;
                // Append current digit to the prefix number
                prefNonZeroNum[i] = (prefNonZeroNum[i-1]*10 + digit)%1000000007;
            }
        }

        int[] res = new int[queries.length];
        // Process each query independently
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            // Sum of non-zero digits in the substring
            long sum = prefSum[r] - (l > 0 ? prefSum[l - 1] : 0);
            sum = (sum%1000000007 + 1000000007)%1000000007;
            // Number of non-zero digits in the substring
            long cnt = prefNonZeroCnt[r]-(l>0 ? prefNonZeroCnt[l-1]:0);
            // Extract the concatenated non-zero number of the substring
            long x = prefNonZeroNum[r]-(l>0 ? (prefNonZeroNum[l-1]*power(10, cnt))%1000000007:0);
            x = (x%1000000007 + 1000000007)%1000000007;

            // Required answer = number × digit sum
            res[i] = (int) ((sum*x)%1000000007);
        }

        return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][2];
		for(int i=0;i<N;i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		String str = sc.next();
		sc.close();
		ConcatenateNonZeroDigitsAndMultiplyBySumII Res = new ConcatenateNonZeroDigitsAndMultiplyBySumII();
		int[] arr1 = Res.sumAndMultiply(str, arr);
		for(int i=0;i<N;i++) {
			System.out.print(arr1[i]+" ");
		}
	}
}
