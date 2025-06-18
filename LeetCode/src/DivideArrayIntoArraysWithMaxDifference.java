import java.util.Scanner;

//2966. Divide Array Into Arrays With Max Difference (Medium)
//-----------------------------------------------------------
//You are given an integer array nums of size n where n is a multiple of 3 and a positive integer k.
//Divide the array nums into n / 3 arrays of size 3 satisfying the following condition:
//
//The difference between any two elements in one array is less than or equal to k.
//Return a 2D array containing the arrays. If it is impossible to satisfy the conditions, return an empty array.
//And if there are multiple answers, return any of them.
//
//Constraints:
//-----------
//n == nums.length
//1 <= n <= 10^5
//n is a multiple of 3
//1 <= nums[i] <= 10^5
//1 <= k <= 10^5

public class DivideArrayIntoArraysWithMaxDifference 
{	
	public int[][] divideArray(int[] nums, int k)
	{
		int n = nums.length, mx = 0;
		for(int ele:nums) {
			mx = Math.max(ele, mx);
		}
		int[] freq = new int[mx+1];
		for(int ele:nums) {
			freq[ele]++;
		}
		int[][] res = new int[n/3][3];
		int i = 0, j = 0;
		for(int l=0;l<=mx;l++) {
			while(freq[l]>0) {
				res[i][j++] = l;
				if(j==3) {
					if(Math.abs(res[i][0]-res[i][2]) > k) {
						return new int[0][0];
					}
					i++;
					j = 0;
				}
				freq[l]--;
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
		int K = sc.nextInt();
		sc.close();
		DivideArrayIntoArraysWithMaxDifference Res = new DivideArrayIntoArraysWithMaxDifference();
		int[][] arr1 = Res.divideArray(arr, K);
		for(int[] ar:arr1) {
			for(int ele:ar) {
				System.out.print(ele+" ");
			}
			System.out.println();
		}
	}

}
