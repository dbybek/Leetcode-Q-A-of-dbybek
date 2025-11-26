import java.util.Scanner;

//3190. Find Minimum Operations to Make All Elements Divisible by Three (Easy)
//----------------------------------------------------------------------------
//You are given an integer array nums. In one operation, you can add or subtract 1 from any element of nums.
//Return the minimum number of operations to make all elements of nums divisible by 3.
//
//Constraints:
//-----------
//1 <= nums.length <= 50
//1 <= nums[i] <= 50

public class FindMinimumOperationsToMakeAllElementsDivisibleByThree 
{
	public int minimumOperations(int[] nums)
	{
		int res=0;
        for(int ele:nums){
            if(ele%3>0){
                res++;
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
		FindMinimumOperationsToMakeAllElementsDivisibleByThree Res = new FindMinimumOperationsToMakeAllElementsDivisibleByThree();
		System.out.print(Res.minimumOperations(arr));
	}
}
