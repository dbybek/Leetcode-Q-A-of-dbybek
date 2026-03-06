import java.util.Scanner;

//1680. Concatenation of Consecutive Binary Numbers (Medium)
//----------------------------------------------------------
//Given an integer n,
//return the decimal value of the binary string formed by concatenating the binary representations of 1 to n in order,
//modulo 10^9 + 7.
//
//Constraints:
//-----------
//1 <= n <= 10^5

public class ConcatenationOfConsecutiveBinaryNumbers 
{
	public int concatenatedBinary(int n)
	{
		// int temp = 2, mod = 1000000007;
        // long res = 0;
        // for(int i=1;i<=n;i++){
        //     if(i==temp){
        //         temp*=2;
        //     }
        //     res = (res*temp) + i;
        //     res %= mod;
        // }
        // return (int)res;
        long res=0, mod=1000000007;
        int bits=0;
        for(int i=1;i<=n;i++)
        {
            if((i&(i-1))==0){
                bits++;
            }
            res= ((res<<bits)+i)%mod;
        }
        return (int)res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		ConcatenationOfConsecutiveBinaryNumbers Res = new ConcatenationOfConsecutiveBinaryNumbers();
		System.out.print(Res.concatenatedBinary(N));
	}
}
