import java.util.Scanner;

//3000. Maximum Area of Longest Diagonal Rectangle (Easy)
//-------------------------------------------------------
//You are given a 2D 0-indexed integer array dimensions.
//For all indices i, 0 <= i < dimensions.length,
//dimensions[i][0] represents the length and dimensions[i][1] represents the width of the rectangle i.
//Return the area of the rectangle having the longest diagonal.
//If there are multiple rectangles with the longest diagonal, return the area of the rectangle having the maximum area.
//
//Constraints:
//-----------
//1 <= dimensions.length <= 100
//dimensions[i].length == 2
//1 <= dimensions[i][0], dimensions[i][1] <= 100

public class MaximumAreaOfLongestDiagonalRectangle 
{
	public int areaOfMaxDiagonal(int[][] dimensions) {
        int dia = 0, res = 0;
        for(int [] rec:dimensions){
            int temp = rec[0]*rec[0] + rec[1]*rec[1];
            if(dia < temp){
                dia = temp;
                res = rec[0]*rec[1];
            }
            else if(dia==temp){
                res = Math.max(res,rec[0]*rec[1]);
            }
        }
        return res;
    }
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][2];
		for(int i=0;i<N;i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		sc.close();
		MaximumAreaOfLongestDiagonalRectangle Res = new MaximumAreaOfLongestDiagonalRectangle();
		System.out.print(Res.areaOfMaxDiagonal(arr));
	}
}
