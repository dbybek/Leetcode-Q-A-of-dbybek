import java.util.Scanner;

//2904. Shortest and Lexicographically Smallest Beautiful String (Medium)
//-----------------------------------------------------------------------
//You are given a binary string s and a positive integer k.
//A substring of s is beautiful if the number of 1's in it is exactly k.
//Let len be the length of the shortest beautiful substring.
//Return the lexicographically smallest beautiful substring of string s with length equal to len.
//If s doesn't contain a beautiful substring, return an empty string.
//A string a is lexicographically larger than a string b (of the same length) if in the first position where a and b differ, a has a character strictly larger than the corresponding character in b.
//For example,
//"abcd" is lexicographically larger than "abcc" because the first position they differ is at the fourth character,
//and d is greater than c.
//
//Constraints:
//-----------
//1 <= s.length <= 100
//1 <= k <= s.length

public class ShortestAndLexicographicallySmallestBeautifulString 
{
	public String shortestBeautifulSubstring(String s, int k)
	{
		String res = "";
        int l = 0, count = 0;
        for (int r=0;r<s.length();r++) {
            if (s.charAt(r) == '1') {
                count++;
            }
            while (count > k) {
                if (s.charAt(l) == '1') {
                    count--;
                }
                l++;
            }
            while (count==k && s.charAt(l)=='0') {
                l++;
            }

            if (count == k) {
                String str = s.substring(l, r+1);
                if (res.isEmpty() || str.length() < res.length() || (str.length() == res.length() && str.compareTo(res) < 0)) 
                {
                    res = str;
                }
            }
        }
        return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		int k = sc.nextInt();
		sc.close();
		ShortestAndLexicographicallySmallestBeautifulString Res = new ShortestAndLexicographicallySmallestBeautifulString();
		System.out.print(Res.shortestBeautifulSubstring(N, k));
	}
}
