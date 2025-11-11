import java.util.Scanner;

//2169. Count Operations to Obtain Zero (Easy)
//--------------------------------------------
//You are given two non-negative integers num1 and num2.
//In one operation, if num1 >= num2, you must subtract num2 from num1, otherwise subtract num1 from num2.
//
//For example, if num1 = 5 and num2 = 4, subtract num2 from num1, thus obtaining num1 = 1 and num2 = 4.
//However, if num1 = 4 and num2 = 5, after one operation, num1 = 4 and num2 = 1.
//Return the number of operations required to make either num1 = 0 or num2 = 0.
//
//Constraints:
//-----------
//0 <= num1, num2 <= 10^5

public class CountOperationsToObtainZero 
{
	public int countOperations(int num1, int num2)
	{
		int res = 0;
		while(num1>0 && num2>0) {
			if(num1<num2) {
				res+=(num2/num1);
				num2%=num1;
			}
			else {
				res+=(num1/num2);
				num1%=num2;
			}
		}
		return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		sc.close();
		CountOperationsToObtainZero Res = new CountOperationsToObtainZero();
		System.out.print(Res.countOperations(N, M));
	}
}
