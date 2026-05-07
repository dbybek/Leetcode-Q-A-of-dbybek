import java.util.Scanner;

//796. Rotate String (Easy)
//-------------------------
//Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
//A shift on s consists of moving the leftmost character of s to the rightmost position.
//For example, if s = "abcde", then it will be "bcdea" after one shift.
//Constraints:
//-----------
//1 <= s.length, goal.length <= 100
//s and goal consist of lowercase English letters.

public class RotateString 
{
	public boolean rotateString(String s, String goal)
	{
//		Appraoch I: Without using inbuilt functions.
//		--------------------------------------------
		if(s.length() != goal.length()){
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append(s);
        for(int i=0;i<sb.length();i++){
            int len = 0, j = i;
            while(len<goal.length() && j<sb.length() && sb.charAt(j)==goal.charAt(len)){
                len++;
                j++;
            }
            if(len==goal.length()){
                return true;
            }
        }
        return false;
        
//		Appraoch II: Using inbuilt functions.
//		-------------------------------------
//        if (s.length() != goal.length()) {
//            return false;
//        }
//
//        return (s + s).contains(goal);
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next(), str1 = sc.next();
		sc.close();
		RotateString Res = new RotateString();
		System.out.print(Res.rotateString(str, str1));
	}
}
