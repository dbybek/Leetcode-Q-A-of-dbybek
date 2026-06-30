import java.util.Scanner;

//1914. Cyclically Rotating a Grid IX (Medium)
//--------------------------------------------
//You are given an m x n integer matrix grid​​​, where m and n are both even integers, and an integer k.
//The matrix is composed of several layers, which is shown in the below image, where each color is its own layer:
//
//Check the leet code question for image.
//
//A cyclic rotation of the matrix is done by cyclically rotating each layer in the matrix.
//To cyclically rotate a layer once, each element in the layer will take the place of the adjacent element in
//the counter-clockwise direction. An example rotation is shown below:
//
// Check the leet code question for image.
//
//Return the matrix after applying k cyclic rotations to it.
//Constraints:
//-----------
//m == grid.length
//n == grid[i].length
//2 <= m, n <= 50
//Both m and n are even integers.
//1 <= grid[i][j] <= 5000
//1 <= k <= 10^9

public class CyclicallyRotatingAGrid 
{
	public int[][] rotateGrid(int[][] grid, int k)
	{
		int top = 0, left = 0, bottom = grid.length-1, right = grid[0].length-1;
        while(top<bottom && left<right){
            int prmtr = 2*(bottom-top) + 2*(right-left);
            int n = k%prmtr;
            while(n-- > 0){
                int temp = grid[top][left];
                for(int j=left;j<right;j++){
                    grid[top][j] = grid[top][j+1];
                }

                for(int i=top;i<bottom;i++){
                    grid[i][right] = grid[i+1][right];
                }

                for(int j=right;j>left;j--){
                    grid[bottom][j] = grid[bottom][j-1];
                }

                for(int i=bottom;i>top;i--){
                    grid[i][left] = grid[i-1][left];
                }

                grid[top+1][left] = temp;
            }
            top++;
            left++;
            bottom--;
            right--;
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
			for(int j=0;j<M;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int k = sc.nextInt();
		sc.close();
		System.out.println("Before rotation: ");
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		CyclicallyRotatingAGrid Res = new CyclicallyRotatingAGrid();
		int[][] arr1 = Res.rotateGrid(arr, k);
		System.out.println("After rotation: ");
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(arr1[i][j]+" ");
			}
			System.out.println();
		}
	}
}
