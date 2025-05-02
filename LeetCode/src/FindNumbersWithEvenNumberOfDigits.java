import java.util.*;

//1295. Find Numbers with Even Number of Digits (Easy)
//----------------------------------------------------
//Given an array nums of integers, return how many of them contain an even number of digits.
//
//Constraints:
//-----------
//1 <= nums.length <= 500
//1 <= nums[i] <= 10^5

public class FindNumbersWithEvenNumberOfDigits {

	public int findNumbers(int[] nums) 
	{
        int res=0;
		for(int ele:nums) {
			if((9<ele&&ele<100)||(999<ele&&ele<10000)||(ele==100000)){
				res++;
			}
		}
		return res;
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
		FindNumbersWithEvenNumberOfDigits Res = new FindNumbersWithEvenNumberOfDigits();
		System.out.print(Res.findNumbers(arr));
	}

}
