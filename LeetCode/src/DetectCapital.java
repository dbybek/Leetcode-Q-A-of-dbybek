import java.util.Scanner;

//520. Detect Capital (Easy)
//--------------------------
//We define the usage of capitals in a word to be right when one of the following cases holds:
//All letters in this word are capitals, like "USA".
//All letters in this word are not capitals, like "leetcode".
//Only the first letter in this word is capital, like "Google".
//Given a string word, return true if the usage of capitals in it is right.
//Constraints:
//-----------
//1 <= word.length <= 100
//word consists of lowercase and uppercase English letters.

public class DetectCapital 
{
	public boolean detectCapitalUse(String word)
	{
		int capCount = 0;
        char ch;
        for(int i=0;i<word.length();i++){
            ch = word.charAt(i);
            if(ch>='A' && ch<='Z'){
                capCount++;
            }
        }
        if(capCount==0 || capCount==word.length()){
            return true;
        }
        ch = word.charAt(0);
        return (capCount==1 && ch>='A' && ch<='Z');
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		sc.close();
		DetectCapital Res = new DetectCapital();
		System.out.print(Res.detectCapitalUse(N));
	}
}
