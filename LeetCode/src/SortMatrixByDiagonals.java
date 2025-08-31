import java.util.*;

//3446. Sort Matrix by Diagonals (Medium)
//---------------------------------------
//You are given an n x n square matrix of integers grid. Return the matrix such that:
//
//The diagonals in the bottom-left triangle (including the middle diagonal) are sorted in non-increasing order.
//The diagonals in the top-right triangle are sorted in non-decreasing order.
//
//Constraints:
//-----------
//grid.length == grid[i].length == n
//1 <= n <= 10
//-10^5 <= grid[i][j] <= 10^5

public class SortMatrixByDiagonals 
{
	public int[][] sortMatrix(int[][] grid)
	{
		int n = grid.length;
		int[][] res = new int[n][n];
		for(int l=1;l<n;l++) {
			int i = 0, j = l;
			int topDi = i, topDj = j;
			PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->a-b);
			while(i<n && j<n) {
				pq.offer(grid[i++][j++]);
			}
			
			while(topDi<n && topDj<n) {
				res[topDi++][topDj++] = pq.poll();
			}
		}
		
		for(int l=0;l<n;l++) {
			int i = l, j = 0;
			int bottomDi = i, bottomDj = j;
			PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
			while(i<n && j<n) {
				pq.offer(grid[i++][j++]);
			}
			
			while(bottomDi<n && bottomDj<n) {
				res[bottomDi++][bottomDj++] = pq.poll();
			}
		}
		return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		sc.close();
		SortMatrixByDiagonals Res = new SortMatrixByDiagonals();
		int[][] arr1 = Res.sortMatrix(arr);
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(arr1[i][j]+" ");
			}
			System.out.println();
		}
	}
}
