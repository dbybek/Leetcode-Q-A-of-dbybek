import java.util.Scanner;

//3300. Minimum Element After Replacement With Digit Sum (Easy)
//-------------------------------------------------------------
//You are given an integer array nums.
//You replace each element in nums with the sum of its digits.
//Return the minimum element in nums after all replacements.
//Constraints:
//-----------
//1 <= nums.length <= 100
//1 <= nums[i] <= 10^4

public class MinimumElementAfterReplacementWithDigitSum 
{
	public int minElement(int[] nums)
	{
		int res = 50;
        for(int ele:nums){
            int sum = 0;
            while(ele>0){
                sum+=ele%10;
                ele/=10;
            }
            res = Math.min(res,sum);
        }
        return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr1 = new int[N];
		for(int i=0;i<N;i++) {
			arr1[i] = sc.nextInt();
		}
		sc.close();
		MinimumElementAfterReplacementWithDigitSum Res = new MinimumElementAfterReplacementWithDigitSum();
		System.out.print(Res.minElement(arr1));
	}
}
