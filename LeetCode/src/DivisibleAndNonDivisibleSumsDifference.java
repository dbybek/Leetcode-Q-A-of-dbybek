import java.util.Scanner;

//2894. Divisible and Non-divisible Sums Difference (Easy)
//--------------------------------------------------------
//You are given positive integers n and m.
//Define two integers as follows:
//
//num1: The sum of all integers in the range [1, n] (both inclusive) that are not divisible by m.
//num2: The sum of all integers in the range [1, n] (both inclusive) that are divisible by m.
//Return the integer num1 - num2.
//
//Constraints:
//-----------
//1 <= n, m <= 1000

public class DivisibleAndNonDivisibleSumsDifference 
{

	public int differenceOfSums(int n, int m) 
	{
//		Approach I: using loop and checking if the number is divisible or not
//		---------------------------------------------------------------------
//        int ndv=0,dv=0;
//        for(int i=1;i<=n;i++){
//            if(i%m==0){
//                dv+=i;
//            }
//            else{
//                ndv+=i;
//            }
//        }
//        return ndv-dv;
//		
//		Approach II: Using maths.
//		-------------------------
//		We need sum of divisible - sum of non divisibles.
//		In that case we can say,
//		  Total sum of 1 to N = sum of divisible + sum of Non divisible
//		=>sum of Non divisible = Total sum of 1 to N - sum of divisible
//		=>sum of Non divisible - sum of divisible = Total sum of 1 to N - sum of divisible - sum of divisible
//		=>sum of Non divisible - sum of divisible = Total sum of 1 to N - (2*sum of divisible)
//		=>sum of Non divisible - sum of divisible = (N*(N+1))/2 - (2*M*K*(K+1)/2)   (where K = N/M)
//		=>sum of Non divisible - sum of divisible = (N*(N+1))/2 - (M*K*(K+1))  (Final formula)
		int k = n/m;
		int totalSum = (n*(n+1))/2, twoTimesSumOfDivisible = m*k*(k+1);
		return totalSum-twoTimesSumOfDivisible;
    }
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		sc.close();
		DivisibleAndNonDivisibleSumsDifference Res = new DivisibleAndNonDivisibleSumsDifference();
		System.out.print(Res.differenceOfSums(N, M));
	}

}
