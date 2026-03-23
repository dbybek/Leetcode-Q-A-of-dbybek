import java.util.Scanner;

//1009. Complement of Base 10 Integer (Easy)
//------------------------------------------
//The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in
//its binary representation.
//
//For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
//Given an integer n, return its complement.
//
//Constraints:
//-----------
//0 <= n < 10^9

public class ComplementOfBase10Integer 
{
	public int bitwiseComplement(int n)
	{
		if(n==0){
            return 1;
        }
        int res = 0, rsb = -1;
        for(int i=31;i>=0;i--){
            if((n&(1<<i))==0){
                if(rsb==-1){
                    continue;
                }
                res |= (1<<i);
            }
            else{
                rsb = i;
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
		ComplementOfBase10Integer Res = new ComplementOfBase10Integer();
		System.out.print(Res.bitwiseComplement(N));
	}
}
