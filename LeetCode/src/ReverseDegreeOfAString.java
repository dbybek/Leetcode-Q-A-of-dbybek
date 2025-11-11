import java.util.Scanner;

//3498. Reverse Degree of a String (Easy)
//---------------------------------------
//Given a string s, calculate its reverse degree.
//The reverse degree is calculated as follows:
//For each character, multiply its position in the reversed alphabet ('a' = 26, 'b' = 25, ..., 'z' = 1)
//with its position in the string (1-indexed).
//Sum these products for all characters in the string.
//Return the reverse degree of s.
//
//Constraints:
//-----------
//1 <= s.length <= 1000
//s contains only lowercase English letters.

public class ReverseDegreeOfAString 
{
	public int reverseDegree(String s)
	{
		int res = 0, n = s.length();
        for(int i=1;i<=n;i++){
            res += (26-(s.charAt(i-1)-'a'))*i;
        }
        return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		sc.close();
		ReverseDegreeOfAString Res = new ReverseDegreeOfAString();
		System.out.print(Res.reverseDegree(N));
	}
}
