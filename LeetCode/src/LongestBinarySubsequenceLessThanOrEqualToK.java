import java.util.Scanner;

//2311. Longest Binary Subsequence Less Than or Equal to K (Medium)
//-----------------------------------------------------------------
//You are given a binary string s and a positive integer k.
//Return the length of the longest subsequence of s that makes up a binary number less than or equal to k.
//
//Note:
//
//The subsequence can contain leading zeroes.
//The empty string is considered to be equal to 0.
//A subsequence is a string that can be derived from another string by deleting some or
//no characters without changing the order of the remaining characters.
//
//Constraints:
//-----------
//1 <= s.length <= 1000
//s[i] is either '0' or '1'.
//1 <= k <= 10^9

public class LongestBinarySubsequenceLessThanOrEqualToK 
{
	public int longestSubsequence(String s, int k)
	{
		int zeroCount = 0, oneCount = 0, decimalValue = 0, pow = 1, n = s.length();
		for(int i=0;i<n;i++) {
			if(s.charAt(i)=='0') {
				zeroCount++;
			}
		}
		
		for(int i=n-1;i>=0;i--) {
			if(s.charAt(i)=='1') {
				if(decimalValue+pow > k) {
					continue;
				}
				decimalValue += pow;
				oneCount++;
			}
			pow <<= 1;
			if(pow > k) {
				break;
			}
		}
		return zeroCount+oneCount;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int K = sc.nextInt();
		sc.close();
		LongestBinarySubsequenceLessThanOrEqualToK Res = new LongestBinarySubsequenceLessThanOrEqualToK();
		System.out.print(Res.longestSubsequence(str, K));
	}

}
