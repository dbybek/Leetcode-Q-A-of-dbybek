import java.util.Scanner;

//1791. Find Center of Star Graph (Easy)
//--------------------------------------
//There is an undirected star graph consisting of n nodes labeled from 1 to n.
//A star graph is a graph where there is one center node and
//exactly n - 1 edges that connect the center node with every other node.
//You are given a 2D integer array edges where each edges[i] = [ui, vi] indicates
//that there is an edge between the nodes ui and vi. Return the center of the given star graph.
//
//Constraints:
//-----------
//3 <= n <= 10^5
//edges.length == n - 1
//edges[i].length == 2
//1 <= ui, vi <= n
//ui != vi
//The given edges represent a valid star graph.

public class FindCenterOfStarGraph 
{
	public int findCenter(int[][] edges)
	{
		if(edges[0][0]==edges[1][0] || edges[0][0]==edges[1][1]){
            return edges[0][0];
        }
        return edges[0][1];
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
		FindCenterOfStarGraph Res = new FindCenterOfStarGraph();
		System.out.print(Res.findCenter(arr));
	}
}
