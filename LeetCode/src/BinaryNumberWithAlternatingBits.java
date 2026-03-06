import java.util.Scanner;

//693. Binary Number with Alternating Bits (Easy)
//-----------------------------------------------	
//Given a positive integer, check whether it has alternating bits: namely,
//if two adjacent bits will always have different values.	
//
//Constraints:
//-----------
//0 <= n <= 2^31 - 2
//n is even.

public class BinaryNumberWithAlternatingBits 
{
	public boolean hasAlternatingBits(int n) 
	{
        int x = (n^(n>>1));
        return (x&(x+1))==0;
    }
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		BinaryNumberWithAlternatingBits Res = new BinaryNumberWithAlternatingBits();
		System.out.print(Res.hasAlternatingBits(N));
	}
}
