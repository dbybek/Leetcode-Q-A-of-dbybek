import java.util.Scanner;

//2798. Number of Employees Who Met the Target (Easy)
//---------------------------------------------------
//There are n employees in a company, numbered from 0 to n - 1.
//Each employee i has worked for hours[i] hours in the company.
//The company requires each employee to work for at least target hours.
//You are given a 0-indexed array of non-negative integers hours of length n and a non-negative integer target.
//Return the integer denoting the number of employees who worked at least target hours.
//
//Constraints:
//-----------
//1 <= n == hours.length <= 50
//0 <= hours[i], target <= 10^5

public class NumberOfEmployeesWhoMetTheTarget 
{
	public int numberOfEmployeesWhoMetTarget(int[] hours, int target)
	{
		int res = 0;
        for(int hour:hours){
            if(hour>=target){
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
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		sc.close();
		NumberOfEmployeesWhoMetTheTarget Res = new NumberOfEmployeesWhoMetTheTarget();
		System.out.print(Res.numberOfEmployeesWhoMetTarget(arr, k));
	}
}
