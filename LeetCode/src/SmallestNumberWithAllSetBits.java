import java.util.Scanner;

//3370. Smallest Number With All Set Bits (Easy)
//----------------------------------------------
//You are given a positive number n.
//Return the smallest number x greater than or equal to n, such that the binary representation of x contains only set bits
//
//Constraints:
//-----------
//1 <= n <= 1000

public class SmallestNumberWithAllSetBits 
{
	public int smallestNumber(int n)
	{
		int res = 1;
        while(res-1<n){
            res<<=1;
        }
        return res-1;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		SmallestNumberWithAllSetBits Res = new SmallestNumberWithAllSetBits();
		System.out.print(Res.smallestNumber(N));
	}
}
