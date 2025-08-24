import java.util.Scanner;

//1678. Goal Parser Interpretation (Easy)
//---------------------------------------
//You own a Goal Parser that can interpret a string command.
//The command consists of an alphabet of "G", "()" and/or "(al)" in some order.
//The Goal Parser will interpret "G" as the string "G", "()" as the string "o", and "(al)" as the string "al".
//The interpreted strings are then concatenated in the original order.
//Given the string command, return the Goal Parser's interpretation of command.
//
//Constraints:
//-----------
//1 <= command.length <= 100
//command consists of "G", "()", and/or "(al)" in some order.

public class GoalParserInterpretation 
{
	public String interpret(String command)
	{
		StringBuilder res=new StringBuilder();
        int n=command.length();
        for(int i=0;i<n;i++){
            char ch=command.charAt(i);
            if(ch=='G'){
                res.append(ch);
            }
            if(ch==')'){
                if(command.charAt(i-1)=='l'){
                    res.append("al");
                }
                else{
                    res.append('o');
                }
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
		GoalParserInterpretation Res = new GoalParserInterpretation();
		System.out.print(Res.interpret(N));
	}
}
