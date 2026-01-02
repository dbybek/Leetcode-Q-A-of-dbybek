import java.util.Scanner;

//3531. Count Covered Buildings (Medium)
//--------------------------------------
//You are given a positive integer n, representing an n x n city.
//You are also given a 2D grid buildings,
//where buildings[i] = [x, y] denotes a unique building located at coordinates [x, y].
//A building is covered if there is at least one building in all four directions: left, right, above, and below.
//
//Return the number of covered buildings.
//
//Constraints:
//-----------
//2 <= n <= 10^5
//1 <= buildings.length <= 10^5 
//buildings[i] = [x, y]
//1 <= x, y <= n
//All coordinates of buildings are unique.

public class CountCoveredBuildings 
{
	public int countCoveredBuildings(int n, int[][] buildings)
	{
		int[][] rowV = new int[n+1][2];
		int[][] colV = new int[n+1][2];
		for(int i=0;i<n;i++) {
			rowV[i][0] = n;
			colV[i][0] = n;
		}
		for(int[] ele:buildings) {
			int x = ele[0], y = ele[1];
			rowV[y][0] = Math.min(rowV[y][0], x);
			rowV[y][1] = Math.max(rowV[y][1], x);
			
			colV[x][0] = Math.min(colV[x][0], y);
			colV[x][1] = Math.max(colV[x][1], y);
		}
		
		int res = 0;
		for(int[] ele:buildings) {
			int x = ele[0], y = ele[1];
			if(rowV[y][0] < x && x < rowV[y][1] && colV[x][0] < y && y < colV[x][1]) {
				res++;
			}
		}
		return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		int[][] arr = new int[M][2];
		for(int i=0;i<M;i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		sc.close();
		CountCoveredBuildings Res = new CountCoveredBuildings();
		System.out.print(Res.countCoveredBuildings(N, arr));
	}
}
