import java.util.Arrays;
import java.util.Scanner;

//757. Set Intersection Size At Least Two (Hard)
//----------------------------------------------
//You are given a 2D integer array intervals where intervals[i] = [starti, endi] represents all the integers
//from starti to endi inclusively.
//A containing set is an array nums where each interval from intervals has at least two integers in nums.
//
//For example, if intervals = [[1,3], [3,7], [8,9]], then [1,2,4,7,8,9] and [2,3,4,8,9] are containing sets.
//Return the minimum possible size of a containing set.
//
//Constraints:
//-----------
//1 <= intervals.length <= 3000
//intervals[i].length == 2
//0 <= starti < endi <= 10^8

public class SetIntersectionSizeAtLeastTwo 
{
	public int intersectionSizeTwo(int[][] intervals)
	{
		Arrays.sort(intervals, (a,b)->(a[1]==b[1])?b[0]-a[0]:a[1]-b[1]);
		int res = 0, l = -1, r = -1;
		for(int[] ele:intervals) {
			if(ele[0]>r) {
				l = ele[1]-1;
				r = ele[1];
				res+=2;
			}
			else if(ele[0]>l) {
				l = r;
				r = ele[1];
				res++;
			}
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
		SetIntersectionSizeAtLeastTwo Res = new SetIntersectionSizeAtLeastTwo();
		System.out.print(Res.intersectionSizeTwo(arr));
	}
}
