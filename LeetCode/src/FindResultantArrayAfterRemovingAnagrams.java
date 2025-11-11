import java.util.*;

//2273. Find Resultant Array After Removing Anagrams (Easy)
//---------------------------------------------------------
//You are given a 0-indexed string array words, where words[i] consists of lowercase English letters.
//In one operation, select any index i such that 0 < i < words.length and words[i - 1] and words[i] are anagrams,
//and delete words[i] from words.
//Keep performing this operation as long as you can select an index that satisfies the conditions.
//Return words after performing all operations.
//It can be shown that selecting the indices for each operation in any arbitrary order will lead to the same result.
//
//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase using all the 
//original letters exactly once. For example, "dacb" is an anagram of "abdc".
//
//Constraints:
//-----------
//1 <= words.length <= 100
//1 <= words[i].length <= 10
//words[i] consists of lowercase English letters.

public class FindResultantArrayAfterRemovingAnagrams 
{
	private boolean checkAnagram(String s1, String s2)
	{
		int n = s1.length();
		if(n!=s2.length()) {
			return false;
		}
        int[] freq = new int[26];
		for(int i=0;i<n;i++) {
			char ch1 = s1.charAt(i), ch2 = s2.charAt(i);
			freq[ch1-'a']++;
            freq[ch2-'a']--;
		}
		for(int i=0;i<26;i++){
            if(freq[i]!=0){
                return false;
            }
        }
        return true;
	}
	
	public List<String> removeAnagrams(String[] words)
	{
		int n = words.length;
		List<String> res = new ArrayList<>();
		res.add(words[0]);
		for(int i=1;i<n;i++) {
			if(!checkAnagram(words[i],words[i-1])) {
				res.add(words[i]);
			}
		}
		return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] arr = new String[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.next();
		}
		sc.close();
		FindResultantArrayAfterRemovingAnagrams Res = new FindResultantArrayAfterRemovingAnagrams();
		System.out.print(Res.removeAnagrams(arr));
	}
}
