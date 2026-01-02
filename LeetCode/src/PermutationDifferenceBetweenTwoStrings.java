import java.util.Scanner;

//3146. Permutation Difference between Two Strings (Easy)
//-------------------------------------------------------
//You are given two strings s and t such that every character occurs at most once in s and t is a permutation of s.
//The permutation difference between s and t is defined as the sum of the absolute difference between
//the index of the occurrence of each character in s and the index of the occurrence of the same character in t.
//
//Return the permutation difference between s and t.
//
//Constraints:
//-----------
//1 <= s.length <= 26
//Each character occurs at most once in s.
//t is a permutation of s.
//s consists only of lowercase English letters.

public class PermutationDifferenceBetweenTwoStrings 
{
	public int findPermutationDifference(String s, String t)
	{
		int[] ind = new int[26];
        for(int i=0;i<s.length();i++){
            ind[s.charAt(i)-'a'] = i;
        }
        int res = 0;
        for(int i = 0;i<t.length();i++){
            res+=Math.abs(i-ind[t.charAt(i)-'a']);
        }
        return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine(), str1 = sc.next();
		sc.close();
		PermutationDifferenceBetweenTwoStrings Res = new PermutationDifferenceBetweenTwoStrings();
		System.out.print(Res.findPermutationDifference(str, str1));
	}
}
