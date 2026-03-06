import java.util.Scanner;

//190. Reverse Bits (Easy)
//------------------------	
//Reverse bits of a given 32 bits signed integer.	
//
//Constraints:
//-----------
//0 <= n <= 2^31 - 2
//n is even.

public class ReverseBits 
{
	public int reverseBits(int n)
	{
//		Approach I: Bit Manipulation
//		----------------------------
		int res = 0, i = 31;
        while(i>=0 && n>0){
            if(n%2==1){
                res|=(1<<i);
            }
            i--;
            n/=2;
        }
        return res;
        
//		Approach II: Bit Manipulation with better TC
//		--------------------------------------------
//        int res = 0;
//        for(int i=0;i<32;i++) 
//        {
//        	res <<= 1;
//            res |= (n&1);
//            n >>= 1;
//        }
//        return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		ReverseBits Res = new ReverseBits();
		System.out.print(Res.reverseBits(N));
	}
}
