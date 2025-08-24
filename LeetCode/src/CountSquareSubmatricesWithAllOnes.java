import java.util.Scanner;

//1277. Count Square Submatrices with All Ones (Medium)
//-----------------------------------------------------
//Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
//
//Constraints:
//-----------
//1 <= arr.length <= 300
//1 <= arr[0].length <= 300
//0 <= arr[i][j] <= 1

public class CountSquareSubmatricesWithAllOnes 
{
	public int countSquares(int[][] matrix)
	{
		int n = matrix.length, m = matrix[0].length;
		int[][] dp = new int[n][m];
		int res = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(i==0 || j==0) {
					dp[i][j] = matrix[i][j];
				}
				else {
					if(matrix[i][j]==1) {
						dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]))+matrix[i][j];
					}
				}
				res += dp[i][j];
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
		CountSquareSubmatricesWithAllOnes Res = new CountSquareSubmatricesWithAllOnes();
		System.out.print(Res.countSquares(arr));
	}
}
