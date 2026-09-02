import java.util.*;

//2685. Count the Number of Complete Components (Medium)
//------------------------------------------------------
//You are given an integer n. There is an undirected graph with n vertices, numbered from 0 to n - 1.
//You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that
//there exists an undirected edge connecting vertices ai and bi.
//Return the number of complete connected components of the graph.
//A connected component is a subgraph of a graph in which there exists a path between any two vertices,
//and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.
//A connected component is said to be complete if there exists an edge between every pair of its vertices.
//
//Constraints:
//-----------
//1 <= n <= 50
//0 <= edges.length <= n * (n - 1) / 2
//edges[i].length == 2
//0 <= ai, bi <= n - 1
//ai != bi
//There are no repeated edges.

public class CountTheNumberOfCompleteComponents 
{
	private void dfs(int x, ArrayList<ArrayList<Integer>> lst, boolean[] visited, ArrayList<Integer> complete)
	{
		visited[x] = true;
		complete.add(x);
		for(Integer ele:lst.get(x)) {
			if(!visited[ele]) {
				dfs(ele,lst,visited,complete);
			}
		}
	}
	
	public int countCompleteComponents(int n, int[][] edges)
	{
		ArrayList<ArrayList<Integer>> gp = new ArrayList<>();
		for(int i=0;i<n;i++) {
			gp.add(new ArrayList<>());
		}
		
		for(int i=0;i<edges.length;i++) {
			gp.get(edges[i][1]).add(edges[i][0]);
			gp.get(edges[i][0]).add(edges[i][1]);
		}
		
		boolean[] visited = new boolean[n];
		int res = 0;
		
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				ArrayList<Integer> complete = new ArrayList<>();
				dfs(i,gp,visited,complete);
				boolean isComplete = true;
				for(Integer ele:complete) {
					if(gp.get(ele).size() != complete.size()-1) {
						isComplete = false;
						break;
					}
				}
				if(isComplete) {
					res++;
				}
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
		CountTheNumberOfCompleteComponents Res = new CountTheNumberOfCompleteComponents();
		System.out.print(Res.countCompleteComponents(N, arr));
	}
}
