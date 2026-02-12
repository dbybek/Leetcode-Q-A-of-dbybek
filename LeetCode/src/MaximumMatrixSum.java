import java.util.Scanner;

//1975. Maximum Matrix Sum(Medium)
//--------------------------------
//You are given an n x n integer matrix. You can do the following operation any number of times:
//Choose any two adjacent elements of matrix and multiply each of them by -1.
//Two elements are considered adjacent if and only if they share a border.
//
//Your goal is to maximize the summation of the matrix's elements.
//Return the maximum sum of the matrix's elements using the operation mentioned above.
//Constraints:
//-----------
//n == matrix.length == matrix[i].length
//2 <= n <= 250
//-10^5 <= matrix[i][j] <= 10^5

public class MaximumMatrixSum 
{
	public long maxMatrixSum(int[][] matrix)
	{
		int negCount = 0, mn = 100001;
        long res = 0;
        for(int[] arr:matrix){
            for(int ele:arr){
                if(ele<0){
                    negCount++;
                    ele *= -1;
                }
                mn = Math.min(mn,ele);
                res += (long)(ele);
            }
        }
        if(negCount%2==0){
            return res;
        }
        return res-(2*mn);
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr1 = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				arr1[i][j] = sc.nextInt();
			}
		}
		sc.close();
		MaximumMatrixSum Res = new MaximumMatrixSum();
		System.out.print(Res.maxMatrixSum(arr1));
	}
}
