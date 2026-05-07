import java.util.Scanner;

//788. Rotated Digits (Medium)
//----------------------------
//An integer x is a good if after rotating each digit individually by 180 degrees,
//we get a valid number that is different from x. Each digit must be rotated - we cannot choose to leave it alone.
//A number is valid if each digit remains a digit after rotation. For example:
//
//0, 1, and 8 rotate to themselves,
//2 and 5 rotate to each other
//(in this case they are rotated in a different direction, in other words, 2 or 5 gets mirrored),
//6 and 9 rotate to each other, and
//the rest of the numbers do not rotate to any other number and become invalid.
//Given an integer n, return the number of good integers in the range [1, n].
//Constraints:
//-----------
//1 <= n <= 10^4

public class RotatedDigits 
{
	private boolean checkNumber(int num)
	{
        boolean diff = false;
        while(num>0){
            int lastDigit = num%10;
            num/=10;
            if(lastDigit==3 || lastDigit==4 || lastDigit==7){
                return false;
            }
            if(lastDigit==2 || lastDigit==5 || lastDigit==6 || lastDigit==9){
                diff = true;
            }
        }
        return diff;
    }
	
	public int rotatedDigits(int n)
	{
		int res = 0;
        for(int i=1;i<=n;i++){
            if(checkNumber(i)){
                res++;
            }
        }
        return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		RotatedDigits Res = new RotatedDigits();
		System.out.print(Res.rotatedDigits(N));
	}
}
