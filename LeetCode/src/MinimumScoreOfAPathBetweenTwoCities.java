import java.util.Scanner;

//2492. Minimum Score of a Path Between Two Cities (Medium)
//---------------------------------------------------------
//You are given a positive integer n representing n cities numbered from 1 to n.
//You are also given a 2D array roads where roads[i] = [ai, bi, distancei] indicates that
//there is a bidirectional road between cities ai and bi with a distance equal to distancei.
//The cities graph is not necessarily connected.
//The score of a path between two cities is defined as the minimum distance of a road in this path.
//
//Return the minimum possible score of a path between cities 1 and n.
//
//Note:
//
//A path is a sequence of roads between two cities.
//It is allowed for a path to contain the same road multiple times,
//and you can visit cities 1 and n multiple times along the path.
//The test cases are generated such that there is at least one path between 1 and n.
//
//Constraints:
//-----------
//2 <= n <= 10^5
//1 <= roads.length <= 10^5
//roads[i].length == 3
//1 <= ai, bi <= n
//ai != bi
//1 <= distancei <= 10^4
//There are no repeated edges.
//There is at least one path between 1 and n.

public class MinimumScoreOfAPathBetweenTwoCities 
{
	private int find(int[] root,int i)
    {
        if(root[i]==i){
            return i;
        }
        return root[i] = find(root,root[i]);
    }
	
	public int minScore(int n, int[][] roads)
	{
		int[] root = new int[n+1];
        for(int i=0;i<=n;i++){
            root[i] = i;
        }
        
        for(int i = 0;i<roads.length;i++){
            root[find(root,roads[i][0])] = find(root,roads[i][1]);
        }

        int res = 10001;
        for(int i = 0;i<roads.length;i++){
            if(find(root,roads[i][0])==find(root,1)){
                res = Math.min(res,roads[i][2]);
            }
        }
        return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		int[][] arr = new int[M][3];
		for(int i=0;i<M;i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			arr[i][2] = sc.nextInt();
		}
		sc.close();
		MinimumScoreOfAPathBetweenTwoCities Res = new MinimumScoreOfAPathBetweenTwoCities();
		System.out.print(Res.minScore(N, arr));
	}
}
