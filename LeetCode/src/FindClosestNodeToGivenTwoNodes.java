import java.util.Arrays;
import java.util.Scanner;

//2359. Find Closest Node to Given Two Nodes (Medium)
//---------------------------------------------------
//You are given a directed graph of n nodes numbered from 0 to n - 1, where each node has at most one outgoing edge.
//The graph is represented with a given 0-indexed array edges of size n,
//indicating that there is a directed edge from node i to node edges[i].
//If there is no outgoing edge from i, then edges[i] == -1.
//
//You are also given two integers node1 and node2.
//
//Return the index of the node that can be reached from both node1 and node2,
//such that the maximum between the distance from node1 to that node, and from node2 to that node is minimized.
//If there are multiple answers, return the node with the smallest index, and if no possible answer exists, return -1.
//
//Note that edges may contain cycles.
//
//Constraints:
//-----------
//n == edges.length
//2 <= n <= 10^5
//-1 <= edges[i] < n
//edges[i] != i
//0 <= node1, node2 < n

public class FindClosestNodeToGivenTwoNodes 
{
	private int[] getDistances(int[] edge,int start) 
	{
		int[] dist = new int[edge.length];
		Arrays.fill(dist, -1);
		int dis = 0;
		while(start != -1 && dist[start] == -1) {
			dist[start] = dis++;
			start = edge[start];
		}
		return dist;
	}
	
	public int closestMeetingNode(int[] edges, int node1, int node2) 
	{
		int[] distNode1 = getDistances(edges,node1);
		int[] distNode2 = getDistances(edges,node2);
		
		int res = -1, mnDistance = Integer.MAX_VALUE;
		
		for(int i=0;i<edges.length;i++) {
			if(distNode1[i] != -1 && distNode2[i] != -1) {
				int mxDistance = Math.max(distNode1[i], distNode2[i]);
				if(mxDistance < mnDistance) {
					mnDistance = mxDistance;
					res = i;
				}
			}
		}
		return res;
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
		int node1 = sc.nextInt(), node2 = sc.nextInt();
		sc.close();
		FindClosestNodeToGivenTwoNodes Res = new FindClosestNodeToGivenTwoNodes();
		System.out.print(Res.closestMeetingNode(arr, node1, node2));
	}

}
