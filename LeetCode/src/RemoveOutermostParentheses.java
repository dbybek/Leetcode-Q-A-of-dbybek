import java.util.Scanner;

//1021. Remove Outermost Parentheses (Easy)
//-----------------------------------------
//A valid parentheses string is either empty "", "(" + A + ")", or A + B,
//where A and B are valid parentheses strings, and + represents string concatenation.
//For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
//A valid parentheses string s is primitive if it is nonempty,
//and there does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.
//Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk,
//where Pi are primitive valid parentheses strings.
//Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.
//
//Constraints:
//-----------
//1 <= s.length <= 10^5
//s[i] is either '(' or ')'.
//s is a valid parentheses string.

public class RemoveOutermostParentheses 
{
	public String removeOuterParentheses(String s)
	{
		StringBuilder res = new StringBuilder();
        int temp = 0;
        for(int i=0;i<s.length();i++){
            // char ch = s.charAt(i);
            if(s.charAt(i)=='('){
                if(temp>0){
                    res.append(s.charAt(i));
                }
                temp++;
            }
            else{
                if(temp>1){
                    res.append(s.charAt(i));
                }
                temp--;
            }
        }
        return res.toString();
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		sc.close();
		RemoveOutermostParentheses Res = new RemoveOutermostParentheses();
		System.out.print(Res.removeOuterParentheses(N));
	}
}
