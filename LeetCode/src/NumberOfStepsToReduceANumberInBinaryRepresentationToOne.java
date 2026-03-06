import java.util.Scanner;

//1404. Number of Steps to Reduce a Number in Binary Representation to One (Medium)
//---------------------------------------------------------------------------------
//Given the binary representation of an integer as a string s,
//return the number of steps to reduce it to 1 under the following rules:
//If the current number is even, you have to divide it by 2.
//
//If the current number is odd, you have to add 1 to it.
//
//It is guaranteed that you can always reach one for all test cases.
//
//Constraints:
//-----------
//1 <= s.length <= 500
//s consists of characters '0' or '1'
//s[0] == '1'

public class NumberOfStepsToReduceANumberInBinaryRepresentationToOne 
{
	public int numSteps(String s) 
	{
        int step = 0, oddBit = 0;
        for(int i=s.length()-1;i>0;i--){
            if((s.charAt(i)&1)+oddBit == 1){
                step+=2;
                oddBit = 1;
            }
            else{
                step++;
            }
        }
        return step+oddBit;
    }
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		sc.close();
		NumberOfStepsToReduceANumberInBinaryRepresentationToOne Res = new NumberOfStepsToReduceANumberInBinaryRepresentationToOne();
		System.out.print(Res.numSteps(N));
	}
}
