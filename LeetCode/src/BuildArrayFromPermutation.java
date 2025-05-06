import java.util.Scanner;

//1920. Build Array from Permutation (Easy)
//-----------------------------------------
//Given a zero-based permutation nums (0-indexed),
//build an array ans of the same length where ans[i] = nums[nums[i]] for each 0 <= i < nums.length and return it.
//A zero-based permutation nums is an array of distinct integers from 0 to nums.length - 1 (inclusive).
//
//Constraints:
//-----------
//1 <= nums.length <= 1000
//0 <= nums[i] < nums.length
//The elements in nums are distinct.

public class BuildArrayFromPermutation 
{
	public int[] buildArray(int[] nums) 
	{
        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            res[i] = nums[nums[i]];
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
		BuildArrayFromPermutation Res = new BuildArrayFromPermutation();
		System.out.print(Res);
	}

}
