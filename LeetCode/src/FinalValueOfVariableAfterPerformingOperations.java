import java.util.Scanner;

//2011. Final Value of Variable After Performing Operations (Easy)
//----------------------------------------------------------------
//There is a programming language with only four operations and one variable X:
//++X and X++ increments the value of the variable X by 1.
//--X and X-- decrements the value of the variable X by 1.
//Initially, the value of X is 0.
//Given an array of strings operations containing a list of operations,
//return the final value of X after performing all the operations.
//
//Constraints:
//-----------
//1 <= operations.length <= 100
//operations[i] will be either "++X", "X++", "--X", or "X--".

public class FinalValueOfVariableAfterPerformingOperations 
{
	public int finalValueAfterOperations(String[] operations)
	{
		int res = 0, n = operations.length;
		for(int i=0;i<n;i++) {
			if(operations[i].charAt(1)=='+') {
				res++;
			}
			else {
				res--;
			}
		}
		return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] arr = new String[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextLine();
		}
		sc.close();
		FinalValueOfVariableAfterPerformingOperations Res = new FinalValueOfVariableAfterPerformingOperations();
		System.out.print(Res.finalValueAfterOperations(arr));
	}
}
