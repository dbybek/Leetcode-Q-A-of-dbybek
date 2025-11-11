import java.util.Scanner;

//3289. The Two Sneaky Numbers of Digitville (Easy)
//-------------------------------------------------
//In the town of Digitville, there was a list of numbers called nums containing integers from 0 to n - 1.
//Each number was supposed to appear exactly once in the list,
//however, two mischievous numbers sneaked in an additional time, making the list longer than usual.
//
//As the town detective, your task is to find these two sneaky numbers.
//Return an array of size two containing the two numbers (in any order), so peace can return to Digitville.
//
//Constraints:
//-----------
//2 <= n <= 100
//nums.length == n + 2
//0 <= nums[i] < n
//The input is generated such that nums contains exactly two repeated elements.

public class TheTwoSneakyNumbersOfDigitville 
{
	public int[] getSneakyNumbers(int[] nums)
	{
		int[] res = new int[2];
		int[] freq = new int[nums.length-2];
		int i = 0;
		for(int ele:nums) {
			if(freq[ele]>0) {
				res[i++] = ele;
			}
			else {
				freq[ele]++;
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
		TheTwoSneakyNumbersOfDigitville Res = new TheTwoSneakyNumbersOfDigitville();
		System.out.print(Res.getSneakyNumbers(arr));
	}
}
