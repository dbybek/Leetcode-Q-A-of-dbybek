import java.util.Scanner;

//3536. Maximum Product of Two Digits (Easy)
//------------------------------------------
//You are given a positive integer n.
//Return the maximum product of any two digits in n.
//Note: You may use the same digit twice if it appears more than once in n.
//
//Constraints:
//-----------
//10 <= n <= 10^9

public class MaximumProductOfTwoDigits 
{
	public int maxProduct(int n)
	{
		int mx1 = 0, mx2 = 0;
        while(n>0){
            if(n%10 >= mx1){
                mx2 = mx1;
                mx1 = n%10;
            }
            else if(n%10 > mx2){
                mx2 = n%10;
            }
            n/=10;
        }
        return mx1*mx2;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		MaximumProductOfTwoDigits Res = new MaximumProductOfTwoDigits();
		System.out.print(Res.maxProduct(N));
	}
}
