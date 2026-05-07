import java.util.*;

//3761. Minimum Absolute Distance Between Mirror Pairs (Medium)
//-------------------------------------------------------------
//You are given an integer array nums.
//A mirror pair is a pair of indices (i, j) such that:
//
//0 <= i < j < nums.length, and
//reverse(nums[i]) == nums[j], where reverse(x) denotes the integer formed by reversing the digits of x.
//Leading zeros are omitted after reversing, for example reverse(120) = 21.
//Return the minimum absolute distance between the indices of any mirror pair.
//The absolute distance between indices i and j is abs(i - j).
//
//If no mirror pair exists, return -1.
//
//Constraints:
//-----------
//1 <= nums.length <= 10^5
//1 <= nums[i] <= 10^9​​​​​​​

public class MinimumAbsoluteDistanceBetweenMirrorPairs 
{
	private int reversed(int N)
    {
        int rev = 0;
        while(N>0){
            rev *= 10;
            rev += N%10;
            N /= 10;
        }
        return rev;
    }
	
	public int minMirrorPairDistance(int[] nums) {
		int res = 100001;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                res = Math.min(res,i-hm.get(nums[i]));
            }
            hm.put(reversed(nums[i]),i);
        }
        return res==100001?-1:res;
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
		MinimumAbsoluteDistanceBetweenMirrorPairs Res = new MinimumAbsoluteDistanceBetweenMirrorPairs();
		System.out.print(Res.minMirrorPairDistance(arr));
	}
}
