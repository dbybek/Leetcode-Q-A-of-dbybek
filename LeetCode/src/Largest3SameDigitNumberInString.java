import java.util.Scanner;

//2264. Largest 3-Same-Digit Number in String (Easy)
//--------------------------------------------------
//You are given a string num representing a large integer. An integer is good if it meets the following conditions:
//It is a substring of num with length 3.
//It consists of only one unique digit.
//Return the maximum good integer as a string or an empty string "" if no such integer exists.
//
//Note:
//A substring is a contiguous sequence of characters within a string.
//There may be leading zeroes in num or a good integer.
//
//Constraints:
//-----------
//3 <= num.length <= 1000
//num only consists of digits.

public class Largest3SameDigitNumberInString 
{
	public String largestGoodInteger(String num)
	{
		String[] nums = {"999","888","777","666","555","444","333","222","111","000"};
        for(String ele:nums){
            if(num.contains(ele)){
                return ele;
            }
        }
        return "";
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		sc.close();
		Largest3SameDigitNumberInString Res = new Largest3SameDigitNumberInString();
		System.out.print(Res.largestGoodInteger(N));
	}
}
