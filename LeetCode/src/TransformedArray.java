import java.util.Scanner;

//3379. Transformed Array (Easy)
//------------------------------
//You are given an integer array nums that represents a circular array.
//Your task is to create a new array result of the same size, following these rules:
//For each index i (where 0 <= i < nums.length), perform the following independent actions:
//If nums[i] > 0: Start at index i and move nums[i] steps to the right in the circular array.
//Set result[i] to the value of the index where you land.
//If nums[i] < 0: Start at index i and move abs(nums[i]) steps to the left in the circular array.
//Set result[i] to the value of the index where you land.
//If nums[i] == 0: Set result[i] to nums[i].
//Return the new array result.
//
//Note: Since nums is circular, moving past the last element wraps around to the beginning,
//and moving before the first element wraps back to the end.
//
//Constraints:
//-----------
//1 <= nums.length <= 100
//-100 <= nums[i] <= 100

public class TransformedArray 
{
	public int[] constructTransformedArray(int[] nums) 
	{
        int n = nums.length;
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            res[i] = nums[(((i+nums[i])%n)+n)%n];
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
		TransformedArray Res = new TransformedArray();
		System.out.print(Res.constructTransformedArray(arr));
	}
}
