import java.util.*;

//3664. Two-Letter Card Game (Medium)
//-----------------------------------
//You are given a deck of cards represented by a string array cards, and each card displays two lowercase letters.
//
//You are also given a letter x. You play a game with the following rules:
//
//Start with 0 points.
//On each turn, you must find two compatible cards from the deck that both contain the letter x in any position.
//Remove the pair of cards and earn 1 point.
//The game ends when you can no longer find a pair of compatible cards.
//Return the maximum number of points you can gain with optimal play.
//
//Two cards are compatible if the strings differ in exactly 1 position.
//
//Constraints:
//-----------
//2 <= cards.length <= 10^5
//cards[i].length == 2
//Each cards[i] is composed of only lowercase English letters between 'a' and 'j'.
//x is a lowercase English letter between 'a' and 'j'.

public class TwoLetterCardGame 
{
	public int score(String[] cards, char x)
	{
		HashMap<Integer,Integer> hm = new HashMap<>();
		int n = cards.length;
		for(int i=0;i<n;i++) {
			int ind = (cards[i].charAt(0)==x)?((cards[i].charAt(1)==x)?2:0):((cards[i].charAt(1)==x)?1:-1);
			hm.put(i, ind);
		}
		int res = 0;
		for(int i=0;i<n-1;) {
			int ind = hm.get(i), ind1 = hm.get(i+1);
			if(ind>-1 && ind1>-1) {
				if(ind==2 || ind1==2 || ind==ind1) {
					res++;
					i+=2;
					continue;
				}
			}
			i++;
		}
		return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char k = sc.next().charAt(0);
		String[] arr = new String[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextLine();
		}
		sc.close();
		TwoLetterCardGame Res = new TwoLetterCardGame();
		System.out.print(Res.score(arr, k));
	}
}
