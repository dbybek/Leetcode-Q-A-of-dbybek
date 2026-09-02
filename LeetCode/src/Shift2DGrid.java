import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//1260. Shift 2D Grid (Easy)
//--------------------------
//Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.
//In one shift operation:
//
//Element at grid[i][j] moves to grid[i][j + 1].
//Element at grid[i][n - 1] moves to grid[i + 1][0].
//Element at grid[m - 1][n - 1] moves to grid[0][0].
//Return the 2D grid after applying shift operation k times.
//
//Constraints:
//-----------
//m == grid.length
//n == grid[i].length
//1 <= m <= 50
//1 <= n <= 50
//-1000 <= grid[i][j] <= 1000
//0 <= k <= 100

public class Shift2DGrid 
{
	public List<List<Integer>> shiftGrid(int[][] grid, int k)
	{
		int m = grid.length, n = grid[0].length, total = m*n;
		k%=total;
		List<List<Integer>> res = new ArrayList<>();
		for(int i=0;i<m;i++) {
			List<Integer> temp = new ArrayList<>();
			for(int j=0;j<n;j++) {
				temp.add(0);
			}
			res.add(temp);
		}
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				int currInd = (i*n)+j, newInd = (currInd+k)%total;
				res.get(newInd/n).set(newInd%n, grid[i][j]);
			}
		}
		return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		int[][] arr = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int k = sc.nextInt();
		sc.close();
		Shift2DGrid Res = new Shift2DGrid();
		System.out.print(Res.shiftGrid(arr, k));
	}
}
