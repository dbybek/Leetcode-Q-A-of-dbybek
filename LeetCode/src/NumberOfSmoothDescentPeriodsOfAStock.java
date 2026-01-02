import java.util.Scanner;

//2110. Number of Smooth Descent Periods of a Stock (Medium)
//----------------------------------------------------------
//You are given an integer array prices representing the daily price history of a stock,
//where prices[i] is the stock price on the ith day.
//A smooth descent period of a stock consists of one or more contiguous days
//such that the price on each day is lower than the price on the preceding day by exactly 1.
//The first day of the period is exempted from this rule.
//
//Return the number of smooth descent periods.
//
//Constraints:
//-----------
//1 <= prices.length <= 10^5
//1 <= prices[i] <= 10^5

public class NumberOfSmoothDescentPeriodsOfAStock 
{
	public long getDescentPeriods(int[] prices)
	{
		long res = 0, count = 1;
        int n = prices.length;
        for(int i=1;i<n;i++){
            if(prices[i]+1==prices[i-1]){
                res += count;
                count++;
            }
            else {
                count = 1;
            }
        }
        return res+n;
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
		NumberOfSmoothDescentPeriodsOfAStock Res = new NumberOfSmoothDescentPeriodsOfAStock();
		System.out.print(Res.getDescentPeriods(arr));
	}
}
