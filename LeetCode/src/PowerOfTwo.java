import java.util.Scanner;

//231. Power of Two (Easy)
//------------------------
//Given an integer n, return true if it is a power of two. Otherwise, return false.
//An integer n is a power of two, if there exists an integer x such that n == 2^x.
//
//Constraints:
//-----------
//-2^31 <= n <= 2^31 - 1

public class PowerOfTwo 
{
	public boolean isPowerOfTwo(int n)
	{
		while(n>=2) {
			if(n%2!=0) {
				return false;
			}
			n /= 2;
		}
		
		return n==1;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		PowerOfTwo Res = new PowerOfTwo();
		System.out.print(Res.isPowerOfTwo(N));
	}
}
