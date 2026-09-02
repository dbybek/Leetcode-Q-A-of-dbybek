import java.util.Scanner;

//877. Stone Game (Medium)
//------------------------
//Alice and Bob play a game with piles of stones.
//There are an even number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].
//The objective of the game is to end with the most stones.
//The total number of stones across all the piles is odd, so there are no ties.
//Alice and Bob take turns, with Alice starting first.
//Each turn, a player takes the entire pile of stones either from the beginning or from the end of the row.
//This continues until there are no more piles left, at which point the person with the most stones wins.
//Assuming Alice and Bob play optimally, return true if Alice wins the game, or false if Bob wins.
//
//Constraints:
//-----------
//2 <= piles.length <= 500
//piles.length is even.
//1 <= piles[i] <= 500
//sum(piles[i]) is odd.

public class StoneGame 
{
	public boolean stoneGame(int[] piles)
	{
		return true;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		StoneGame Res = new StoneGame();
		System.out.print(Res.stoneGame(arr));
	}
}
