import java.util.Scanner;

//3120. Count the Number of Special Characters I (Easy)
//-----------------------------------------------------
//You are given a string word. A letter is called special if it appears both in lowercase and uppercase in word.
//Return the number of special letters in word.
//Constraints:
//-----------
//1 <= word.length <= 50
//word consists of only lowercase and uppercase English letters.

public class CountTheNumberOfSpecialCharactersI 
{
	public int numberOfSpecialChars(String word)
	{
		boolean[] low = new boolean[26];
        boolean[] upp = new boolean[26];
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(ch>='A' && ch<='Z'){
                upp[ch-'A'] = true;
            }
            else{
                low[ch-'a'] = true;
            }
        }
        int res = 0;
        for(int i=0;i<26;i++){
            if(low[i]&&upp[i]){
                res++;
            }
        }
        return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		sc.close();
		CountTheNumberOfSpecialCharactersI Res = new CountTheNumberOfSpecialCharactersI();
		System.out.print(Res.numberOfSpecialChars(N));
	}
}
