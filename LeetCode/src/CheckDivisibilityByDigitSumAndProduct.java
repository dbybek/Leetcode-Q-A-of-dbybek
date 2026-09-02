import java.util.Scanner;

//3622. Check Divisibility by Digit Sum and Product (Easy)
//--------------------------------------------------------
//You are given a positive integer n. Determine whether n is divisible by the sum of the following two values:
//The digit sum of n (the sum of its digits).
//The digit product of n (the product of its digits).
//Return true if n is divisible by this sum; otherwise, return false.
//
//Constraints:
//-----------
//1 <= n <= 10^6

public class CheckDivisibilityByDigitSumAndProduct 
{
	public boolean checkDivisibility(int n) 
	{
        int sum = 0, prod = 1;
        for(int i=n;i>0;i/=10){
            sum+=(i%10);
            prod*=(i%10);
        }
        return (n%(sum+prod))==0;
    }
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		CheckDivisibilityByDigitSumAndProduct Res = new CheckDivisibilityByDigitSumAndProduct();
		System.out.print(Res.checkDivisibility(N));
	}
}
