import java.util.Scanner;
import java.util.Arrays;

//1288. Remove Covered Intervals (Medium)
//---------------------------------------
//Given an array intervals where intervals[i] = [li, ri] represent the interval [li, ri),
//remove all intervals that are covered by another interval in the list.
//The interval [a, b) is covered by the interval [c, d) if and only if c <= a and b <= d.
//
//Return the number of remaining intervals.
//
//Constraints:
//-----------
//1 <= intervals.length <= 1000
//intervals[i].length == 2
//0 <= li < ri <= 105
//All the given intervals are unique.

public class RemoveCoveredIntervals 
{
	public int removeCoveredIntervals(int[][] intervals)
	{
		Arrays.sort(intervals, (a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        int res = 0, mxEnd = 0;
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][1]>mxEnd){
                res++;
                mxEnd = intervals[i][1];
            }
        }
        return res;
        // int res = 0;
        // for(int i=0;i<intervals.length;i++){
        //     int temp = 0;
        //     for(int j=0;j<intervals.length;j++){
        //         if(intervals[j][0] <= intervals[i][0] && intervals[i][1] <= intervals[j][1]){
        //             temp++;
        //         }
        //     }
        //     if(temp==1){
        //         res++;
        //     }
        // }
        // return res;
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
		RemoveCoveredIntervals Res = new RemoveCoveredIntervals();
		System.out.print(Res.removeCoveredIntervals(arr));
	}
}
