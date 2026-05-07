import java.util.Scanner;

//2839. Check if Strings Can be Made Equal With Operations I (Easy)
//-----------------------------------------------------------------
//You are given two strings s1 and s2, both of length 4, consisting of lowercase English letters.
//You can apply the following operation on any of the two strings any number of times:
//
//Choose any two indices i and j such that j - i = 2, then swap the two characters at those indices in the string.
//Return true if you can make the strings s1 and s2 equal, and false otherwise.
//
//Constraints:
//-----------
//s1.length == s2.length == 4
//s1 and s2 consist only of lowercase English letters.

public class CheckIfStringsCanBeMadeEqualWithOperationsI 
{
	public boolean canBeEqual(String s1, String s2)
	{
		if(s1.charAt(0)!=s2.charAt(0) && s1.charAt(0)!=s2.charAt(2)){
            return false;
        }
        if(s1.charAt(1)!=s2.charAt(1) && s1.charAt(1)!=s2.charAt(3)){
            return false;
        }
        if(s1.charAt(2)!=s2.charAt(2) && s1.charAt(2)!=s2.charAt(0)){
            return false;
        }
        if(s1.charAt(3)!=s2.charAt(3) && s1.charAt(3)!=s2.charAt(1)){
            return false;
        }
        return true;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine(), str1 = sc.next();
		sc.close();
		CheckIfStringsCanBeMadeEqualWithOperationsI Res = new CheckIfStringsCanBeMadeEqualWithOperationsI();
		System.out.print(Res.canBeEqual(str, str1));
	}
}
