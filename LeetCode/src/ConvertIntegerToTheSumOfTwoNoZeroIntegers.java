import java.util.Scanner;

//1317. Convert Integer to the Sum of Two No-Zero Integers (Easy)
//---------------------------------------------------------------
//No-Zero integer is a positive integer that does not contain any 0 in its decimal representation.
//Given an integer n, return a list of two integers [a, b] where:
//
//a and b are No-Zero integers.
//a + b = n
//The test cases are generated so that there is at least one valid solution.
//If there are many valid solutions, you can return any of them.
//
//Constraints:
//-----------
//2 <= n <= 10^4

public class ConvertIntegerToTheSumOfTwoNoZeroIntegers 
{
	private boolean containsZero(int x)
	{
		while(x>0) {
			if(x%10==0) {
				return true;
			}
			x/=10;
		}
		return false;
	}
	
	public int[] getNoZeroIntegers(int n)
	{
		int[] res = new int[2];
		for(int i=1;i<n;i++) {
			int j = n-i;
			if(!containsZero(i) && !containsZero(j)) {
				res[0] = i;
				res[1] = j;
				break;
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
		ConvertIntegerToTheSumOfTwoNoZeroIntegers Res = new ConvertIntegerToTheSumOfTwoNoZeroIntegers();
		int[] arr = Res.getNoZeroIntegers(N);
		System.out.print(arr[0]+" "+arr[1]);
	}
}
