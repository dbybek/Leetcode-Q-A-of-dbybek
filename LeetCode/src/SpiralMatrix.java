import java.util.*;

//54. Spiral Matrix (Medium)
//--------------------------
//Given an m x n matrix, return all elements of the matrix in spiral order.
//
//Constraints:
//-----------
//m == matrix.length
//n == matrix[i].length
//1 <= m, n <= 10
//-100 <= matrix[i][j] <= 100

public class SpiralMatrix 
{
	public List<Integer> spiralOrder(int[][] matrix)
	{
		int top = 0, left = 0, right = matrix[0].length-1, down = matrix.length-1, total = (right+1)*(down+1);
        List<Integer> res = new ArrayList<>();
        for(int count=0;count<=total;){
            for(int j=left;j<=right;j++){
                res.add(matrix[top][j]);
                count++;
            }
            if(count==total){
                return res;
            }
            top++;
            for(int i=top;i<=down;i++){
                res.add(matrix[i][right]);
                count++;
            }
            if(count==total){
                return res;
            }
            right--;
            for(int j=right;j>=left;j--){
                res.add(matrix[down][j]);
                count++;
            }
            if(count==total){
                return res;
            }
            down--;
            for(int i=down;i>=top;i--){
                res.add(matrix[i][left]);
                count++;
            }
            if(count==total){
                return res;
            }
            left++;
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
		SpiralMatrix Res = new SpiralMatrix();
		System.out.print(Res.spiralOrder(arr));
	}
}
