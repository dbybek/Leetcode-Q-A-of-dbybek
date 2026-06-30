import java.util.Scanner;

//3093. Longest Common Suffix Queries (Hard)
//------------------------------------------
//You are given two arrays of strings wordsContainer and wordsQuery.
//For each wordsQuery[i],
//you need to find a string from wordsContainer that has the longest common suffix with wordsQuery[i].
//If there are two or more strings in wordsContainer that share the longest common suffix,
//find the string that is the smallest in length.
//If there are two or more such strings that have the same smallest length,
//find the one that occurred earlier in wordsContainer.
//Return an array of integers ans,
//where ans[i] is the index of the string in wordsContainer that has the longest common suffix with wordsQuery[i].
//Constraints:
//-----------
//1 <= wordsContainer.length, wordsQuery.length <= 10^4
//1 <= wordsContainer[i].length <= 5 * 10^3
//1 <= wordsQuery[i].length <= 5 * 10^3
//wordsContainer[i] consists only of lowercase English letters.
//wordsQuery[i] consists only of lowercase English letters.
//Sum of wordsContainer[i].length is at most 5 * 10^5.
//Sum of wordsQuery[i].length is at most 5 * 10^5.

class TrieNode {
    TrieNode[] children;
    int best;
    int len;
    public TrieNode (){
        children = new TrieNode[26];
        best = -1;
        len = 100000;
    }
}

public class LongestCommonSuffixQueries 
{
	private TrieNode root = new TrieNode();
	
	private void insert(int ind, String str)
    {
        TrieNode curr = root;
        int n = str.length();
        for(int i=n-1;i>=0;i--){
            int ch = str.charAt(i)-'a';
            if(curr.children[ch]==null){
                curr.children[ch] = new TrieNode();
            }
            curr = curr.children[ch];
            if(curr.best==-1 || n<curr.len){
                curr.best = ind;
                curr.len = n;
            }
        }
    }

    private int search(String str)
    {
        TrieNode curr = root;
        int lstBest = -1;
        for(int i=str.length()-1;i>=0;i--){
            int ch = str.charAt(i)-'a';
            if(curr.children[ch]==null){
                break;
            }
            curr = curr.children[ch];
            lstBest = curr.best;
        }
        return lstBest;
    }
	
	public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) 
	{
		int mnInd = 0;
        for(int i=0;i<wordsContainer.length;i++){
            insert(i,wordsContainer[i]);
            if(wordsContainer[i].length() < wordsContainer[mnInd].length()){
                mnInd = i;
            }
        }
        int[] res = new int[wordsQuery.length];
        for(int i=0;i<wordsQuery.length;i++){
            int ind = search(wordsQuery[i]);
            res[i] = (ind==-1)?mnInd:ind;
        }
        return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] arr1 = new String[N];
		for(int i=0;i<N;i++) {
			arr1[i] = sc.nextLine();
		}
		int M = sc.nextInt();
		String[] arr2 = new String[N];
		for(int i=0;i<M;i++) {
			arr2[i] = sc.nextLine();
		}
		sc.close();
		LongestCommonSuffixQueries Res = new LongestCommonSuffixQueries();
		int[] arr3 = Res.stringIndices(arr1, arr2);
		for(int ele:arr3) {
			System.out.print(ele+" ");
		}
	}
}
