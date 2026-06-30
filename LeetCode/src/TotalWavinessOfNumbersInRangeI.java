import java.util.Scanner;

//3751. Total Waviness of Numbers in Range I (Medium)
//---------------------------------------------------
//You are given two integers num1 and num2 representing an inclusive range [num1, num2].
//The waviness of a number is defined as the total count of its peaks and valleys:
//
//A digit is a peak if it is strictly greater than both of its immediate neighbors.
//A digit is a valley if it is strictly less than both of its immediate neighbors.
//The first and last digits of a number cannot be peaks or valleys.
//Any number with fewer than 3 digits has a waviness of 0.
//Return the total sum of waviness for all numbers in the range [num1, num2].
//Constraints:
//-----------
//1 <= num1 <= num2 <= 10^5

public class TotalWavinessOfNumbersInRangeI 
{
	private int waviness(int n)
    {
        int waveC = 0;
        while(n/100!=0){
            int u = n%10, t = (n/10)%10, h = (n/100)%10;
            if((t>u && t>h) || (t<u && t<h)){
                waveC++;
            }
            n/=10;
        }
        return waveC;
    }
	
	public int totalWaviness(int num1, int num2)
	{
		if(num2<100){
            return 0;
        }
        if(num1<100 && num2>100){
            num1 = 100;
        }
        int res = 0;
        for(int i=num1;i<=num2;i++){
            res += waviness(i);
        }
        return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		sc.close();
		TotalWavinessOfNumbersInRangeI Res = new TotalWavinessOfNumbersInRangeI();
		System.out.print(Res.totalWaviness(N, M));
	}
}
