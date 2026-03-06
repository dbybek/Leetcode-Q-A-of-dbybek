import java.util.Scanner;

//1545. Find Kth Bit in Nth Binary String (Medium)
//------------------------------------------------
//Given two positive integers n and k, the binary string Sn is formed as follows:
//S1 = "0"
//Si = Si - 1 + "1" + reverse(invert(Si - 1)) for i > 1
//Where + denotes the concatenation operation, reverse(x) returns the reversed string x,
//and invert(x) inverts all the bits in x (0 changes to 1 and 1 changes to 0).
//
//For example, the first four strings in the above sequence are:
//
//S1 = "0"
//S2 = "011"
//S3 = "0111001"
//S4 = "011100110110001"
//Return the kth bit in Sn. It is guaranteed that k is valid for the given n.
//
//Constraints:
//-----------
//1 <= n <= 20
//1 <= k <= 2^n - 1

public class FindKthBitInNthBinaryString 
{
	public char findKthBit(int n, int k) 
	{
//		Approach I: Using recurssion to find the exact bit or inversed bit.
//		-------------------------------------------------------------------
//		if(n==1 || k==1){
//            return '0';
//        }
//
//        int len = (1<<n)-1, mid = len/2 + 1;
//
//        if(k==mid){
//            return '1';
//        }
//        else if(k<mid){
//            return findKthBit(n-1,k);
//        }
//
//        return findKthBit(n-1, len-k+1)=='0' ? '1' : '0';
//		
//		Approach II: Using loop to calculate the position of the first bit from which we get the Kth bit in the Nth string.
//		-------------------------------------------------------------------------------------------------------------------
		int count = 0, len = (1<<n)-1;
		
		while(k>1) {
			if(k==len/2 + 1) {
				return count%2==0?'1':'0';
			}
			if(k>len/2) {
				k = len+1-k;
				count++;
			}
			len /= 2;
		}
		
		return (count%2==0)?'0':'1';
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), K = sc.nextInt();
		sc.close();
		FindKthBitInNthBinaryString Res = new FindKthBitInNthBinaryString();
		System.out.print(Res.findKthBit(N, K));
	}
}
