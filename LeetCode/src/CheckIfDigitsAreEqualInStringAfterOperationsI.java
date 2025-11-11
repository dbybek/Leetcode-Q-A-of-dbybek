import java.util.Scanner;

//3461. Check If Digits Are Equal in String After Operations I (Easy)
//-------------------------------------------------------------------
//You are given a string s consisting of digits.
//Perform the following operation repeatedly until the string has exactly two digits:
//For each pair of consecutive digits in s,
//starting from the first digit, calculate a new digit as the sum of the two digits modulo 10.
//Replace s with the sequence of newly calculated digits, maintaining the order in which they are computed.
//Return true if the final two digits in s are the same; otherwise, return false.
//
//Constraints:
//-----------
//3 <= s.length <= 100
//s consists of only digits.

public class CheckIfDigitsAreEqualInStringAfterOperationsI 
{
	public boolean hasSameDigits(String s)
	{
		StringBuilder sb = new StringBuilder();
        while(s.length()>2){
            for(int i=0;i<s.length()-1;i++){
                int newDigit = ((s.charAt(i)-'0')+(s.charAt(i+1)-'0'))%10;
                sb.append(newDigit);
            }
            s = sb.toString();
            sb.delete(0,sb.length());
        }
        return (s.charAt(0)==s.charAt(1));
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		sc.close();
		CheckIfDigitsAreEqualInStringAfterOperationsI Res = new CheckIfDigitsAreEqualInStringAfterOperationsI();
		System.out.print(Res.hasSameDigits(N));
	}
}
