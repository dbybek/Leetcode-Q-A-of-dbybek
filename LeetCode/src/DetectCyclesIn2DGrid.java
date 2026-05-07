import java.util.Scanner;

//1559. Detect Cycles in 2D Grid (Medium)
//---------------------------------------
//Given a 2D array of characters grid of size m x n,
//you need to find if there exists any cycle consisting of the same value in grid.
//A cycle is a path of length 4 or more in the grid that starts and ends at the same cell.
//From a given cell, you can move to one of the cells adjacent to it - in one of the four directions
//(up, down, left, or right), if it has the same value of the current cell.
//Also, you cannot move to the cell that you visited in your last move.
//For example, the cycle (1, 1) -> (1, 2) -> (1, 1) is invalid because from (1, 2) we visited (1, 1)
//which was the last visited cell.
//
//Return true if any cycle of the same value exists in grid, otherwise, return false.
//
//Constraints:
//-----------
//m == grid.length
//n == grid[i].length
//1 <= m, n <= 500
//grid consists only of lowercase English letters.

public class DetectCyclesIn2DGrid 
{
	int[] dx = {1,-1,0,0};
	int[] dy = {0,0,1,-1};
	
	private boolean dfs(int x, int y, int px, int py, char[][] g, boolean[][] vis)
	{
		vis[x][y] = true;
		int n = g.length, m = g[0].length;
		for(int d=0;d<4;d++) {
			int nx = x+dx[d], ny = y+dy[d];
			if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
				continue;
			}
			if(g[nx][ny] != g[x][y]) {
				continue;
			}
			if(vis[x][y] && !(nx==px && ny==py)) {
				return true;
			}
			if(vis[x][y]) {
				continue;
			}
			if(dfs(nx,ny,x,y,g,vis)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean containsCycle(char[][] grid)
	{
		int n = grid.length, m = grid[0].length;
		boolean[][] visited = new boolean[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(visited[i][j]) {
					continue;
				}
				if(dfs(i,j,-1,-1,grid,visited)) {
					return true;
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
		char[][] arr = new char[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				arr[i][j] = sc.next().charAt(0);
			}
		}
		sc.close();
		DetectCyclesIn2DGrid Res = new DetectCyclesIn2DGrid();
		System.out.print(Res.containsCycle(arr));
	}
}
