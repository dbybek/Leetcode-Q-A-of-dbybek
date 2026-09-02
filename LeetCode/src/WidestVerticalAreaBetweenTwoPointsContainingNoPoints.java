import java.util.Scanner;
import java.util.Arrays;

//1637. Widest Vertical Area Between Two Points Containing No Points (Easy)
//-------------------------------------------------------------------------
//Given n points on a 2D plane where points[i] = [xi, yi],
//Return the widest vertical area between two points such that no points are inside the area.
//A vertical area is an area of fixed-width extending infinitely along the y-axis (i.e., infinite height).
//The widest vertical area is the one with the maximum width.
//
//Note that points on the edge of a vertical area are not considered included in the area.
//
//Constraints:
//-----------
//n == points.length
//2 <= n <= 10^5
//points[i].length == 2
//0 <= xi, yi <= 10^9

public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints 
{
	public int maxWidthOfVerticalArea(int[][] points)
	{
		int[] xPoints = new int[points.length];
        for(int i=0;i<points.length;i++)
        {
            xPoints[i] = points[i][0];
        }
        Arrays.sort(xPoints);
        int res = 0;
        for(int i=1;i<xPoints.length;i++)
        {
            res = Math.max(res,xPoints[i]-xPoints[i-1]);
        }
        return res;
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
		WidestVerticalAreaBetweenTwoPointsContainingNoPoints Res = new WidestVerticalAreaBetweenTwoPointsContainingNoPoints();
		System.out.print(Res.maxWidthOfVerticalArea(arr));
	}
}
