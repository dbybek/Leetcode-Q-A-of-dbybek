import java.util.Scanner;

//1672. Richest Customer Wealth (Easy)
//------------------------------------
//You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the i​​​​​​​​​​​th​​​​ customer 
//has in the j​​​​​​​​​​​th​​​​ bank. Return the wealth that the richest customer has.
//A customer's wealth is the amount of money they have in all their bank accounts.
//The richest customer is the customer that has the maximum wealth.
//
//Constraints:
//-----------
//m == accounts.length
//n == accounts[i].length
//1 <= m, n <= 50
//1 <= accounts[i][j] <= 100

public class RichestCustomerWealth 
{

	public int maximumWealth(int[][] accounts) 
	{
		int res = 0, n = accounts.length, m = accounts[0].length;
		for(int i=0;i<n;i++) {
			int sum = 0;
			for(int j=0;j<m;j++) {
				sum += accounts[i][j];
			}
			res = Math.max(res, sum);
		}
		return res;
    }
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		int[][] arr = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		sc.close();
		RichestCustomerWealth Res = new RichestCustomerWealth();
		System.out.print(Res.maximumWealth(arr));
	}

}
