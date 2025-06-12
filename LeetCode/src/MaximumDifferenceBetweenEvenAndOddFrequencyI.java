import java.util.Scanner;

//3442. Maximum Difference Between Even and Odd Frequency I (Easy)
//----------------------------------------------------------------
//You are given a string s consisting of lowercase English letters.
//Your task is to find the maximum difference diff = freq(a1) - freq(a2) between
//the frequency of characters a1 and a2 in the string such that:
//
//a1 has an odd frequency in the string.
//a2 has an even frequency in the string.
//Return this maximum difference. 
//
//Constraints:
//-----------
//3 <= s.length <= 100
//s consists only of lowercase English letters.
//s contains at least one character with an odd frequency and one with an even frequency.

public class MaximumDifferenceBetweenEvenAndOddFrequencyI 
{

	public int maxDifference(String s)
	{
		int[] freq = new int[26];
		for(int i=0;i<s.length();i++) {
			char ch = s.charAt(i);
			freq[ch-'a']++;
		}
		int mxOdd = -1, mnOdd = 101, mxEven = -1, mnEven = 101;
		for(int i=0;i<26;i++) {
			if(freq[i]==0) {
				continue;
			}
			if(freq[i]%2==0) {
				mxEven = Math.max(mxEven, freq[i]);
				mnEven = Math.min(mnEven, freq[i]);
			}
			else {
				mxOdd = Math.max(mxOdd, freq[i]);
				mnOdd = Math.min(mnOdd, freq[i]);
			}
		}
		return ((mxOdd-mnEven) > (mnOdd-mxEven))?(mxOdd-mnEven):(mnOdd-mxEven);
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();
		MaximumDifferenceBetweenEvenAndOddFrequencyI Res = new MaximumDifferenceBetweenEvenAndOddFrequencyI();
		System.out.print(Res.maxDifference(str));
	}

}
