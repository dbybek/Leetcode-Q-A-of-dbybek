import java.util.Scanner;

//3403. Find the Lexicographically Largest String From the Box I (Medium)
//-----------------------------------------------------------------------
//You are given a string word, and an integer numFriends.
//
//Alice is organizing a game for her numFriends friends. There are multiple rounds in the game, where in each round:
//
//word is split into numFriends non-empty strings, such that no previous round has had the exact same split.
//All the split words are put into a box.
//Find the lexicographically largest string from the box after all the rounds are finished.
//
//Constraints:
//-----------
//1 <= word.length <= 5 * 10^3
//word consists only of lowercase English letters.
//1 <= numFriends <= word.length

public class FindTheLexicographicallyLargestStringFromTheBoxI 
{

	public String answerString(String word, int numFriends) 
	{
        if(numFriends==1) {
        	return word;
        }
        String res = "";
        int n = word.length(), len = n-numFriends+1;
        for(int i=0;i<n;i++) {
        	String temp;
        	if(len+i <= n) {
        		temp = word.substring(i, len+i);
        	}
        	else {
        		temp = word.substring(i);
        	}
        	if(temp.compareTo(res)>0) {
        		res = temp;
        	}
        }
        return res;
    }
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int N = sc.nextInt();
		sc.close();
		FindTheLexicographicallyLargestStringFromTheBoxI Res = new FindTheLexicographicallyLargestStringFromTheBoxI();
		System.out.print(Res.answerString(str, N));
	}
}
