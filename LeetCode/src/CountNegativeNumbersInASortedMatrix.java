import java.util.Scanner;

//1351. Count Negative Numbers in a Sorted Matrix (Easy)
//------------------------------------------------------
//Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise,
//return the number of negative numbers in grid.
//
//Constraints:
//-----------
//m == grid.length
//n == grid[i].length
//1 <= m, n <= 100
//-100 <= grid[i][j] <= 100

public class CountNegativeNumbersInASortedMatrix 
{
	public int countNegatives(int[][] grid)
	{
		int row = grid.length-1, col = 0, res = 0, n = grid[0].length;
		while(row>=0 && col<n) {
			if(grid[row][col]>=0) {
				col++;
			}
			else {
				res+=n-col;
				row++;
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
		sc.close();
		CountNegativeNumbersInASortedMatrix Res = new CountNegativeNumbersInASortedMatrix();
		System.out.print(Res.countNegatives(arr));
	}
}
