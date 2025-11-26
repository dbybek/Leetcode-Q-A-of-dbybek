import java.util.Scanner;

//1262. Greatest Sum Divisible by Three (Medium)
//----------------------------------------------
//Given an integer array nums, return the maximum possible sum of elements of the array such that it is divisible by three.
//
//Constraints:
//-----------
//1 <= nums.length <= 4 * 10^4
//1 <= nums[i] <= 10^4

public class GreatestSumDivisibleByThree 
{
	public int maxSumDivThree(int[] nums)
	{
		int sum = 0;
        for (int ele:nums) {
        	sum+=ele;
        }
        if (sum%3==0) {
        	return sum;
        }
        int[] ones = new int[2];
        int[] twos = new int[2];
        ones[0] = 1000000000;
        ones[1] = 1000000000;
        twos[0] = 1000000000;
        twos[1] = 1000000000;
        for (int ele:nums) {
        	int temp;
            if (ele%3==1) {
                ones[1] = Math.min(ele, ones[1]);
                temp = Math.max(ones[0], ones[1]);
                ones[0] = Math.min(ones[0],ones[1]);
                ones[1] = temp;
            } 
            else if (ele%3==2) {
                twos[1] = Math.min(ele, twos[1]);
                temp = Math.max(twos[0], twos[1]);
                twos[0] = Math.min(twos[0],twos[1]);
                twos[1] = temp;
            }
        }
        if (sum%3==1) {
        	return Math.max(sum-ones[0], sum-twos[1]-twos[0]);
        }
        return Math.max(sum-twos[0], sum-ones[1]-ones[0]);
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
		GreatestSumDivisibleByThree Res = new GreatestSumDivisibleByThree();
		System.out.print(Res.maxSumDivThree(arr));
	}
}
