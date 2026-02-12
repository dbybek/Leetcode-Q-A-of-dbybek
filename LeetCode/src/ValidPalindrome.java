import java.util.Scanner;

//125. Valid Palindrome (Easy)
//----------------------------
//A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and
//removing all non-alphanumeric characters, it reads the same forward and backward.
//Alphanumeric characters include letters and numbers.
//Given a string s, return true if it is a palindrome, or false otherwise.
//
//Constraints:
//-----------
//1 <= s.length <= 2 * 10^5
//s consists only of printable ASCII characters.

public class ValidPalindrome 
{
	public boolean isPalindrome(String s) 
	{
		int l = 0, r = s.length()-1;
        while(l<r){
            char chl = s.charAt(l), chr = s.charAt(r);
            if(chl>='A' && chl<='Z'){
                chl += 32;
            }
            else if((chl<'a' || chl>'z') && (chl<'0' || chl>'9')){
                l++;
                continue;
            }
            
            if(chr>='A' && chr<='Z'){
                chr += 32;
            }
            else if((chr<'a' || chr>'z') && (chr<'0' || chr>'9')){
                r--;
                continue;
            }

            if(chl!=chr){
                return false;
            }
            l++;
            r--;
        }
        return true;
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		sc.close();
		ValidPalindrome Res = new ValidPalindrome();
		System.out.print(Res.isPalindrome(N));
	}
}
