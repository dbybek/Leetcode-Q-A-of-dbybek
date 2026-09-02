import java.util.Scanner;

//3658. GCD of Odd and Even Sums (Easy)
//-------------------------------------
//You are given an integer n. Your task is to compute the GCD (greatest common divisor) of two values:
//sumOdd: the sum of the smallest n positive odd numbers.
//sumEven: the sum of the smallest n positive even numbers.
//
//Return the GCD of sumOdd and sumEven.
//
//Constraints:
//-----------
//1 <= n <= 1000

public class GCDOfOddAndEvenSums 
{
	public int gcdOfOddEvenSums(int n) 
	{
        return n;
    }
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		GCDOfOddAndEvenSums Res = new GCDOfOddAndEvenSums();
		System.out.print(Res.gcdOfOddEvenSums(N));
	}
}
