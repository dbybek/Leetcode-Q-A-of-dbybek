import java.util.Scanner;

//2840. Check if Strings Can be Made Equal With Operations II (Medium)
//--------------------------------------------------------------------
//You are given two strings s1 and s2, both of length n, consisting of lowercase English letters.
//You can apply the following operation on any of the two strings any number of times:
//
//Choose any two indices i and j such that i < j and the difference j - i is even,
//then swap the two characters at those indices in the string.
//Return true if you can make the strings s1 and s2 equal, and false otherwise.
//
//Constraints:
//-----------
//n == s1.length == s2.length
//1 <= n <= 10^5
//s1 and s2 consist only of lowercase English letters.

public class CheckIfStringsCanBeMadeEqualWithOperationsII 
{
	public boolean checkStrings(String s1, String s2)
	{
		int[] freq = new int[52];
        int off = 0;
        for (int i = 0; i < s1.length(); i++) {
            off = (i & 1) * 26;
            freq[s1.charAt(i) - 'a' + off]++;
            freq[s2.charAt(i) - 'a' + off]--;
        }
        for (int i = 0; i < 52; i++){
            if (freq[i] != 0) {
                return false;
            }
        }
        return true;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine(), str1 = sc.next();
		sc.close();
		CheckIfStringsCanBeMadeEqualWithOperationsII Res = new CheckIfStringsCanBeMadeEqualWithOperationsII();
		System.out.print(Res.checkStrings(str, str1));
	}
}
