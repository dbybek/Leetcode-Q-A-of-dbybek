import java.util.Scanner;

//1039. Minimum Score Triangulation of Polygon (Medium)
//-----------------------------------------------------
//You have a convex n-sided polygon where each vertex has an integer value.
//You are given an integer array values where values[i] is the value of the ith vertex in clockwise order.
//Polygon triangulation is a process where you divide a polygon into a set of triangles and 
//the vertices of each triangle must also be vertices of the original polygon.
//Note that no other shapes other than triangles are allowed in the division. This process will result in n - 2 triangles.
//You will triangulate the polygon.
//For each triangle, the weight of that triangle is the product of the values at its vertices.
//The total score of the triangulation is the sum of these weights over all n - 2 triangles.
//
//Return the minimum possible score that you can achieve with some triangulation of the polygon.
//
//Constraints:
//-----------
//n == values.length
//3 <= n <= 50
//1 <= values[i] <= 100

public class MinimumScoreTriangulationOfPolygon 
{
	public int minScoreTriangulation(int[] values)
	{
		int n = values.length;
		int[][] dp = new int[n][n];
		for(int x=2;x<n;x++) {
			for(int i=0;i+x<n;i++) {
				int j = i+x;
				int minScore = Integer.MAX_VALUE;
				for(int k=i+1;k<j;k++) {
					int score = dp[i][k] + dp[k][j] + (values[i]*values[k]*values[j]);
					minScore = Math.min(minScore, score);
				}
				dp[i][j] = minScore;
			}
		}
		return dp[0][n-1];
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		MinimumScoreTriangulationOfPolygon Res = new MinimumScoreTriangulationOfPolygon();
		System.out.print(Res.minScoreTriangulation(arr));
	}
}
