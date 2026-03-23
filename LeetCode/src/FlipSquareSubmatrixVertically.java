import java.util.Scanner;

//3643. Flip Square Submatrix Vertically (Easy)
//---------------------------------------------
//You are given an m x n integer matrix grid, and three integers x, y, and k.
//The integers x and y represent the row and column indices of the top-left corner of a square submatrix and
//the integer k represents the size (side length) of the square submatrix.
//
//Your task is to flip the submatrix by reversing the order of its rows vertically.
//
//Return the updated matrix.
//
//Constraints:
//-----------
//m == grid.length
//n == grid[i].length
//1 <= m, n <= 50
//1 <= grid[i][j] <= 100
//0 <= x < m
//0 <= y < n
//1 <= k <= min(m - x, n - y)

public class FlipSquareSubmatrixVertically 
{
	public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k)
	{
		int i = x, j = x+k-1;
        while(i < j){
            for(int l = y;l<y+k;l++){
                int temp = grid[i][l];
                grid[i][l] = grid[j][l];
                grid[j][l] = temp;
            }
            i++;
            j--;
        }
        return grid;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		int[][] arr = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;i<M;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int x = sc.nextInt(), y = sc.nextInt(), k = sc.nextInt();
		sc.close();
		System.out.println("Before flipping the sub matrix: ");
		for(int i=0;i<N;i++) {
			for(int j=0;i<M;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		FlipSquareSubmatrixVertically Res = new FlipSquareSubmatrixVertically();
		Res.reverseSubmatrix(arr, x, y, k);
		System.out.println("After flipping the sub matrix: ");
		for(int i=0;i<N;i++) {
			for(int j=0;i<M;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
