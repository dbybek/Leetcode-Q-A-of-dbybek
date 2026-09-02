import java.util.Scanner;

//3090. Maximum Length Substring With Two Occurrences (Easy)
//----------------------------------------------------------
//Given a string s,
//return the maximum length of a substring such that it contains at most two occurrences of each character.
//
//Constraints:
//-----------
//2 <= s.length <= 100
//s consists only of lowercase English letters.

public class MaximumLengthSubstringWithTwoOccurrences 
{
	public int maximumLengthSubstring(String s)
	{
		int[] freq = new int[26];
        int res = 0, start = 0;
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
            while(freq[s.charAt(i)-'a']>2){
                freq[s.charAt(start)-'a']--;
                start++;
            }
            res = Math.max(res, i-start+1);
        }
        return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		sc.close();
		MaximumLengthSubstringWithTwoOccurrences Res = new MaximumLengthSubstringWithTwoOccurrences();
		System.out.print(Res.maximumLengthSubstring(N));
	}
}
