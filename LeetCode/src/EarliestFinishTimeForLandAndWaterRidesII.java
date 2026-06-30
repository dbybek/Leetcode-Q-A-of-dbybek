import java.util.Scanner;

//3635. Earliest Finish Time for Land and Water Rides II (Medium)
//---------------------------------------------------------------
//You are given two categories of theme park attractions: land rides and water rides.
//Land rides
//landStartTime[i] – the earliest time the ith land ride can be boarded.
//landDuration[i] – how long the ith land ride lasts.
//Water rides
//waterStartTime[j] – the earliest time the jth water ride can be boarded.
//waterDuration[j] – how long the jth water ride lasts.
//A tourist must experience exactly one ride from each category, in either order.
//
//A ride may be started at its opening time or any later moment.
//If a ride is started at time t, it finishes at time t + duration.
//Immediately after finishing one ride the tourist may board the other (if it is already open) or wait until it opens.
//Return the earliest possible time at which the tourist can finish both rides.
//Constraints:
//-----------
//1 <= n, m <= 5 * 10^4
//landStartTime.length == landDuration.length == n
//waterStartTime.length == waterDuration.length == m
//1 <= landStartTime[i], landDuration[i], waterStartTime[j], waterDuration[j] <= 10^5

public class EarliestFinishTimeForLandAndWaterRidesII 
{
	public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration)
	{
		int mnL = 300000, mnW = mnL, res = mnW;
        for (int i=0;i<landStartTime.length;i++){
            mnL = Math.min(mnL, landStartTime[i] + landDuration[i]);
        }
        for (int i=0;i<waterStartTime.length;i++) {
            mnW = Math.min(mnW, waterStartTime[i] + waterDuration[i]);
            res = Math.min(res, Math.max(mnL, waterStartTime[i]) + waterDuration[i]);
        }
        for (int i=0;i<landStartTime.length;i++){
            res = Math.min(res, Math.max(mnW, landStartTime[i]) + landDuration[i]);
        }
        return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arrL = new int[N];
		int[] arrLD = new int[N];
		for(int i=0;i<N;i++) {
			arrL[i] = sc.nextInt();
			arrLD[i] = sc.nextInt();
		}
		int M = sc.nextInt();
		int[] arrW = new int[N];
		int[] arrWD = new int[N];
		for(int i=0;i<M;i++) {
			arrW[i] = sc.nextInt();
			arrWD[i] = sc.nextInt();
		}
		sc.close();
		EarliestFinishTimeForLandAndWaterRidesII Res = new EarliestFinishTimeForLandAndWaterRidesII();
		System.out.print(Res.earliestFinishTime(arrL, arrLD, arrW, arrWD));
	}
}
