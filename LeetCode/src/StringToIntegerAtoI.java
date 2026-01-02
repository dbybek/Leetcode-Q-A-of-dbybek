import java.util.Scanner;

//8. String to Integer (atoi)(Medium)
//-----------------------------------
//Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.
//The algorithm for myAtoi(string s) is as follows:
//Whitespace: Ignore any leading whitespace (" ").
//Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
//Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or 
//the end of the string is reached. If no digits were read, then the result is 0.
//Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1],
//then round the integer to remain in the range. Specifically, integers less than -2^31 should be rounded to -2^31, 
//and integers greater than 2^31 - 1 should be rounded to 2^31 - 1.
//Return the integer as the final result.
//
//Constraints:
//-----------
//0 <= s.length <= 200
//s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.

public class StringToIntegerAtoI 
{
	public int myAtoi(String s)
	{
		int i = 0, n = s.length();
        while(i<n && s.charAt(i)==' '){
            i++;
        }
        if(i==n){
            return 0;
        }
        int sign = 1;
        if(s.charAt(i)=='+'){
            i++;
        }
        else if(s.charAt(i)=='-'){
            sign = -1;
            i++;
        }
        int mx = Integer.MAX_VALUE, mn = Integer.MIN_VALUE;
        long res = 0;
        while(i<n && Character.isDigit(s.charAt(i))){
            int dgt = s.charAt(i)-'0';
            res = res*10+dgt;
            if(sign*res >= mx){
                return mx;
            }
            if(sign*res <= mn){
                return mn;
            }
            i++;
        }
        return (int)(res*sign);
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		sc.close();
		StringToIntegerAtoI Res = new StringToIntegerAtoI();
		System.out.print(Res.myAtoi(N));
	}
}
