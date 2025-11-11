import java.util.Scanner;

//2220. Minimum Bit Flips to Convert Number (Easy)
//------------------------------------------------
//A bit flip of a number x is choosing a bit in the binary representation of x and
//flipping it from either 0 to 1 or 1 to 0.
//
//For example, for x = 7, the binary representation is 111 and we may choose any bit
//(including any leading zeros not shown) and flip it.
//We can flip the first bit from the right to get 110, flip the second bit from the right to get 101,
//flip the fifth bit from the right (a leading zero) to get 10111, etc.
//Given two integers start and goal, return the minimum number of bit flips to convert start to goal.
//
//Constraints:
//-----------
//0 <= start, goal <= 10^9

public class MinimumBitFlipsToConvertNumber 
{
	public int minBitFlips(int start, int goal)
	{
		int res = 0;
//		Approach I: Check every bit from 0th till 32nd bit and compare for start and goal and increment upon missmatch.
//		---------------------------------------------------------------------------------------------------------------
//		for(int i=0;i<32;i++) {
//			int bitStart = (start&(1<<i))>0?1:0, bitGoal = (goal&(1<<i))>0?1:0;
//			if(bitStart!=bitGoal) {
//				res++;
//			}
//		}
//		return res;
//		
//		Approach II: Same approach of checking bits as the above but optimizing the check by using BIT operations.
//		----------------------------------------------------------------------------------------------------------
		int xr = start^goal;
		/* Doing XOR operation gives us a value with set bits at the miss match positions.
		 * So now we can just count the set bits in 'xr' to get the result.
		 */
		while(xr>0) {
			res+=xr&1; //if rightmost bit is 1 we increment.
			xr>>=1; //Rightshift the XOR value to get the next bit.
		}
		return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		sc.close();
		MinimumBitFlipsToConvertNumber Res = new MinimumBitFlipsToConvertNumber();
		System.out.print(Res.minBitFlips(N, M));
	}
}