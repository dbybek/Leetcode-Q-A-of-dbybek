import java.util.Scanner;

//868. Binary Gap (Easy)
//----------------------	
//Given a positive integer n,
//find and return the longest distance between any two adjacent 1's in the binary representation of n.
//If there are no two adjacent 1's, return 0.
//
//Two 1's are adjacent if there are only 0's separating them (possibly no 0's).
//The distance between two 1's is the absolute difference between their bit positions.
//For example, the two 1's in "1001" have a distance of 3.
//
//Constraints:
//-----------
//1 <= n <= 10^9

public class BinaryGap 
{
	public int binaryGap(int n)
	{
		int res = 0, i = -1;
        for(int j=0;j<32;j++){
            if((n&(1<<j))>0){
                if(i==-1){
                    i = j;
                }
                else{
                    res = Math.max(res,j-i);
                    i = j;
                }
            }
        }
        return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		BinaryGap Res = new BinaryGap();
		System.out.print(Res.binaryGap(N));
	}
}
