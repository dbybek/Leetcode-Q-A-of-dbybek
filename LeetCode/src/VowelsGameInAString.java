import java.util.Scanner;

//3227. Vowels Game in a String (Medium)
//--------------------------------------
//Alice and Bob are playing a game on a string.
//
//You are given a string s, Alice and Bob will take turns playing the following game where Alice starts first:
//
//On Alice's turn, she has to remove any non-empty substring from s that contains an odd number of vowels.
//On Bob's turn, he has to remove any non-empty substring from s that contains an even number of vowels.
//The first player who cannot make a move on their turn loses the game. We assume that both Alice and Bob play optimally.
//
//Return true if Alice wins the game, and false otherwise.
//
//The English vowels are: a, e, i, o, and u.
//
//Constraints:
//-----------
//1 <= s.length <= 10^5
//s consists only of lowercase English letters.

public class VowelsGameInAString 
{
	public boolean doesAliceWin(String s)
	{
		int n = s.length();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                return true;
            }
        }
        return false;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		sc.close();
		VowelsGameInAString Res = new VowelsGameInAString();
		System.out.print(Res.doesAliceWin(N));
	}
}
