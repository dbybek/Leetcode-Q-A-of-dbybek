import java.util.Scanner;

//1510. Stone Game IV (Hard)
//--------------------------
//Alice and Bob take turns playing a game, with Alice starting first.
//Initially, there are n stones in a pile.
//On each player's turn, that player makes a move consisting of removing any non-zero square number of stones in the pile.
//Also, if a player cannot make a move, he/she loses the game.
//Given a positive integer n, return true if and only if Alice wins the game otherwise return false,
//assuming both players play optimally.
//
//Constraints:
//-----------
//1 <= n <= 10^5

public class StoneGameIV 
{
	public boolean winnerSquareGame(int n)
	{
		boolean[] dp = new boolean[n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j*j<=i;j++){
                if(!dp[i-j*j]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		StoneGameIV Res = new StoneGameIV();
		System.out.print(Res.winnerSquareGame(N));
	}
}
