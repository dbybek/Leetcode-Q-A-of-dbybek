import java.util.*;

//1.Two Sum (Easy)
//----------------
//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//You can return the answer in any order.
//
//Constraints:
//-----------
//2 <= nums.length <= 10^4
//-10^9 <= nums[i] <= 10^9
//-10^9 <= target <= 10^9
//Only one valid answer exists.

public class TwoSum 
{
	public int[] twoSum(int[] nums, int target) 
	{
        int[] res = new int[2];
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(target-nums[i])){
                res[1] = i;
                res[0] = hm.get(target-nums[i]);
                return res;
            }
            hm.put(nums[i],i);
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
		int T = sc.nextInt();
		sc.close();
		TwoSum Res = new TwoSum();
		System.out.print(Res.twoSum(arr, T));
	}

}
