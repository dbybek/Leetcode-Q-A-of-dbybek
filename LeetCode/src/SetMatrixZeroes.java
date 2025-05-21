import java.util.*;

//73. Set Matrix Zeroes (Medium)
//------------------------------
//Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
//You must do it in place.
//
//Constraints:
//-----------
//m == matrix.length
//n == matrix[0].length
//1 <= m, n <= 200
//-2^31 <= matrix[i][j] <= 231 - 1

public class SetMatrixZeroes 
{

	public void setZeroes(int[][] matrix) 
	{
		HashSet<Integer> zeroRow = new HashSet<>();
		HashSet<Integer> zeroCol = new HashSet<>();
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				if (matrix[i][j] == 0){
                    zeroRow.add(i);
                    zeroCol.add(j);
                }
			}
		}
		for (int ele : zeroRow){
            Arrays.fill(matrix[ele],0);
        }
        for (int ele : zeroCol){
            for (int i = 0; i<matrix.length;i++){
                matrix[i][ele] = 0;
            }
        }
    }
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt(), N = sc.nextInt();
		int[][] arr = new int[M][N];
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		sc.close();
		SetMatrixZeroes Res = new SetMatrixZeroes();
		Res.setZeroes(arr);
		for(int[] arr1:arr ) {
			for(int ele:arr1) {
				System.out.print(ele+" ");
			}
			System.out.println();
		}
	}

}
