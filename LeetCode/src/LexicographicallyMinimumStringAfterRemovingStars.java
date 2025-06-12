import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

//3170. Lexicographically Minimum String After Removing Stars (Medium)
//--------------------------------------------------------------------
//You are given a string s. It may contain any number of '*' characters. Your task is to remove all '*' characters.
//
//While there is a '*', do the following operation:
//
//Delete the leftmost '*' and the smallest non-'*' character to its left.
//If there are several smallest characters, you can delete any of them.
//Return the lexicographically smallest resulting string after removing all '*' characters.
//
//Constraints:
//-----------
//1 <= s.length <= 10^5
//s consists only of lowercase English letters and '*'.
//The input is generated such that it is possible to delete all '*' characters.

public class LexicographicallyMinimumStringAfterRemovingStars 
{

	public String clearStars(String s) 
	{
        char[] charr = s.toCharArray();
        List<List<Integer>> pos = new ArrayList<>();
        for(int i=0;i<26;i++) {
        	pos.add(new ArrayList<>());
        }
        PriorityQueue<Character> pq = new PriorityQueue<>();
        int n = charr.length;
        for(int i=0;i<n;i++) {
        	char ch = charr[i];
        	if(ch=='*') {
        		char sml = pq.peek();
        		List<Integer> lst = pos.get(sml-'a');
        		int j = lst.remove(lst.size()-1);
        		charr[j] = '*';
        		if(lst.isEmpty()) {
        			pq.poll();
        		}
        	}
        	else {
        		int chIndex = ch - 'a';
        		if(pos.get(chIndex).isEmpty()) {
        			pq.add(ch);
        		}
        		pos.get(chIndex).add(i);
        	}
        }
        StringBuilder res = new StringBuilder();
        for(char ch:charr) {
        	if(ch!='*') {
        		res.append(ch);
        	}
        }
        return res.toString();
    }
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();
		LexicographicallyMinimumStringAfterRemovingStars Res = new LexicographicallyMinimumStringAfterRemovingStars();
		System.out.print(Res.clearStars(str));
	}

}
