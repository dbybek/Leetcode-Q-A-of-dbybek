import java.util.Scanner;

//1578. Minimum Time to Make Rope Colorful (Medium)
//-------------------------------------------------
//Alice has n balloons arranged on a rope.
//You are given a 0-indexed string colors where colors[i] is the color of the ith balloon.
//Alice wants the rope to be colorful.
//She does not want two consecutive balloons to be of the same color,
//so she asks Bob for help.
//Bob can remove some balloons from the rope to make it colorful.
//You are given a 0-indexed integer array neededTime where neededTime[i] is the time (in seconds) that
//Bob needs to remove the ith balloon from the rope.
//
//Return the minimum time Bob needs to make the rope colorful.
//
//Constraints:
//-----------
//n == colors.length == neededTime.length
//1 <= n <= 10^5
//1 <= neededTime[i] <= 10^4
//colors contains only lowercase English letters.

public class MinimumTimeToMakeRopeColorful 
{
	public int minCost(String colors, int[] neededTime)
	{
		int res = 0, n = colors.length();
		for(int i=0;i<n;i++) {
			res+=neededTime[i];
		}
		int mx = 0;
		for(int i=0;i<n-1;i++) {
			mx = Math.max(mx, neededTime[i]);
			if(colors.charAt(i)!=colors.charAt(i+1)) {
				res-=mx;
				mx = 0;
			}
		}
		mx = Math.max(mx, neededTime[n-1]);
		return res-mx;
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
		String str = sc.nextLine();
		sc.close();
		MinimumTimeToMakeRopeColorful Res = new MinimumTimeToMakeRopeColorful();
		System.out.print(Res.minCost(str, arr));
	}
}
