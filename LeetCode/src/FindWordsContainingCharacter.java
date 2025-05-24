import java.util.*;

//2942. Find Words Containing Character (Easy)
//--------------------------------------------
//You are given a 0-indexed array of strings words and a character x.
//Return an array of indices representing the words that contain the character x.
//
//Note that the returned array may be in any order.
//
//Constraints:
//-----------
//1 <= words.length <= 50
//1 <= words[i].length <= 50
//x is a lowercase English letter.
//words[i] consists only of lowercase English letters.

public class FindWordsContainingCharacter 
{
	public List<Integer> findWordsContaining(String[] words, char x) 
	{
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<words.length;i++) {
//        	Approach I: Using chars() method along with count() method to get the count of the character.
//        	---------------------------------------------------------------------------------------------
//        	if(words[i].chars().filter(ch->ch==x).count()>0) {
//        		res.add(i);
//        	}
//        	
//        	Approach II: Using indexOf() method.
//        	------------------------------------
        	if(words[i].indexOf(x) != -1) {
        		res.add(i);
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
		char e = sc.next().charAt(0);
		sc.close();
		FindWordsContainingCharacter Res = new FindWordsContainingCharacter();
		System.out.print(Res.findWordsContaining(arr, e));
	}

}
