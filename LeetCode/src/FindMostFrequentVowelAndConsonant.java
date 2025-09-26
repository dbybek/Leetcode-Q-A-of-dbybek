import java.util.Scanner;

//3541. Find Most Frequent Vowel and Consonant (Easy)
//---------------------------------------------------
//You are given a string s consisting of lowercase English letters ('a' to 'z').
//Your task is to:
//
//Find the vowel (one of 'a', 'e', 'i', 'o', or 'u') with the maximum frequency.
//Find the consonant (all other letters excluding vowels) with the maximum frequency.
//Return the sum of the two frequencies.
//
//Note: If multiple vowels or consonants have the same maximum frequency, you may choose any one of them.
//If there are no vowels or no consonants in the string, consider their frequency as 0.
//
//The frequency of a letter x is the number of times it occurs in the string.
//
//Constraints:
//-----------
//1 <= s.length <= 100
//s consists of lowercase English letters only.

public class FindMostFrequentVowelAndConsonant 
{
	public int maxFreqSum(String s)
	{
		int n = s.length();
        int[] freq = new int[26];
        for(int i=0;i<n;i++){
            freq[s.charAt(i)-'a']++;
        }
        int mxVowel = 0, mx = 0;
        for(int i=0;i<26;i++){
            if(i==0 || i==4 || i==8 || i==14 || i==20){
                mxVowel = Math.max(mxVowel,freq[i]);
            }
            else{
                mx = Math.max(mx,freq[i]);
            }
        }
        return mx+mxVowel;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		sc.close();
		FindMostFrequentVowelAndConsonant Res = new FindMostFrequentVowelAndConsonant();
		System.out.print(Res.maxFreqSum(N));
	}
}
