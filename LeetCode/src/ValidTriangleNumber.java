import java.util.Arrays;
import java.util.Scanner;

//611. Valid Triangle Number (Medium)
//-----------------------------------
//Given an integer array nums,
//return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.
//
//Constraints:
//-----------
//1 <= nums.length <= 1000
//0 <= nums[i] <= 1000

public class ValidTriangleNumber 
{
	public int triangleNumber(int[] nums)
	{
		Arrays.sort(nums);
		int n = nums.length, res = 0;
		for(int i=n-1;i>=2;i--) {
			int l = 0, r = i-1;
			while(l<r) {
				if(nums[l]+nums[r]>nums[i]) {
					res += r-l;
					r--;
				}
				else {
					l++;
				}
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
		ValidTriangleNumber Res = new ValidTriangleNumber();
		System.out.print(Res.triangleNumber(arr));
	}
}
