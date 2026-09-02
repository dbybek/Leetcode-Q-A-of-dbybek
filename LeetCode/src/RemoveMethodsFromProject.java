import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//3310. Remove Methods From Project (Medium)
//------------------------------------------
//You are maintaining a project that has n methods numbered from 0 to n - 1.
//You are given two integers n and k, and a 2D integer array invocations,
//where invocations[i] = [ai, bi] indicates that method ai invokes method bi.
//There is a known bug in method k. Method k, along with any method invoked by it,
//either directly or indirectly, are considered suspicious and we aim to remove them.
//A group of methods can only be removed if no method outside the group invokes any methods within it.
//Return an array containing all the remaining methods after removing all the suspicious methods.
//You may return the answer in any order.
//If it is not possible to remove all the suspicious methods, none should be removed.
//
//Constraints:
//-----------
//1 <= n <= 10^5
//0 <= k <= n - 1
//0 <= invocations.length <= 2 * 10^5
//invocations[i] == [ai, bi]
//0 <= ai, bi <= n - 1
//ai != bi
//invocations[i] != invocations[j]


public class RemoveMethodsFromProject 
{
	private void dfs(int method, HashMap<Integer, ArrayList<Integer>> hm, int[] visit)
	{
		visit[method] = 1;
		if(!hm.containsKey(method)) {
			return;
		}
		
		for(int ele:hm.get(method)) {
			if(visit[ele]==0) {
				dfs(ele, hm, visit);
			}
		}
	}
	
	public List<Integer> remainingMethods(int n, int k, int[][] invocations)
	{
		HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
		for(int[] ele:invocations) {
			if(!hm.containsKey(ele[0])) {
				hm.put(ele[0], new ArrayList<>());
			}
			hm.get(ele[0]).add(ele[1]);
		}
		int[] visited = new int[n];
		dfs(k,hm,visited);
		List<Integer> res = new ArrayList<>();
		for(int[] ele:invocations) {
			if(visited[ele[0]]==0 && visited[ele[1]]==1) {
				res = IntStream.range(0, n).boxed().collect(Collectors.toList());
				return res;
			}
		}
		for(int i=0;i<n;i++) {
			if(visited[i]==0) {
				res.add(i);
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
		int k = sc.nextInt();
		sc.close();
		RemoveMethodsFromProject Res = new RemoveMethodsFromProject();
		System.out.print(Res.remainingMethods(N, k, arr));
	}
}
