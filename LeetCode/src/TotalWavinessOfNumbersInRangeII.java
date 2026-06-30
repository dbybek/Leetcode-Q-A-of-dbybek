import java.util.Scanner;

//3753. Total Waviness of Numbers in Range II (Hard)
//--------------------------------------------------
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
//1 <= num1 <= num2 <= 10^15

public class TotalWavinessOfNumbersInRangeII 
{
	static final int[] wv = new int[570];

    static{
        int ind = 0;
        for(int i=0;i<1000;i++){
            int u = i%10, t = (i/10)%10, h = (i/100)%10;
            if((t>u && t>h) || (t<u && t<h)){
                wv[ind++] = i;
            }
        }
    }
    
	private long waviness(long n)
    {
        long res = 0;
        for(int ele:wv){
            res+=countWaves(n,ele);
        }
        return res;
    }
	
	private long countWaves(long n, int p)
    {
        long t = p<100?1:0, count = 0, m = 1;
        while(m*100<=n){
            long pre = n/(m*1000), cur = (n/m)%1000, suf = n%m, w = 0;
            if(cur > p){
                w = pre-t+1;
            }
            else if(cur==p){
                w = Math.max(0L,pre-t);
                count+=suf+1;
            }
            else{
                w = Math.max(0L,pre-t);
            }
            count += w*m;
            m*=10;
        }
        return count;
    }
	
	public long totalWaviness(long num1, long num2)
	{
		if(num2<100){
            return 0L;
        }
        if(num1<100 && num2>100){
            num1 = 100;
        }
        return waviness(num2) - waviness(num1-1);
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong() , M = sc.nextLong();
		sc.close();
		TotalWavinessOfNumbersInRangeII Res = new TotalWavinessOfNumbersInRangeII();
		System.out.print(Res.totalWaviness(N, M));
	}
}
