import java.util.Scanner;

//1536. Minimum Swaps to Arrange a Binary Grid (Medium)
//-----------------------------------------------------
//Given an n x n binary grid, in one step you can choose two adjacent rows of the grid and swap them.
//A grid is said to be valid if all the cells above the main diagonal are zeros.
//
//Return the minimum number of steps needed to make the grid valid, or -1 if the grid cannot be valid.
//
//The main diagonal of a grid is the diagonal that starts at cell (1, 1) and ends at cell (n, n).
//
//Constraints:
//-----------
//n == grid.length == grid[i].length
//1 <= n <= 200
//grid[i][j] is either 0 or 1

public class MinimumSwapsToArrangeABinaryGrid 
{
	public int minSwaps(int[][] grid)
	{
		int n = grid.length, count = 0;
        int[] trailZero = new int[n];

        for(int i=0;i<n;i++){
            count = 0;
            for(int j=n-1;j>=0;j--){
                if(grid[i][j]==0){
                    count++;
                }
                else {
                    break;
                }
            }
            trailZero[i] = count;
        }

        int res = 0;

        for(int i=0;i<n;i++){
            int req = n-i-1, j = i;
            
            while(j<n && trailZero[j] < req){
                j++;
            }

            if(j==n){
                return -1;
            }

            while(j>i){
                int temp = trailZero[j];
                trailZero[j] = trailZero[j-1];
                trailZero[j-1] = temp;
                res++;
                j--;
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
		MinimumSwapsToArrangeABinaryGrid Res = new MinimumSwapsToArrangeABinaryGrid();
		System.out.print(Res.minSwaps(arr));
	}
}
