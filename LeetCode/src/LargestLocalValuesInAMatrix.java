import java.util.Scanner;

//2373. Largest Local Values in a Matrix (Easy)
//---------------------------------------------
//You are given an n x n integer matrix grid.
//Generate an integer matrix maxLocal of size (n - 2) x (n - 2) such that:
//maxLocal[i][j] is equal to the largest value of the 3 x 3 matrix in grid centered around row i + 1 and column j + 1.
//In other words, we want to find the largest value in every contiguous 3 x 3 matrix in grid.
//
//Return the generated matrix.
//
//Constraints:
//-----------
//n == grid.length == grid[i].length
//3 <= n <= 100
//1 <= grid[i][j] <= 100

public class LargestLocalValuesInAMatrix 
{
	public int[][] largestLocal(int[][] grid)
	{
		int n = grid.length;
		int[][] res = new int[n-2][n-2];
		for(int i=0;i<n-2;i++) {
			for(int j=0;j<n-2;j++) {
				for(int k=i;k<i+3;k++) {
					for(int l=j;l<j+3;l++) {
						res[i][j] = Math.max(res[i][j], grid[k][l]);
					}
				}
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
		LargestLocalValuesInAMatrix Res = new LargestLocalValuesInAMatrix();
		System.out.print(Res.largestLocal(arr));
	}
}