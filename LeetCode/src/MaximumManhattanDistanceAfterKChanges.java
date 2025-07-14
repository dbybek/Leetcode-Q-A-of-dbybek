import java.util.Scanner;

//3443. Maximum Manhattan Distance After K Changes (Medium)
//---------------------------------------------------------
//You are given a string s consisting of the characters 'N', 'S', 'E', and 'W',
//where s[i] indicates movements in an infinite grid:
//
//'N' : Move north by 1 unit.
//'S' : Move south by 1 unit.
//'E' : Move east by 1 unit.
//'W' : Move west by 1 unit.
//Initially, you are at the origin (0, 0). You can change at most k characters to any of the four directions.
//
//Find the maximum Manhattan distance from the origin that can be achieved at any time 
//while performing the movements in order.
//
//The Manhattan Distance between two cells (xi, yi) and (xj, yj) is |xi - xj| + |yi - yj|.
//
//Constraints:
//-----------
//1 <= s.length <= 10^5
//0 <= k <= s.length
//s consists of only 'N', 'S', 'E', and 'W'.

public class MaximumManhattanDistanceAfterKChanges 
{
	
	public int maxDistance(String s, int k)
	{
		int N = 0, S = 0, E = 0, W = 0, res = 0;;
		for(int i=0;i<s.length();i++) {
			char ch = s.charAt(i);
			if(ch=='N') {
				N++;
			}
			else if(ch=='S') {
				S++;
			}
			else if(ch=='E') {
				E++;
			}
			else {
				W++;
			}
			int x = Math.abs(E-W), y = Math.abs(N-S);
			int manhattanDistance = x+y;
			int dist = manhattanDistance + Math.min(2*k, i+1-manhattanDistance);
			res = Math.max(res, dist);
		}
		return res;
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int K = sc.nextInt();
		sc.close();
		MaximumManhattanDistanceAfterKChanges Res = new MaximumManhattanDistanceAfterKChanges();
		System.out.print(Res.maxDistance(str, K));
	}

}
