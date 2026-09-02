import java.util.Scanner;

//1406. Stone Game III (Hard)
//---------------------------
//Alice and Bob continue their games with piles of stones.
//There are several stones arranged in a row, and
//each stone has an associated value which is an integer given in the array stoneValue.
//Alice and Bob take turns, with Alice starting first.
//On each player's turn, that player can take 1, 2, or 3 stones from the first remaining stones in the row.
//The score of each player is the sum of the values of the stones taken.
//The score of each player is 0 initially.
//The objective of the game is to end with the highest score,
//and the winner is the player with the highest score and there could be a tie.
//The game continues until all the stones have been taken.
//Assume Alice and Bob play optimally.
//
//Return "Alice" if Alice will win, "Bob" if Bob will win, or "Tie" if they will end the game with the same score.
//
//Constraints:
//-----------
//1 <= stoneValue.length <= 5 * 10^4
//-1000 <= stoneValue[i] <= 1000

public class StoneGameIII 
{
//  Approach I: DP code
//	-------------------
//	private int maxScore(int i, int[] dp, int[] stoneValue)
//	{
//		if(i>=stoneValue.length) {
//			return 0;
//		}
//		if(dp[i] != Integer.MIN_VALUE) {
//			return dp[i];
//		}
//		int sum = 0;
//		for(int j=i;j<i+3 && j<stoneValue.length;j++) {
//			sum += stoneValue[j];
//			dp[i] = Math.max(dp[i], sum - maxScore(j+1,dp,stoneValue));
//		}
//		return dp[i];
//	}
	
	public String stoneGameIII(int[] stoneValue)
	{
//		Approach I: Using DP
//		--------------------
//		int[] dp = new int[stoneValue.length];
//		for(int i=0;i<stoneValue.length;i++) {
//			dp[i] = Integer.MIN_VALUE;
//		}
//		int res = maxScore(0, dp, stoneValue);
		
//		Appraoch II: As, we can only select either 1 or 2 or 3 values from the start, instead of keeping an DP array
//		             we can use just 3 variables and progress while updating those 3.
//		------------------------------------------------------------------------------------------------------------
		int suffSum = 0, select1 = 0, select2 = 0, select3 = 0;
		for(int i=stoneValue.length-1;i>=0;i--) {
			suffSum += stoneValue[i];
			int temp = suffSum - Math.min(Math.min(select1, select2), select3);
			select3 = select2;
			select2 = select1;
			select1 = temp;
		}
		int res = select1 - (suffSum - select1);
		if(res==0) {
			return "Tie";
		}
		return res>0?"Alice":"Bob";
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
		StoneGameIII Res = new StoneGameIII();
		System.out.print(Res.stoneGameIII(arr));
	}
}
