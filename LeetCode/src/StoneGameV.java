import java.util.Scanner;

//1563. Stone Game V (Hard)
//-------------------------
//There are several stones arranged in a row,
//and each stone has an associated value which is an integer given in the array stoneValue.
//In each round of the game, Alice divides the row into two non-empty rows (i.e. left row and right row),
//then Bob calculates the value of each row which is the sum of the values of all the stones in this row.
//Bob throws away the row which has the maximum value, and Alice's score increases by the value of the remaining row.
//If the value of the two rows are equal, Bob lets Alice decide which row will be thrown away.
//The next round starts with the remaining row.
//The game ends when there is only one stone remaining. Alice's score is initially zero.
//Return the maximum score that Alice can obtain.
//
//Constraints:
//-----------
//1 <= stoneValue.length <= 500
//1 <= stoneValue[i] <= 10^6

public class StoneGameV 
{
	public int stoneGameV(int[] stoneValue)
	{
		int n = stoneValue.length;
        int[] pref = new int[n+1];
		for(int i=0;i<n;i++) {
			pref[i+1] = pref[i] + stoneValue[i];
		}
		int[][] dp = new int[n][n];
		for(int left=n-1;left>=0;left--) {
			for(int right=0;right<n;right++) {
				int total = pref[right+1] - pref[left];
				int mx = 0;
				for(int i=left;i<right;i++) {
					int s1 = pref[i+1] - pref[left], s2 = total - s1;
					
					if(s1==s2) {
						mx = Math.max(mx, Math.max(s1+dp[i+1][right], s2+dp[left][i]));
					}
					else if(s1<s2) {
						mx = Math.max(mx, s1+dp[left][i]);
					}
					else {
						mx = Math.max(mx, s2+dp[i+1][right]);
					}
				}
				dp[left][right] = mx;
			}
		}
		return dp[0][n-1];
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
		StoneGameV Res = new StoneGameV();
		System.out.print(Res.stoneGameV(arr));
	}
}
