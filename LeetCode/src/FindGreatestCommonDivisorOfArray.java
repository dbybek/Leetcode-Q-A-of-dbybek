import java.util.Scanner;

//1979. Find Greatest Common Divisor of Array (Easy)
//--------------------------------------------------
//Given an integer array nums, return the greatest common divisor of the smallest number and largest number in nums.
//The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.
//
//Constraints:
//-----------
//2 <= nums.length <= 1000
//1 <= nums[i] <= 1000

public class FindGreatestCommonDivisorOfArray 
{
	private int gcd(int a, int b)
	{
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
	
    public int findGCD(int[] nums) 
    {
        int mx = 0, mn = 1001;
        for(int ele:nums){
            mx = Math.max(ele,mx);
            mn = Math.min(ele,mn);
        }
        return gcd(mx,mn);
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
		sc.close();
		FindGreatestCommonDivisorOfArray Res = new FindGreatestCommonDivisorOfArray();
		System.out.print(Res.findGCD(arr));
	}
}
