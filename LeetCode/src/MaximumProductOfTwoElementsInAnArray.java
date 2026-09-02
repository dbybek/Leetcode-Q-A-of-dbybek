import java.util.Scanner;

//1464. Maximum Product of Two Elements in an Array (Easy)
//--------------------------------------------------------
//Given the array of integers nums, you will choose two different indices i and j of that array.
//Return the maximum value of (nums[i]-1)*(nums[j]-1).
//
//Constraints:
//-----------
//2 <= nums.length <= 500
//1 <= nums[i] <= 10^3

public class MaximumProductOfTwoElementsInAnArray 
{
	public int maxProduct(int[] nums)
	{
		int mx = 0, mx2 = 0;
        for(int ele:nums){
            if(ele > mx){
                mx2 = mx;
                mx = ele;
            }
            else if(ele > mx2){
                mx2 = ele;
            }
        }
        return (mx-1)*(mx2-1);
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
		MaximumProductOfTwoElementsInAnArray Res = new MaximumProductOfTwoElementsInAnArray();
		System.out.print(Res.maxProduct(arr));
	}
}
