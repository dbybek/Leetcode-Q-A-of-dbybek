import java.util.Scanner;

//1358. Number of Substrings Containing All Three Characters (Medium)
//-------------------------------------------------------------------
//Given a string s consisting only of characters a, b and c.
//Return the number of substrings containing at least one occurrence of all these characters a, b and c.
//
//Constraints:
//-----------
//3 <= s.length <= 5 x 10^4
//s only consists of a, b or c characters.

public class NumberOfSubstringsContainingAllThreeCharacters 
{
	public int numberOfSubstrings(String s)
	{
		int[] abcCount = new int[3];
        abcCount[0] = -1;
        abcCount[1] = -1;
        abcCount[2] = -1;
        int res = 0, r = 0;
        while(r<s.length()){
            abcCount[s.charAt(r)-'a'] = r;
            int mn = Math.min(abcCount[0],abcCount[1]);
            mn = Math.min(abcCount[2],mn);
            res += (mn+1);
            r++;
        }
        return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String w = sc.next();
		sc.close();
		NumberOfSubstringsContainingAllThreeCharacters Res = new NumberOfSubstringsContainingAllThreeCharacters();
		System.out.print(Res.numberOfSubstrings(w));
	}
}
