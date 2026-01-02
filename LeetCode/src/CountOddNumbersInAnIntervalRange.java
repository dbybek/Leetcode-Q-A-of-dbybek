import java.util.Scanner;

//1523. Count Odd Numbers in an Interval Range (Easy)
//---------------------------------------------------
//Given two non-negative integers low and high. Return the count of odd numbers between low and high (inclusive).
//
//Constraints:
//-----------
//0 <= low <= high <= 10^9

public class CountOddNumbersInAnIntervalRange 
{
	public int countOdds(int low, int high)
	{
		if(low%2==0 && high%2==0){
            return (high-low)/2;
        }
        return (high-low)/2 +1;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		sc.close();
		CountOddNumbersInAnIntervalRange Res = new CountOddNumbersInAnIntervalRange();
		System.out.print(Res.countOdds(N, M));
	}
}
