import java.util.Scanner;

//3005. Count Elements With Maximum Frequency (Easy)
//--------------------------------------------------
//You are given an array nums consisting of positive integers.
//Return the total frequencies of elements in nums such that those elements all have the maximum frequency.
//The frequency of an element is the number of occurrences of that element in the array.
//
//Constraints:
//-----------
//1 <= nums.length <= 100
//1 <= nums[i] <= 100

public class CountElementsWithMaximumFrequency 
{
	public int maxFrequencyElements(int[] nums)
	{
		int mx = 0, n = nums.length;
		for(int i=0;i<n;i++) {
			mx = Math.max(mx, nums[i]);
		}
		int[] freq = new int[mx+1];
		for(int i=0;i<n;i++) {
			freq[nums[i]]++;
		}
		mx = 0;
		int res = 0;
		for(int ele:freq) {
			if(mx < ele) {
				mx = ele;
				res = 1;
			}
			else if(mx==ele) {
				res++;
			}
		}
		return res*mx;
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
		CountElementsWithMaximumFrequency Res = new CountElementsWithMaximumFrequency();
		System.out.print(Res.maxFrequencyElements(arr));
	}
}
