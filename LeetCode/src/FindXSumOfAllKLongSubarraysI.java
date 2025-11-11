import java.util.Scanner;

//3318. Find X-Sum of All K-Long Subarrays I (Easy)
//-------------------------------------------------
//You are given an array nums of n integers and two integers k and x.
//The x-sum of an array is calculated by the following procedure:
//
//Count the occurrences of all elements in the array.
//Keep only the occurrences of the top x most frequent elements.
//If two elements have the same number of occurrences, the element with the bigger value is considered more frequent.
//Calculate the sum of the resulting array.
//Note that if an array has less than x distinct elements, its x-sum is the sum of the array.
//
//Return an integer array answer of length n - k + 1 where answer[i] is the x-sum of the subarray nums[i..i + k - 1].
//
//Constraints:
//-----------
//1 <= n == nums.length <= 50
//1 <= nums[i] <= 50
//1 <= x <= k <= nums.length

public class FindXSumOfAllKLongSubarraysI 
{
	public int[] findXSum(int[] nums, int k, int x)
	{
		int[] freq = new int[51];
		for(int i=0;i<k-1;i++) {
			freq[nums[i]]++;
		}
		
		int[] res = new int[nums.length-k+1];
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
		int k = sc.nextInt(), x = sc.nextInt();
		sc.close();
		FindXSumOfAllKLongSubarraysI Res = new FindXSumOfAllKLongSubarraysI();
		int[] arr1 = Res.findXSum(arr, k, x);
		for(int ele:arr1) {
			System.out.print(ele+" ");
		}
	}
}
