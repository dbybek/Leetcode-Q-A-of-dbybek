import java.util.Scanner;

//11. Container With Most Water (Medium)
//--------------------------------------
//You are given an integer array height of length n.
//There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
//Find two lines that together with the x-axis form a container, such that the container contains the most water.
//Return the maximum amount of water a container can store.
//
//Notice that you may not slant the container.
//
//Constraints:
//-----------
//n == height.length
//2 <= n <= 10^5
//0 <= height[i] <= 10^4

public class ContainerWithMostWater 
{
	public int maxArea(int[] height)
	{
		int res = 0, l = 0, r = height.length-1;
		while(l<=r) {
			int currArea = Math.min(height[l], height[r])*(r-l);
			res = Math.max(currArea, res);
			if(height[l]<height[r]) {
				l++;
			}
			else {
				r--;
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
		sc.close();
		ContainerWithMostWater Res = new ContainerWithMostWater();
		System.out.print(Res.maxArea(arr));
	}
}
