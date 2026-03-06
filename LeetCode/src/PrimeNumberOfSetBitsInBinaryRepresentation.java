import java.util.Scanner;

//762. Prime Number of Set Bits in Binary Representation (Easy)
//-------------------------------------------------------------	
//Given two integers left and right, return the count of numbers in the inclusive range [left, right]
//having a prime number of set bits in their binary representation.
//Recall that the number of set bits an integer has is the number of 1's present when written in binary.
//
//For example, 21 written in binary is 10101, which has 3 set bits.	
//
//Constraints:
//-----------
//1 <= left <= right <= 10^6
//0 <= right - left <= 10^4

public class PrimeNumberOfSetBitsInBinaryRepresentation 
{
	private int setBits(int N)
	{
        int count = 0;
        for(int i=0;i<32;i++){
            if((N&(1<<i))>0){
                count++;
            }
        }
        return count;
    }

    private boolean isPrime(int C)
    {
        if(C==1){
            return false;
        }
        for(int i=2;i<=C/2;i++){
            if(C%i==0){
                return false;
            }
        }
        return true;
    }
    
	public int countPrimeSetBits(int left, int right)
	{
		int res = 0;
        for(int i=left;i<=right;i++){
            if(isPrime(setBits(i))){
                res++;
            }
        }
        return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		sc.close();
		PrimeNumberOfSetBitsInBinaryRepresentation Res = new PrimeNumberOfSetBitsInBinaryRepresentation();
		System.out.print(Res.countPrimeSetBits(N, M));
	}
}
