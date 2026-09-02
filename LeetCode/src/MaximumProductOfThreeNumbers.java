import java.util.Scanner;

//628. Maximum Product of Three Numbers (Easy)
//--------------------------------------------
//Given an integer array nums, find three numbers whose product is maximum and return the maximum product.
//
//Constraints:
//-----------
//3 <= nums.length <= 10^4
//-1000 <= nums[i] <= 1000

public class MaximumProductOfThreeNumbers 
{
	public int maximumProduct(int[] nums)
	{
		int mx = -1001, mx1 = -1001, mx2 = -1001, mn = 1001, mn1 = 1001;
        for(int ele:nums){
            if(ele>mx){
                mx2 = mx1;
                mx1 = mx;
                mx = ele;
            }
            else if(ele>mx1){
                mx2 = mx1;
                mx1 = ele;
            }
            else if(ele>mx2){
                mx2 = ele;
            }

            if(mn>ele){
                mn1 = mn;
                mn = ele;
            }
            else if(mn1>ele){
                mn1 = ele;
            }
        }
        return Math.max(mx*mx1*mx2, mx*mn*mn1);
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
		MaximumProductOfThreeNumbers Res = new MaximumProductOfThreeNumbers();
		System.out.print(Res.maximumProduct(arr));
	}
}
