import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//3314. Construct the Minimum Bitwise Array II(Medium)
//----------------------------------------------------
//You are given an array nums consisting of n prime integers.
//You need to construct an array ans of length n, such that,
//for each index i, the bitwise OR of ans[i] and ans[i] + 1 is equal to nums[i], i.e. ans[i] OR (ans[i] + 1) == nums[i].
//
//Additionally, you must minimize each value of ans[i] in the resulting array.
//If it is not possible to find such a value for ans[i] that satisfies the condition, then set ans[i] = -1.
//
//Constraints:
//-----------
//1 <= nums.length <= 100
//2 <= nums[i] <= 10^9
//nums[i] is a prime number.

public class ConstructTheMinimumBitwiseArrayII 
{
	public int[] minBitwiseArray(List<Integer> nums)
	{
		int[] res = new int[nums.size()];
        for(int i=0;i<nums.size();i++){
            int ele = nums.get(i);
            if(ele==2){
                res[i] = -1;
            }
            else{
                long temp = (long)ele+1, lowBit = temp&-temp;
                res[i] = ele - (int)(lowBit/2);
            }
        }
        return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Integer> lst = new ArrayList<>();
		for(int i=0;i<N;i++) {
			lst.add(sc.nextInt());
		}
		sc.close();
		ConstructTheMinimumBitwiseArrayII Res = new ConstructTheMinimumBitwiseArrayII();
		int[] arr = Res.minBitwiseArray(lst);
		for(int ele:arr) {
			System.out.print(ele+" ");
		}
	}
}
