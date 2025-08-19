import java.util.*;

//869. Reordered Power of 2 (Medium)
//----------------------------------
//You are given an integer n.
//We reorder the digits in any order (including the original order) such that the leading digit is not zero.
//Return true if and only if we can do this so that the resulting number is a power of two.
//
//Constraints:
//-----------
//1 <= n <= 10^9

public class ReorderedPowerOf2 
{
	public boolean checkFreq(int pow2,int[] frequency)
	{
		int[] count = new int[10];
		while(pow2 > 0) {
			count[pow2 % 10]++;
			pow2 /= 10;
		}
		return Arrays.equals(frequency, count);
	}
	
	public boolean reorderedPowerOf2(int n)
	{
		int[] freq = new int[10];
		int temp = n;
		while(temp > 0) {
			freq[temp%10]++;
			temp /= 10;
		}
		for(int i=0;i<=30;i++) {
			int powOf2 = 1<<i;
			if(checkFreq(powOf2,freq)) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		ReorderedPowerOf2 Res = new ReorderedPowerOf2();
		System.out.print(Res.reorderedPowerOf2(N));
	}
}
