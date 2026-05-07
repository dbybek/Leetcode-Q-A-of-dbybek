import java.util.Scanner;

//2946. Matrix Similarity After Cyclic Shifts (Easy)
//--------------------------------------------------
//You are given an m x n integer matrix mat and an integer k. The matrix rows are 0-indexed.
//The following proccess happens k times:
//Even-indexed rows (0, 2, 4, ...) are cyclically shifted to the left.
//Odd-indexed rows (1, 3, 5, ...) are cyclically shifted to the right.
//Return true if the final modified matrix after k steps is identical to the original matrix, and false otherwise.
//
//Constraints:
//-----------
//1 <= mat.length <= 25
//1 <= mat[i].length <= 25
//1 <= mat[i][j] <= 25
//1 <= k <= 50

public class MatrixSimilarityAfterCyclicShifts 
{
	public boolean areSimilar(int[][] mat, int k)
	{
		if(k%mat[0].length==0){
            return true;
        }
        int n = mat.length, m = mat[0].length;
        k %= m;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i % 2 == 0) {
                    if (mat[i][j] != mat[i][(j + k) % m]) {
                        return false;
                    }
                } 
                else {
                    if (mat[i][j] != mat[i][(j - k + m) % m]) {
                        return false;
                    }
                }
            }
        }
        return true;
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
		MatrixSimilarityAfterCyclicShifts Res = new MatrixSimilarityAfterCyclicShifts();
		System.out.print(Res.areSimilar(arr, k));
	}
}
