import java.util.Scanner;

//1935. Maximum Number of Words You Can Type (Easy)
//-------------------------------------------------
//There is a malfunctioning keyboard where some letter keys do not work. All other keys on the keyboard work properly.
//
//Given a string text of words separated by a single space (no leading or trailing spaces) and
//a string brokenLetters of all distinct letter keys that are broken,
//return the number of words in text you can fully type using this keyboard.
//
//Constraints:
//-----------
//1 <= text.length <= 10^4
//0 <= brokenLetters.length <= 26
//text consists of words separated by a single space without any leading or trailing spaces.
//Each word only consists of lowercase English letters.
//brokenLetters consists of distinct lowercase English letters.

public class MaximumNumberOfWordsYouCanType 
{
	public int canBeTypedWords(String text, String brokenLetters)
	{
		int n = brokenLetters.length();
		boolean[] broken = new boolean[26];
		for(int i=0;i<n;i++) {
			broken[brokenLetters.charAt(i)-'a'] = true;
		}
		int res = 0;
		n = text.length();
		for(int i=0;i<n;i++) {
			boolean notBrokenWord = true;
			while(i<n && text.charAt(i)!=' ') {
				if(broken[text.charAt(i)-'a'] && notBrokenWord) {
					notBrokenWord = false;
				}
				i++;
			}
			if(notBrokenWord) {
				res++;
			}
		}
		return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String N = sc.nextLine(), M = sc.nextLine();
		sc.close();
		MaximumNumberOfWordsYouCanType Res = new MaximumNumberOfWordsYouCanType();
		System.out.print(Res.canBeTypedWords(N, M));
	}
}
