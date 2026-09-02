import java.util.Scanner;

//3945. Digit Frequency Score (Easy)
//----------------------------------
//You are given an integer n.
//The score of n is defined as the sum of d * freq(d) over all distinct digits d,
//where freq(d) denotes the number of times the digit d appears in n.
//
//Return an integer denoting the score of n.
//
//Constraints:
//-----------
//1 <= n <= 10^9

public class DigitFrequencyScore 
{
	public int digitFrequencyScore(int n)
	{
		int res = 0;
        for(int i=n;i>0;i/=10){
            res+=(i%10);
        }
        return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		DigitFrequencyScore Res = new DigitFrequencyScore();
		System.out.print(Res.digitFrequencyScore(N));
	}
}
