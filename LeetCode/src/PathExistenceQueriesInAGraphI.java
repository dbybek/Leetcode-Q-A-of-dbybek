import java.util.Scanner;

//3532. Path Existence Queries in a Graph I (Medium)
//--------------------------------------------------
//You are given an integer n representing the number of nodes in a graph, labeled from 0 to n - 1.
//You are also given an integer array nums of length n sorted in non-decreasing order, and an integer maxDiff.
//An undirected edge exists between nodes i and j if the absolute difference between nums[i] and nums[j] is at most maxDiff
//(i.e., |nums[i] - nums[j]| <= maxDiff).
//You are also given a 2D integer array queries.
//For each queries[i] = [ui, vi], determine whether there exists a path between nodes ui and vi.
//Return a boolean array answer,
//where answer[i] is true if there exists a path between ui and vi in the ith query and false otherwise.
//
//Constraints:
//-----------
//1 <= n == nums.length <= 10^5
//0 <= nums[i] <= 10^5
//nums is sorted in non-decreasing order.
//0 <= maxDiff <= 10^5
//1 <= queries.length <= 10^5
//queries[i] == [ui, vi]
//0 <= ui, vi < n

public class PathExistenceQueriesInAGraphI 
{
	public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries)
	{
		int[] exist = new int[n];
		int path = 0;
		for(int i=1;i<n;i++) {
			if(nums[i]-nums[i-1]>maxDiff) {
				path++;
			}
			exist[i] = path;
		}
		boolean[] res = new boolean[queries.length];
		for(int i=0;i<queries.length;i++) {
			res[i] = (exist[queries[i][0]]==exist[queries[i][1]]);
		}
		return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		int[][] arr1 = new int[M][2];
		for(int i=0;i<M;i++) {
			arr1[i][0] = sc.nextInt();
			arr1[i][1] = sc.nextInt();
		}
		int k = sc.nextInt();
		sc.close();
		PathExistenceQueriesInAGraphI Res = new PathExistenceQueriesInAGraphI();
		boolean[] arr2 = Res.pathExistenceQueries(N, arr, k, arr1);
		for(int i=0;i<M;i++) {
			System.out.print(arr2[i]+" ");
		}
	}
}
