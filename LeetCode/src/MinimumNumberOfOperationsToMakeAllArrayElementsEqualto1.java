import java.util.Scanner;

//2654. Minimum Number of Operations to Make All Array Elements Equal to 1 (Medium)
//---------------------------------------------------------------------------------
//You are given a 0-indexed array nums consisiting of positive integers.
//You can do the following operation on the array any number of times:
//Select an index i such that 0 <= i < n - 1 and replace either of nums[i] or nums[i+1] with their gcd value.
//Return the minimum number of operations to make all elements of nums equal to 1. If it is impossible, return -1.
//
//The gcd of two integers is the greatest common divisor of the two integers.
//
//Constraints:
//-----------
//2 <= nums.length <= 50
//1 <= nums[i] <= 10^6

public class MinimumNumberOfOperationsToMakeAllArrayElementsEqualto1 
{
	private int gcd(int a, int b) {
		return b==0?a:gcd(b,a%b);
	}
	
	public int minOperations(int[] nums)
	{
		int oneCount = 0, oddCount = 0, n = nums.length;
		for(int i=0;i<n;i++) {
			if(nums[i]%2==1) {
				oddCount++;
			}
			if(nums[i]==1) {
				oneCount++;
			}
		}
		if(oneCount>0) {
			return n-oneCount;
		}
		if(oddCount==0) {
			return -1;
		}
		int mn = Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			int temp = nums[i];
			for(int j=i+1;j<n;j++) {
				temp = gcd(temp,nums[j]);
				if(temp==1) {
					mn = Math.min(mn, j-i+1);
				}
			}
		}
		return mn==Integer.MAX_VALUE?-1:mn-1+n-1;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr =new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		MinimumNumberOfOperationsToMakeAllArrayElementsEqualto1 Res = new MinimumNumberOfOperationsToMakeAllArrayElementsEqualto1();
		System.out.print(Res.minOperations(arr));
	}
}
