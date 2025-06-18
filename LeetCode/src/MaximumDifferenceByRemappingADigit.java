import java.util.Scanner;

//2566. Maximum Difference by Remapping a Digit (Easy)
//----------------------------------------------------
//You are given an integer num.
//You know that Bob will sneakily remap one of the 10 possible digits (0 to 9) to another digit.
//
//Return the difference between the maximum and minimum values Bob can make by remapping exactly one digit in num.
//
//Notes:
//
//When Bob remaps a digit d1 to another digit d2, Bob replaces all occurrences of d1 in num with d2.
//Bob can remap a digit to itself, in which case num does not change.
//Bob can remap different digits for obtaining minimum and maximum values respectively.
//The resulting number after remapping can contain leading zeroes.
//
//Constraints:
//-----------
//1 <= num <= 10^8

public class MaximumDifferenceByRemappingADigit 
{

	public int minMaxDifference(int num)
	{
		String str = Integer.toString(num), str2 = Integer.toString(num);
		int n = str.length();
		char ch = str2.charAt(0);
		str2 = str2.replace(ch, '0');
		int mn = Integer.parseInt(str2);
		ch = ' ';
		for(int i=0;i<n;i++) {
			if(str.charAt(i) != '9') {
				ch = str.charAt(i);
				break;
			}
		}
		if(ch==' ') {
			return num;
		}
		str = str.replace(ch, '9');
		int mx = Integer.parseInt(str);
		return mx-mn;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		MaximumDifferenceByRemappingADigit Res = new MaximumDifferenceByRemappingADigit();
		System.out.print(Res.minMaxDifference(N));
	}

}
