import java.util.Scanner;

//3121. Count the Number of Special Characters II (Medium)
//--------------------------------------------------------
//You are given a string word.
//A letter c is called special if it appears both in lowercase and uppercase in word, and
//every lowercase occurrence of c appears before the first uppercase occurrence of c.
//Return the number of special letters in word.
//Constraints:
//-----------
//1 <= word.length <= 2 * 10^5
//word consists of only lowercase and uppercase English letters.

public class CountTheNumberOfSpecialCharactersII 
{
	public int numberOfSpecialChars(String word)
	{
		int[] low = new int[26];
        int[] upp = new int[26];
        for(int i=0;i<26;i++){
            low[i] = -1;
            upp[i] = -1;
        }
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(ch>='a' && ch<='z'){
                low[ch-'a'] = i;
            }
            else if(upp[ch-'A']==-1){
                upp[ch-'A'] = i;
            }
        }
        int res = 0;
        for(int i=0;i<26;i++){
            if(low[i]>-1 && upp[i]>-1 && low[i]<upp[i]){
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
		CountTheNumberOfSpecialCharactersII Res = new CountTheNumberOfSpecialCharactersII();
		System.out.print(Res.numberOfSpecialChars(N));
	}
}
