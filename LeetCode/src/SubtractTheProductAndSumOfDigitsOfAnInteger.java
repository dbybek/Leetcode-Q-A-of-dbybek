import java.util.Scanner;

//1281. Subtract the Product and Sum of Digits of an Integer (Easy)
//-----------------------------------------------------------------
//Given an integer number n, return the difference between the product of its digits and the sum of its digits.
//
//Constraints:
//-----------
//1 <= n <= 10^5

public class SubtractTheProductAndSumOfDigitsOfAnInteger 
{
	public int subtractProductAndSum(int n)
	{
		int sum = 0, p = 1;
        while(n>0){
            sum+=(n%10);
            p*=(n%10);
            n/=10;
        }
        return p-sum;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		SubtractTheProductAndSumOfDigitsOfAnInteger Res = new SubtractTheProductAndSumOfDigitsOfAnInteger();
		System.out.print(Res.subtractProductAndSum(N));
	}
}
