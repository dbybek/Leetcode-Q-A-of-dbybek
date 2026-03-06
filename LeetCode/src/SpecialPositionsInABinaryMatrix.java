import java.util.Scanner;

//1582. Special Positions in a Binary Matrix (Easy)
//-------------------------------------------------
//Given an m x n binary matrix mat, return the number of special positions in mat.
//A position (i, j) is called special if mat[i][j] == 1 and
//all other elements in row i and column j are 0 (rows and columns are 0-indexed).
//
//Constraints:
//-----------
//m == mat.length
//n == mat[i].length
//1 <= m, n <= 100
//mat[i][j] is either 0 or 1.

public class SpecialPositionsInABinaryMatrix 
{
	public int numSpecial(int[][] mat)
	{
		int n = mat.length, m = mat[0].length, res = 0, col = -1, sum = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sum += mat[i][j];
                if(sum>1){
                    break;
                }
                if(mat[i][j]==1){
                    col = j;
                }
            }
            for(int j=0;j<n && sum>=1;j++){
                sum+=mat[j][col];
            }
            if(sum==2){
                res++;
            }
            sum = 0;
            col = -1;
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
		SpecialPositionsInABinaryMatrix Res = new SpecialPositionsInABinaryMatrix();
		System.out.print(Res.numSpecial(arr));
	}
}
