import java.util.Scanner;

//3228. Maximum Number of Operations to Move Ones to the End (Medium)
//-------------------------------------------------------------------
//You are given a binary string s.
//You can perform the following operation on the string any number of times:
//Choose any index i from the string where i + 1 < s.length such that s[i] == '1' and s[i + 1] == '0'.
//Move the character s[i] to the right until it reaches the end of the string or another '1'.
//For example, for s = "010010", if we choose i = 1, the resulting string will be s = "000110".
//Return the maximum number of operations that you can perform.
//
//Constraints:
//-----------
//1 <= s.length <= 10^5
//s[i] is either '0' or '1'.

public class MaximumNumberOfOperationsToMoveOnesToTheEnd 
{
	public int maxOperations(String s)
	{
		int n = s.length(), res = 0, count = 0;
		for(int i=n-2;i>=0;i--) {
			char ch = s.charAt(i);
			if(ch=='1' && s.charAt(i+1)=='0') {
				count++;
			}
			if(ch=='1') {
				res+=count;
			}
		}
		return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		sc.close();
		MaximumNumberOfOperationsToMoveOnesToTheEnd Res = new MaximumNumberOfOperationsToMoveOnesToTheEnd();
		System.out.print(Res.maxOperations(N));
	}
}
