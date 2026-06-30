import java.util.Scanner;

//3612. Process String with Special Operations I (Medium)
//-------------------------------------------------------
//You are given a string s consisting of lowercase English letters and the special characters: *, #, and %.
//Build a new string result by processing s according to the following rules from left to right:
//If the letter is a lowercase English letter append it to result.
//A '*' removes the last character from result, if it exists.
//A '#' duplicates the current result and appends it to itself.
//A '%' reverses the current result.
//Return the final string result after processing all characters in s.
//
//Constraints:
//-----------
//1 <= s.length <= 20
//s consists of only lowercase English letters and special characters *, #, and %.

public class ProcessStringWithSpecialOperationsI 
{
	public String processStr(String s)
	{
		StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch>='a' && ch<='z'){
                sb.append(ch);
            }
            else if(sb.length()==0){
                continue;
            }
            else if(ch=='*'){
                sb.setLength(sb.length()-1);
            }
            else if(ch=='%'){
                sb = sb.reverse();
            }
            else {
                sb.append(sb);
            }
        }
        return sb.toString();
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		sc.close();
		ProcessStringWithSpecialOperationsI Res = new ProcessStringWithSpecialOperationsI();
		System.out.print(Res.processStr(N));
	}
}
