import java.util.Scanner;

//1758. Minimum Changes To Make Alternating Binary String (Easy)
//--------------------------------------------------------------
//You are given a string s consisting only of the characters '0' and '1'.
//In one operation, you can change any '0' to '1' or vice versa.
//The string is called alternating if no two adjacent characters are equal.
//For example, the string "010" is alternating, while the string "0100" is not.
//
//Return the minimum number of operations needed to make s alternating.
//
//Constraints:
//-----------
//1 <= s.length <= 10^4
//s[i] is either '0' or '1'

public class MinimumChangesToMakeAlternatingBinaryString 
{
	public int minOperations(String s)
	{
		int cnt = 0;
        for(int i=0;i<s.length();i++){
            if(i%2 == s.charAt(i)-'0'){
                cnt++;
            }
        }
        return Math.min(cnt,s.length()-cnt);
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		sc.close();
		MinimumChangesToMakeAlternatingBinaryString Res = new MinimumChangesToMakeAlternatingBinaryString();
		System.out.print(Res.minOperations(N));
	}
}
