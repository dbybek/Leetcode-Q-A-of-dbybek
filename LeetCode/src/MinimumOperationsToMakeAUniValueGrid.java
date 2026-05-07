import java.util.Scanner;

//2033. Minimum Operations to Make a Uni-Value Grid (Medium)
//----------------------------------------------------------
//You are given a 2D integer grid of size m x n and an integer x.
//In one operation, you can add x to or subtract x from any element in the grid.
//A uni-value grid is a grid where all the elements of it are equal.
//Return the minimum number of operations to make the grid uni-value. If it is not possible, return -1.
//Constraints:
//-----------
//m == grid.length
//n == grid[i].length
//1 <= m, n <= 10^5
//1 <= m * n <= 10^5
//1 <= x, grid[i][j] <= 10^4

public class MinimumOperationsToMakeAUniValueGrid 
{
	public int minOperations(int[][] grid, int x)
	{
		// int n = grid.length, m = grid[0].length, b = grid[0][0];
        // int[] arr = new int[n*m];
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if(Math.abs(grid[i][j]-b)%x != 0){
        //             return -1;
        //         }
        //         arr[i*m+j] = grid[i][j];
        //     }
        // }
        // Arrays.sort(arr);
        // int N = n*m, mid = arr[N/2], res = 0;
        // for(int i=0;i<N;i++){
        //     res += Math.abs(arr[i]-mid)/x;
        // }
        // return res;
        int n = grid.length, m = grid[0].length, base = grid[0][0];
        int[] freq = new int[10001];
        for (int[] row : grid) {
            for (int ele : row) {
                freq[ele]++;
                if (Math.abs(base - ele) % x != 0){
                    return -1;
                }
            }
        }
        int[] arr = new int[n * m];
        int k = 0;
        for (int i = 0; i < 10001; i++) {
            for (int j = 0; j < freq[i]; j++) {
                arr[k++] = i;
            }
        }
        int res = 0;
        int median = arr[arr.length / 2];
        for (int num : arr) {
            res += Math.abs(num - median) / x;
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
				arr[i][j] = sc.next().charAt(0);
			}
		}
		int k = sc.nextInt();
		sc.close();
		MinimumOperationsToMakeAUniValueGrid Res = new MinimumOperationsToMakeAUniValueGrid();
		System.out.print(Res.minOperations(arr, k));
	}
}
