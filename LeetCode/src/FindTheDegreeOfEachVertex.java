import java.util.Scanner;

//3898. Find the Degree of Each Vertex (Easy)
//-------------------------------------------
//You are given a 2D integer array matrix of size n x n representing the adjacency matrix of an
//undirected graph with n vertices labeled from 0 to n - 1.
//matrix[i][j] = 1 indicates that there is an edge between vertices i and j.
//matrix[i][j] = 0 indicates that there is no edge between vertices i and j.
//The degree of a vertex is the number of edges connected to it.
//
//Return an integer array ans of size n where ans[i] represents the degree of vertex i.
//
//Constraints:
//-----------
//1 <= n == matrix.length == matrix[i].length <= 100​​​​​​​
//​​​​​​​matrix[i][i] == 0
//matrix[i][j] is either 0 or 1
//matrix[i][j] == matrix[j][i]

public class FindTheDegreeOfEachVertex 
{
	public int[] findDegrees(int[][] matrix)
	{
		int[] res = new int[matrix.length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                res[i]+=matrix[i][j];
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
		FindTheDegreeOfEachVertex Res = new FindTheDegreeOfEachVertex();
		int[] arr1 = Res.findDegrees(arr);
		for(int i=0;i<N;i++) {
			System.out.print(arr1[i]+" ");
		}
	}
}
