import java.util.Scanner;

//3517. Smallest Palindromic Rearrangement I (Medium)
//---------------------------------------------------
//You are given a palindromic string s.
//Return the lexicographically smallest palindromic permutation of s.
//
//Constraints:
//-----------
//1 <= s.length <= 10^5
//s consists of lowercase English letters.
//s is guaranteed to be palindromic.

public class SmallestPalindromicRearrangementI 
{
	public String smallestPalindrome(String s)
	{
		int[] freq = new int[26];
		for(int i=0;i<s.length();i++) {
			freq[s.charAt(i)-'a']++;
		}
		StringBuilder res = new StringBuilder();
		for(int i=0;i<26;i++) {
			while(freq[i]>1) {
				res.append((char)('a'+i));
				freq[i]-=2;
			}
		}
		StringBuilder rev = new StringBuilder();
		rev.append(res);
		for(int i=0;i<26;i++) {
			while(freq[i]>0) {
				res.append((char)('a'+i));
				freq[i]--;
			}
		}
		res.append(rev.reverse());
		return res.toString();
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		sc.close();
		SmallestPalindromicRearrangementI Res = new SmallestPalindromicRearrangementI();
		System.out.print(Res.smallestPalindrome(N));
	}
}
