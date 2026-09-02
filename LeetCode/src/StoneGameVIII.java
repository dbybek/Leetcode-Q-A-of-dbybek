import java.util.Scanner;

//1872. Stone Game VIII (Hard)
//----------------------------
//Alice and Bob take turns playing a game, with Alice starting first.
//There are n stones arranged in a row.
//On each player's turn, while the number of stones is more than one, they will do the following:
//Choose an integer x > 1, and remove the leftmost x stones from the row.
//Add the sum of the removed stones' values to the player's score.
//Place a new stone, whose value is equal to that sum, on the left side of the row.
//The game stops when only one stone is left in the row.
//The score difference between Alice and Bob is (Alice's score - Bob's score).
//Alice's goal is to maximize the score difference, and Bob's goal is the minimize the score difference.
//Given an integer array stones of length n where stones[i] represents the value of the ith stone from the left,
//return the score difference between Alice and Bob if they both play optimally.
//
//Constraints:
//-----------
//n == stones.length
//2 <= n <= 10^5
//-10^4 <= stones[i] <= 10^4

public class StoneGameVIII 
{
	public int stoneGameVIII(int[] stones)
	{
		int n = stones.length;
        for(int i=1;i<n;i++){
            stones[i] += stones[i-1];
        }
        int res = stones[n-1];
        for(int i=n-2;i>=1;i--){
            res = Math.max(res,stones[i]-res);
        }
        return res;
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
		StoneGameVIII Res = new StoneGameVIII();
		System.out.print(Res.stoneGameVIII(arr));
	}
}
