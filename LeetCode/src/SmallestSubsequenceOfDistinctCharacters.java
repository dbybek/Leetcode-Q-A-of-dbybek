import java.util.Scanner;

//1081. Smallest Subsequence of Distinct Characters (Medium)
//----------------------------------------------------------
//Given a string s,
//return the lexicographically smallest subsequence of s that contains all the distinct characters of s exactly once.
//
//Constraints:
//-----------
//1 <= s.length <= 1000
//s consists of lowercase English letters.

public class SmallestSubsequenceOfDistinctCharacters 
{
	public String smallestSubsequence(String s)
	{
		int[] ind = new int[26];
        boolean[] seen = new boolean[26];
        for(int i=0;i<s.length();i++){
            ind[s.charAt(i)-'a'] = i;
        }
        StringBuilder res = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(seen[ch-'a']){
                continue;
            }
            while(res.length()>0 && res.charAt(res.length()-1)>ch && ind[res.charAt(res.length()-1)-'a']>i){
            	seen[res.charAt(res.length()-1)-'a'] = false;
            	res.setLength(res.length()-1);
            }
            res.append(ch);
            seen[ch-'a'] = true;
        }
        return res.toString();
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		sc.close();
		SmallestSubsequenceOfDistinctCharacters Res = new SmallestSubsequenceOfDistinctCharacters();
		System.out.print(Res.smallestSubsequence(N));
	}
}
