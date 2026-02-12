import java.util.Scanner;

//3264. Final Array State After K Multiplication Operations I(Easy)
//-----------------------------------------------------------------
//You are given an integer array nums, an integer k, and an integer multiplier.
//You need to perform k operations on nums. In each operation:
//Find the minimum value x in nums. If there are multiple occurrences of the minimum value,
//select the one that appears first.
//Replace the selected minimum value x with x * multiplier.
//Return an integer array denoting the final state of nums after performing all k operations.
//
//Constraints:
//-----------
//1 <= nums.length <= 100
//1 <= nums[i] <= 100
//1 <= k <= 10
//1 <= multiplier <= 5

public class FinalArrayStateAfterKMultiplicationOperationsI 
{
	public int[] getFinalState(int[] nums, int k, int multiplier) 
	{
        for(int i=0;i<k;i++){
            int mn = Integer.MAX_VALUE, ind = -1;
            for(int j=0;j<nums.length;j++){
                if(nums[j]<mn){
                    mn = nums[j];
                    ind = j;
                }
            }
            nums[ind] = mn*multiplier;
        }
        return nums;
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
		int k = sc.nextInt(), mul = sc.nextInt();
		sc.close();
		FinalArrayStateAfterKMultiplicationOperationsI Res = new FinalArrayStateAfterKMultiplicationOperationsI();
		int[] arr2 = Res.getFinalState(arr1, k, mul);
		for(int ele:arr2) {
			System.out.print(ele+" ");
		}
	}
}
