import java.util.Scanner;

//48. Rotate Image (Medium)
//-------------------------
//You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
//You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
//DO NOT allocate another 2D matrix and do the rotation.
//Constraints:
//-----------
//n == matrix.length == matrix[i].length
//1 <= n <= 20
//-1000 <= matrix[i][j] <= 1000

public class RotateImage 
{
	public void rotate(int[][] matrix)
	{
		// int n = matrix.length, temp = 0;
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<i;j++){
        //         temp = matrix[i][j];
        //         matrix[i][j] = matrix[j][i];
        //         matrix[j][i] = temp;
        //     }
        // }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n/2;j++){
        //         temp = matrix[i][j];
        //         matrix[i][j] = matrix[i][n-j-1];
        //         matrix[i][n-j-1] = temp;
        //     }
        // }
        int i = 0,j = 0,temp = 0, n = matrix.length, c = 1;
        for (int x = 0;x<(n*(n + 1))/2;x++){
            if (j < n - 1){
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
                j++;
            }
            else{
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
                i++;
                j = i;
            }
        }
        i = 0;
        j = 0;
        for (int x = 0;x<(n * (n/2));x++){
            if (c < n/2){
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
                j++;
                c++;
            }
            else{
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
                i++;
                j = 0;
                c = 1;
            }
        }
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
		System.out.println("Before rotation: ");
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		RotateImage Res = new RotateImage();
		Res.rotate(arr);
		System.out.println("After rotation: ");
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
