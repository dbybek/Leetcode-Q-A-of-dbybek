import java.util.Scanner;

//3713. Longest Balanced Substring I (Medium)
//-------------------------------------------
//You are given a string s consisting of lowercase English letters.
//A substring of s is called balanced if all distinct characters in the substring appear the same number of times.
//
//Return the length of the longest balanced substring of s.
//
//Return the length of the longest balanced subarray.
//
//Constraints:
//-----------
//1 <= s.length <= 1000
//s consists of lowercase English letters.

public class LongestBalancedSubstringI 
{
	public int longestBalanced(String s)
	{
		int n = s.length(), res = 0;
        for(int i=0;i<n && n-i+1>res;i++){
            int[] freq = new int[26];
            int distinct = 0, mx = 0;
            for(int j=i;j<n;j++){
                mx = Math.max(mx,++freq[s.charAt(j)-'a']);
                if(freq[s.charAt(j)-'a']==1){
                    distinct++;
                }
                if(j-i+1==distinct*mx){
                    res = Math.max(res,j-i+1);
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
		sc.close();
		LongestBalancedSubstringI Res = new LongestBalancedSubstringI();
		System.out.print(Res.longestBalanced(N));
	}
}
