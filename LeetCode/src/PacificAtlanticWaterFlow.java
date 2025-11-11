import java.util.*;

//417. Pacific Atlantic Water Flow (Medium)
//-----------------------------------------
//There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean.
//The Pacific Ocean touches the island's left and top edges,
//and the Atlantic Ocean touches the island's right and bottom edges.
//The island is partitioned into a grid of square cells.
//You are given an m x n integer matrix heights where 
//heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
//The island receives a lot of rain, and the rain water can flow to neighboring cells 
//directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height.
//Water can flow from any cell adjacent to an ocean into the ocean.
//Return a 2D list of grid coordinates result 
//where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
//
//Constraints:
//-----------
//m == heights.length
//n == heights[r].length
//1 <= m, n <= 200
//0 <= heights[r][c] <= 10^5

public class PacificAtlanticWaterFlow 
{
	int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
	private void bfs(int i, int j, boolean[][] visited, int[][] H)
	{
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {i,j});
		visited[i][j] = true;
		
		int n = H.length, m = H[0].length;
		while(!q.isEmpty()) {
			int[] top = q.remove();
			int x = top[0], y = top[1];
			
			for(int[] ele:dir) {
				int nx = ele[0]+x, ny = ele[1]+y;
				if (nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny] && H[nx][ny]>=H[x][y]) {
					visited[nx][ny] = true;
					q.add(new int[]{nx, ny});
				}
			}
		}
	}
	
	public List<List<Integer>> pacificAtlantic(int[][] heights)
	{
		List<List<Integer>> res = new ArrayList<>();
		int n = heights.length, m = heights[0].length;
		boolean[][] pacificOcean = new boolean[n][m];
		boolean[][] atlanticOcean = new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			bfs(i,0,pacificOcean,heights);
			bfs(i,m-1,atlanticOcean,heights);
		}
		for(int j=0;j<m;j++) {
			bfs(0,j,pacificOcean,heights);
			bfs(n-1,j,atlanticOcean,heights);
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(pacificOcean[i][j] && atlanticOcean[i][j]) {
					res.add(Arrays.asList(i,j));
				}
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		int[][] arr = new int[M][N];
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		sc.close();
		PacificAtlanticWaterFlow Res = new PacificAtlanticWaterFlow();
		System.out.print(Res.pacificAtlantic(arr));
	}
}
