import java.util.*;

//3760. Maximum Substrings With Distinct Start (Medium)
//-----------------------------------------------------
//You are given a string s consisting of lowercase English letters.
//Return an integer denoting the maximum number of substrings you can split s into such that each substring
//starts with a distinct character (i.e., no two substrings start with the same character).
//
//Constraints:
//-----------
//1 <= s.length <= 10^5
//s consists of lowercase English letters.

public class MaximumSubstringsWithDistinctStart 
{
	public int maxDistinct(String s)
	{
		HashSet<Character> hs = new HashSet<>();
        for(int i=0;i<s.length();i++){
            hs.add(s.charAt(i));
        }
        return hs.size();
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();
		MaximumSubstringsWithDistinctStart Res = new MaximumSubstringsWithDistinctStart();
		System.out.print(Res.maxDistinct(str));
	}
}
