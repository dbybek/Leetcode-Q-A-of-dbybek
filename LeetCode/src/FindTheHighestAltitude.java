import java.util.Scanner;

//1732. Find the Highest Altitude (Easy)
//--------------------------------------
//There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes.
//The biker starts his trip on point 0 with altitude equal 0.
//You are given an integer array gain of length n where gain[i] is the net gain in altitude
//between points i​​​​​​ and i + 1 for all (0 <= i < n). Return the highest altitude of a point.
//
//Constraints:
//-----------
//n == gain.length
//1 <= n <= 100
//-100 <= gain[i] <= 100

public class FindTheHighestAltitude 
{
	public int largestAltitude(int[] gain)
	{
		int res = 0, sum = 0;
        for(int ele:gain){
            sum+=ele;
            res = Math.max(res,sum);
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
		FindTheHighestAltitude Res = new FindTheHighestAltitude();
		System.out.print(Res.largestAltitude(arr));
	}
}
