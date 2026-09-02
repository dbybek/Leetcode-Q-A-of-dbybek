import java.util.Scanner;

//3345. Smallest Divisible Digit Product I (Easy)
//-----------------------------------------------
//You are given two integers n and t.
//Return the smallest number greater than or equal to n such that the product of its digits is divisible by t.
//
//Constraints:
//-----------
//1 <= n <= 100
//1 <= t <= 10

public class SmallestDivisibleDigitProductI 
{
	public int smallestNumber(int n, int t)
	{
		int res = n;
        for(int i=n;i<=100;i++){
            if(i/10 > 0){
                if((i%10) * (i/10)%t == 0){
                    res = i;
                    break;
                }
            }
            else if (i%t==0){
                res = i;
                break;
            }
        }
        return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		sc.close();
		SmallestDivisibleDigitProductI Res = new SmallestDivisibleDigitProductI();
		System.out.print(Res.smallestNumber(N, M));
	}
}
