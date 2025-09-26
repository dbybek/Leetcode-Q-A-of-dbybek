import java.util.*;

//120. Triangle (Medium)
//----------------------
//Given a triangle array, return the minimum path sum from top to bottom.
//For each step, you may move to an adjacent number of the row below.
//More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
//
//Constraints:
//-----------
//1 <= triangle.length <= 200
//triangle[0].length == 1
//triangle[i].length == triangle[i - 1].length + 1
//-10^4 <= triangle[i][j] <= 10^4

public class Triangle 
{
	public int minimumTotal(List<List<Integer>> triangle)
	{
		int n = triangle.size();
		int[] dp = new int[n];
		for(int i=0;i<n;i++) {
			dp[i] = triangle.get(n-1).get(i);
		}
		for(int i=n-2;i>=0;i--) {
			int[] temp = new int[n];
			for(int j=i;j>=0;j--) {
				int left = triangle.get(i).get(j)+dp[j];
				int right = triangle.get(i).get(j)+dp[j+1];
				temp[j] = Math.min(left, right);
			}
			dp = temp;
		}
		return dp[0];
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<List<Integer>> lst = new ArrayList<>();
		for(int i=0;i<N;i++) {
			List<Integer> lst2 = new ArrayList<>();
			for(int j=0;j<=i;j++) {
				lst2.add(sc.nextInt());
			}
			lst.add(lst2);
		}
		sc.close();
		Triangle Res = new Triangle();
		System.out.print(Res.minimumTotal(lst));
	}
}
