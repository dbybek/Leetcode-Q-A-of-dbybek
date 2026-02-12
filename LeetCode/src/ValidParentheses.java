import java.util.*;

//20. Valid Parentheses(Easy)
//---------------------------
//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//An input string is valid if:
//
//Open brackets must be closed by the same type of brackets.
//Open brackets must be closed in the correct order.
//Every close bracket has a corresponding open bracket of the same type.
//
//Constraints:
//-----------
//1 <= s.length <= 10^4
//s consists of parentheses only '()[]{}'.

public class ValidParentheses 
{
	public boolean isValid(String s)
	{
		Stack<Character> stk = new Stack<>();
		for(int i=0;i<s.length();i++) {
			char ch = s.charAt(i);
			if(ch=='(' || ch=='[' || ch=='{') {
				stk.push(ch);
			}
			else {
				if(stk.isEmpty()) {
					return false;
				}
				char top = stk.pop();
				if((ch==')' && top!='(') || (ch==']' && top!='[') || (ch=='}' && top!='{')) {
					return false;
				}
			}
		}
		return stk.isEmpty();
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();
		ValidParentheses Res = new ValidParentheses();
		System.out.print(Res.isValid(str));
	}
}
