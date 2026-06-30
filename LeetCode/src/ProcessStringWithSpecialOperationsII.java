import java.util.Scanner;

//3614. Process String with Special Operations II (Hard)
//------------------------------------------------------
//You are given a string s consisting of lowercase English letters and the special characters: '*', '#', and '%'.
//You are also given an integer k.
//Build a new string result by processing s according to the following rules from left to right:
//If the letter is a lowercase English letter append it to result.
//A '*' removes the last character from result, if it exists.
//A '#' duplicates the current result and appends it to itself.
//A '%' reverses the current result.
//Return the kth character of the final string result. If k is out of the bounds of result, return '.'.
//
//Constraints:
//-----------
//1 <= s.length <= 10^5
//s consists of only lowercase English letters and special characters '*', '#', and '%'.
//0 <= k <= 10^15
//The length of result after processing s will not exceed 10^15.

public class ProcessStringWithSpecialOperationsII 
{
	public char processStr(String s, long k)
	{
		long l = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='*'){
                l = Math.max(l-1,0);
            }
            else if(ch=='#'){
                l*=2;
            }
            else if(ch!='%'){
                l++;
            }
        }
        if(l<=k){
            return '.';
        }
        for(int i=s.length()-1;i>=0;i--){
            char ch = s.charAt(i);
            if(ch=='*'){
                l++;
            }
            else if(ch=='#'){
                l/=2;
                if(k>=l){
                    k-=l;
                }
            }
            else if(ch=='%'){
                k = l-1-k;
            }
            else{
                if(k==l-1){
                    return ch;
                }
                l--;
            }
        }
        return '.';
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		long k = sc.nextLong();
		sc.close();
		ProcessStringWithSpecialOperationsII Res = new ProcessStringWithSpecialOperationsII();
		System.out.print(Res.processStr(N, k));
	}
}
