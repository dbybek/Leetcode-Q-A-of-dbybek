import java.util.*;

//2452. Words Within Two Edits of Dictionary (Medium)
//---------------------------------------------------
//You are given two string arrays, queries and dictionary.
//All words in each array comprise of lowercase English letters and have the same length.
//In one edit you can take a word from queries, and change any letter in it to any other letter.
//Find all words from queries that, after a maximum of two edits, equal some word from dictionary.
//Return a list of all words from queries, that match with some word from dictionary after a maximum of two edits.
//Return the words in the same order they appear in queries.
//
//Constraints:
//-----------
//1 <= queries.length, dictionary.length <= 100
//n == queries[i].length == dictionary[j].length
//1 <= n <= 100
//All queries[i] and dictionary[j] are composed of lowercase English letters.

public class WordsWithinTwoEditsOfDictionary 
{
	private boolean isMatch(String que, String[] dic)
	{
		int count = 0;
		for(String str:dic) {
			if(que.length()!=str.length()) {
				continue;
			}
			count = 0;
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i)!=que.charAt(i)) {
					count++;
				}
			}
			if(count<=2) {
				return true;
			}
		}
		return false;
	}
	
	public List<String> twoEditWords(String[] queries, String[] dictionary)
	{
		List<String> res = new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            if(isMatch(queries[i],dictionary)) {
            	res.add(queries[i]);
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
			arr[i] = sc.nextLine();
		}
		int M = sc.nextInt();
		String[] arr1 = new String[N];
		for(int i=0;i<M;i++) {
			arr1[i] = sc.nextLine();
		}
		sc.close();
		WordsWithinTwoEditsOfDictionary Res = new WordsWithinTwoEditsOfDictionary();
		System.out.println(Res.twoEditWords(arr, arr1));
	}
}
