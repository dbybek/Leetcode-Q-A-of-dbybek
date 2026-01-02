import java.util.*;

//1337. The K Weakest Rows in a Matrix (Easy)
//-------------------------------------------
//You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians).
//The soldiers are positioned in front of the civilians.
//That is, all the 1's will appear to the left of all the 0's in each row.
//A row i is weaker than a row j if one of the following is true:
//
//The number of soldiers in row i is less than the number of soldiers in row j.
//Both rows have the same number of soldiers and i < j.
//Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.
//
//Constraints:
//-----------
//m == mat.length
//n == mat[i].length
//2 <= n, m <= 100
//1 <= k <= m
//matrix[i][j] is either 0 or 1.

public class TheKWeakestRowsInAMatrix 
{
	public int[] kWeakestRows(int[][] mat, int k)
	{
		int n = mat.length, m = mat[0].length;
        int[] rank = new int[n];
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < m; j++){
                if (mat[i][j] == 0) break;
                count++;
            }
            rank[i] = count * 1000 + i;
        }

        Arrays.sort(rank);
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = rank[i] % 1000;
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
		TheKWeakestRowsInAMatrix Res = new TheKWeakestRowsInAMatrix();
		int[] arr1 = Res.kWeakestRows(arr, k);
		for(int ele:arr1) {
			System.out.print(ele+" ");
		}
	}
}
