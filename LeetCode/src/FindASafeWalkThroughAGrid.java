import java.util.*;

//3286. Find a Safe Walk Through a Grid (Medium)
//----------------------------------------------
//You are given an m x n binary matrix grid and an integer health.
//You start on the upper-left corner (0, 0) and would like to get to the lower-right corner (m - 1, n - 1).
//You can move up, down, left, or right from one cell to another adjacent cell as long as your health remains positive.
//Cells (i, j) with grid[i][j] = 1 are considered unsafe and reduce your health by 1.
//
//Return true if you can reach the final cell with a health value of 1 or more, and false otherwise.
//
//Constraints:
//-----------
//1 <= s.length <= 10^5
//s[i] is either '(' or ')'.
//s is a valid parentheses string.

public class FindASafeWalkThroughAGrid 
{
	public boolean findSafeWalk(List<List<Integer>> grid, int health)
	{
		int n = grid.size(), m = grid.get(0).size(), startHealth = health-grid.get(0).get(0);
		if(startHealth<1) {
			return false;
		}
		int[][] maxHealth = new int[n][m];
		for(int i=0;i<n;i++) {
			Arrays.fill(maxHealth[i], -1);
		}
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0,0,startHealth});
		maxHealth[0][0] = startHealth;
		int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int i = curr[0], j = curr[1], currHealth = curr[2];
			if(i==n-1 && j==n-1 && currHealth>=1) {
				return true;
			}
			for(int k=0;k<4;k++) {
				int ni = i+dir[k][0], nj = j+dir[k][1];
				if(ni>=0 && ni<n && nj>=0 && nj<m) {
					int newHealth = currHealth - grid.get(ni).get(nj);
					if(newHealth < 1) {
						continue;
					}
					if(newHealth <= maxHealth[ni][nj]) {
						continue;
					}
					maxHealth[ni][nj] = newHealth;
					q.offer(new int[]{ni,nj,newHealth});
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		List<List<Integer>> arr = new ArrayList<>();
		for(int i=0;i<N;i++) {
			List<Integer> temp = new ArrayList<>();
			for(int j=0;j<M;j++) {
				temp.add(sc.nextInt());
			}
			arr.add(temp);
		}
		int k = sc.nextInt();
		sc.close();
		FindASafeWalkThroughAGrid Res = new FindASafeWalkThroughAGrid();
		System.out.print(Res.findSafeWalk(arr, k));
	}
}
