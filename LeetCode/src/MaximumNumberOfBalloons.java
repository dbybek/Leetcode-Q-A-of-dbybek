import java.util.Scanner;

//1189. Maximum Number of Balloons (Easy)
//---------------------------------------
//Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
//You can use each character in text at most once. Return the maximum number of instances that can be formed.
//
//Constraints:
//-----------
//1 <= text.length <= 10^4
//text consists of lower case English letters only.

public class MaximumNumberOfBalloons 
{
	public int maxNumberOfBalloons(String text)
	{
		int b = 0, a = 0, l = 0, o = 0, n = 0;
        for (char ch : text.toCharArray()) {
            switch (ch) {
                case 'b': b++; break;
                case 'a': a++; break;
                case 'l': l++; break;
                case 'o': o++; break;
                case 'n': n++; break;
            }
        }
        l = l / 2;
        o = o / 2;
        return Math.min(b, Math.min(a, Math.min(l, Math.min(o, n))));
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		sc.close();
		MaximumNumberOfBalloons Res = new MaximumNumberOfBalloons();
		System.out.print(Res.maxNumberOfBalloons(N));
	}
}
