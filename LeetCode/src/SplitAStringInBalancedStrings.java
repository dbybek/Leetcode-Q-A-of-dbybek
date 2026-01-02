import java.util.Scanner;

//1221. Split a String in Balanced Strings(Easy)
//----------------------------------------------
//Balanced strings are those that have an equal quantity of 'L' and 'R' characters.
//Given a balanced string s, split it into some number of substrings such that:
//
//Each substring is balanced.
//Return the maximum number of balanced strings you can obtain.
//
//Constraints:
//-----------
//2 <= s.length <= 1000
//s[i] is either 'L' or 'R'.
//s is a balanced string.

public class SplitAStringInBalancedStrings 
{
	public int balancedStringSplit(String s)
	{
		int res = 0, countR = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='R'){
                countR++;
            }
            else{
                countR--;
            }
            if(countR==0){
                res++;
                countR = 0;
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
		SplitAStringInBalancedStrings Res = new SplitAStringInBalancedStrings();
		System.out.print(Res.balancedStringSplit(N));
	}
}
