import java.util.Scanner;

//70. Climbing Stairs (Easy)
//--------------------------
//You are climbing a staircase. It takes n steps to reach the top.
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//
//Constraints:
//-----------
//1 <= n <= 45

public class ClimbingStairs 
{
	public int climbStairs(int n) 
	{
//		Approach I: Fibonacci using 3 variables.
//		----------------------------------------
//		if(n<2) {
//			return n;
//		}
//		int res = 0, fib1 = 1, fib2 = 1;
//		for(int i=2;i<=n;i++) {
//			res = fib1 + fib2;
//			fib1 = fib2;
//			fib2 = res;
//		}
//		return res;
//		
//		Approach II: Fibonacci using 2 variables.
//		-----------------------------------------
		if(n<2) {
			return n;
		}
        int res = 1, count = 1;
        for(int i=2;i<=n;i++){
            res += count;
            count = res - count;
        }
        return res;
    }
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		ClimbingStairs Res = new ClimbingStairs();
		System.out.print(Res.climbStairs(N));
	}
}