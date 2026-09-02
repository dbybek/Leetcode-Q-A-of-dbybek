import java.util.Scanner;

//3720. Lexicographically Smallest Permutation Greater Than Target (Medium)
//-------------------------------------------------------------------------
//You are given two strings s and target, both having length n, consisting of lowercase English letters.
//Return the lexicographically smallest permutation of s that is strictly greater than target.
//If no permutation of s is lexicographically strictly greater than target, return an empty string.
//A string a is lexicographically strictly greater than a string b (of the same length)
//if in the first position where a and b differ,
//string a has a letter that appears later in the alphabet than the corresponding letter in b.
//
//Constraints:
//-----------
//1 <= s.length == target.length <= 300
//s and target consist of only lowercase English letters.

public class LexicographicallySmallestPermutationGreaterThanTarget 
{
	public String lexGreaterPermutation(String s, String target)
	{
		int[] freq = new int[26];
        int n = s.length();
        for(int i=0;i<n;i++){
            freq[s.charAt(i)-'a']++;
        }
        StringBuilder res = new StringBuilder(), pref = new StringBuilder();
        for(int i=0;i<n;i++){
            if(freq[target.charAt(i)-'a']==0){
                break;
            }
            freq[target.charAt(i)-'a']--;
            pref.append(target.charAt(i));
        }

        if(pref.length()<n){
            for(int i=target.charAt(pref.length())-'a'+1;i<26;i++){
                if(freq[i]==0){
                    continue;
                }
                res.append(pref);
                res.append((char)('a'+i));
                freq[i]--;
                for(int j=0;j<26;j++){
                    for(int k=0;k<freq[j];k++){
                        res.append((char)('a'+j));
                    }
                }
                return res.toString();
            }
        }

        for(int i=pref.length()-1;i>=0;i--){
            freq[pref.charAt(i)-'a']++;
            pref.deleteCharAt(pref.length()-1);

            for(int j=target.charAt(i)-'a'+1;j<26;j++){
                if(freq[j]==0){
                    continue;
                }
                res.append(pref);
                res.append((char)('a'+j));
                freq[j]--;
                for (int k = 0; k < 26; k++) {
                    for (int t = 0; t < freq[k]; t++) {
                        res.append((char)('a'+k));
                    }
                }
                return res.toString();
            }
        }
        return "";
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String N = sc.nextLine(), M = sc.nextLine();
		sc.close();
		LexicographicallySmallestPermutationGreaterThanTarget Res = new LexicographicallySmallestPermutationGreaterThanTarget();
		System.out.print(Res.lexGreaterPermutation(N, M));
	}
}
