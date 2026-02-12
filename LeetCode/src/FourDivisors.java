import java.util.Scanner;

//1390. Four Divisors(Medium)
//---------------------------
//Given an integer array nums, return the sum of divisors of the integers in that array that have exactly four divisors.
//If there is no such integer in the array, return 0.
//Constraints:
//-----------
//1 <= nums.length <= 10^4
//1 <= nums[i] <= 10^5

public class FourDivisors 
{
	private int sumOfDivisors(int N)
    {
        int sum = 0, count = 0;
        for(int i=1;i*i<=N;i++){
            if(N%i==0){
                int d1 = i, d2 = N/i;
                count++;
                sum+=d1;
                if(d1!=d2){
                    count++;
                    sum+=d2;
                }
            }
            if(count>4){
                return 0;
            }
        }
        return (count==4)?sum:0;
    }
	
	public int sumFourDivisors(int[] nums) 
	{
        int res = 0;
        for(int ele:nums){
            res+=sumOfDivisors(ele);
        }
        return res;
    }
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr1 = new int[N];
		for(int i=0;i<N;i++) {
			arr1[i] = sc.nextInt();
		}
		sc.close();
		FourDivisors Res = new FourDivisors();
		System.out.print(Res.sumFourDivisors(arr1));
	}
}
