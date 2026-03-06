import java.util.Scanner;

//3713. Longest Balanced Substring I (Medium)
//-------------------------------------------
//Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
//You must implement a solution with a linear runtime complexity and use only constant extra space.
//
//Constraints:
//-----------
//1 <= nums.length <= 3 * 10^4
//-3 * 104 <= nums[i] <= 3 * 10^4
//Each element in the array appears twice except for one element which appears only once.

public class SingleNumber 
{
	public int singleNumber(int[] nums) 
	{
        int res = 0;
        for(int ele:nums){
            res^=ele;
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
		SingleNumber Res = new SingleNumber();
		System.out.print(Res.singleNumber(arr));
	}
}
