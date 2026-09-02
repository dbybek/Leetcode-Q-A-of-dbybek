import java.util.Scanner;

//3754. Concatenate Non-Zero Digits and Multiply by Sum I (Easy)
//--------------------------------------------------------------
//You are given an integer n.
//Form a new integer x by concatenating all the non-zero digits of n in their original order.
//If there are no non-zero digits, x = 0.
//Let sum be the sum of digits in x.
//Return an integer representing the value of x * sum.
//
//Constraints:
//-----------
//0 <= n <= 10^9

public class ConcatenateNonZeroDigitsAndMultiplyBySumI 
{
	public long sumAndMultiply(int n)
	{
		long sum = 0, x = 0, u = 1;
        while(n>0){
            sum+=(n%10);
            if(n%10>0){
                x+=((n%10)*u);
                u*=10;
            }
            n/=10;
        }
        return sum*x;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		ConcatenateNonZeroDigitsAndMultiplyBySumI Res = new ConcatenateNonZeroDigitsAndMultiplyBySumI();
		System.out.print(Res.sumAndMultiply(N));
	}
}
