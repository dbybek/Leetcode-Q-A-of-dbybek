import java.util.Scanner;

//1513. Number of Substrings With Only 1s (Medium)
//------------------------------------------------
//Given a binary string s, return the number of substrings with all characters 1's.
//Since the answer may be too large, return it modulo 10^9 + 7.
//
//Constraints:
//-----------
//1 <= s.length <= 10^5
//s[i] is either '0' or '1'.

public class NumberOfSubstringsWithOnly1s 
{
	public int numSub(String s)
	{
		long mod = 1000000007, res = 0, n = s.length(), countOfOne = 0;
		for(int i=0;i<n;i++) {
			if(s.charAt(i)=='1') {
				res = (res + ++countOfOne)%mod;
			}
			else {
				countOfOne = 0;
			}
		}
		return (int)(res%mod);
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		sc.close();
		NumberOfSubstringsWithOnly1s Res = new NumberOfSubstringsWithOnly1s();
		System.out.print(Res.numSub(N));
	}
}
