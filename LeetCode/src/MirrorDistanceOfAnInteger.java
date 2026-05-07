import java.util.Scanner;

//3783. Mirror Distance of an Integer (Easy)
//------------------------------------------
//You are given an integer n.
//Define its mirror distance as: abs(n - reverse(n))​​​​​​​ where reverse(n) is the integer formed by reversing the digits of n.
//Return an integer denoting the mirror distance of n​​​​​​​.
//abs(x) denotes the absolute value of x.
//
//Constraints:
//-----------
//1 <= n <= 10^9

public class MirrorDistanceOfAnInteger 
{
	public int mirrorDistance(int n)
	{
		int rev = 0;
        for(int i=n;i>0;i/=10){
            rev*=10;
            rev+=i%10;
        }
        return Math.abs(n-rev);
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		MirrorDistanceOfAnInteger Res = new MirrorDistanceOfAnInteger();
		System.out.print(Res.mirrorDistance(N));
	}
}
