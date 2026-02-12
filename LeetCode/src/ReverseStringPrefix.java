import java.util.Scanner;

//3794. Reverse String Prefix(Easy)
//---------------------------------
//You are given a string s and an integer k.
//Reverse the first k characters of s and return the resulting string.
//
//Constraints:
//-----------
//1 <= s.length <= 100
//s consists of lowercase English letters.
//1 <= k <= s.length

public class ReverseStringPrefix 
{
	public String reversePrefix(String s, int k)
	{
		StringBuilder sb = new StringBuilder();
        for(int i=k-1;i>=0;i--){
            sb.append(s.charAt(i));
        }
        sb.append(s.substring(k));
        return sb.toString();
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int k = sc.nextInt();
		sc.close();
		ReverseStringPrefix Res = new ReverseStringPrefix();
		System.out.print(Res.reversePrefix(str, k));
	}
}
