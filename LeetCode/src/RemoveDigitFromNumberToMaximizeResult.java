import java.util.Scanner;

//2259. Remove Digit From Number to Maximize Result (Easy)
//--------------------------------------------------------
//You are given a string number representing a positive integer and a character digit.
//Return the resulting string after removing exactly one occurrence of digit from number 
//such that the value of the resulting string in decimal form is maximized.
//The test cases are generated such that digit occurs at least once in number.
//
//Constraints:
//-----------
//2 <= number.length <= 100
//number consists of digits from '1' to '9'.
//digit is a digit from '1' to '9'.
//digit occurs at least once in number.

public class RemoveDigitFromNumberToMaximizeResult 
{
	public String removeDigit(String number, char digit) 
	{
        String res = "";
        int n = number.length();
        for(int i=0;i<n;i++){
            if(number.charAt(i) == digit){
                String str = number.substring(0,i) + number.substring(i+1,n);
                if(res.compareTo(str) < 0){
                    res = str;
                }
            }
        }
        return res;
    }
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char ch = sc.next().charAt(0);
		sc.close();
		RemoveDigitFromNumberToMaximizeResult Res = new RemoveDigitFromNumberToMaximizeResult();
		System.out.print(Res.removeDigit(str, ch));
	}

}
