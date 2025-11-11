import java.util.Scanner;

//1611. Minimum One Bit Operations to Make Integers Zero (Hard)
//-------------------------------------------------------------
//Given an integer n, you must transform it into 0 using the following operations any number of times:
//Change the rightmost (0th) bit in the binary representation of n.
//Change the ith bit in the binary representation of n if the (i-1)th bit is set to 1 and
//the (i-2)th through 0th bits are set to 0.
//Return the minimum number of operations to transform n into 0.
//
//Constraints:
//-----------
//0 <= n <= 10^9


public class MinimumOneBitOperationsToMakeIntegersZero 
{
	public int minimumOneBitOperations(int n)
	{
		int res = 0;
		for(int i=1;i<=n;i*=2) {
			res^=n/i;
		}
		return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		MinimumOneBitOperationsToMakeIntegersZero Res = new MinimumOneBitOperationsToMakeIntegersZero();
		System.out.print(Res.minimumOneBitOperations(N));
	}
}
