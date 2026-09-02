import java.util.Scanner;

//2029. Stone Game IX (Medium)
//----------------------------
//Alice and Bob continue their games with stones.
//There is a row of n stones, and each stone has an associated value.
//You are given an integer array stones, where stones[i] is the value of the ith stone.
//Alice and Bob take turns, with Alice starting first.
//On each turn, the player may remove any stone from stones.
//The player who removes a stone loses if the sum of the values of all removed stones is divisible by 3.
//Bob will win automatically if there are no remaining stones (even if it is Alice's turn).
//Assuming both players play optimally, return true if Alice wins and false if Bob wins.
//
//Constraints:
//-----------
//1 <= stones.length <= 10^5
//1 <= stones[i] <= 10^4

public class StoneGameIX 
{
	public boolean stoneGameIX(int[] stones)
	{
		int[] freq = new int[3];
		for(int ele:stones){
			freq[ele%3]++;
		}
		if(freq[0]%2==0) {
			return freq[1]>0 && freq[2]>0;
		}
		
		return Math.abs(freq[1]-freq[2])>2;
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
		StoneGameIX Res = new StoneGameIX();
		System.out.print(Res.stoneGameIX(arr));
	}
}
