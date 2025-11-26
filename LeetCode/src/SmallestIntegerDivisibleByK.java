import java.util.Scanner;

//1015. Smallest Integer Divisible by K (Medium)
//----------------------------------------------
//Given a positive integer k, you need to find the length of the smallest positive integer n such that n is divisible by k,
//and n only contains the digit 1.
//Return the length of n. If there is no such n, return -1.
//
//Note: n may not fit in a 64-bit signed integer.
//
//Constraints:
//-----------
//1 <= k <= 10^5

public class SmallestIntegerDivisibleByK 
{
	public int smallestRepunitDivByK(int k)
	{
		if(k%2==0 || k%5==0) {
			return -1;
		}
		long x = 0;
		for(int i=1;i<=k;i++) {
			x = (x*10+1)%k;
			if(x==0) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		SmallestIntegerDivisibleByK Res = new SmallestIntegerDivisibleByK();
		System.out.print(Res.smallestRepunitDivByK(N));
	}
}
