import java.util.*;

//3719. Longest Balanced Subarray I (Medium)
//------------------------------------------
//You are given an integer array nums.
//A subarray is called balanced if the number of distinct even numbers in the subarray is equal to the
//number of distinct odd numbers.
//
//Return the length of the longest balanced subarray.
//
//Constraints:
//-----------
//1 <= nums.length <= 1500
//1 <= nums[i] <= 10^5

public class LongestBalancedSubarrayI 
{
	public int longestBalanced(int[] nums) 
	{
        int n = nums.length, res = 0;
        for(int i=0;i<n && n-i>res;i++){
            int e = 0, o = 0;
            HashSet<Integer> hs = new HashSet<>();
            for(int j=i;j<n;j++){
                if(!hs.contains(nums[j])){
                    hs.add(nums[j]);
                    if((nums[j]&1)==0){
                        e++;
                    }
                    else{
                        o++;
                    }
                }
                if(e==o){
                    res = Math.max(res,j-i+1);
                }
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
		LongestBalancedSubarrayI Res = new LongestBalancedSubarrayI();
		System.out.print(Res.longestBalanced(arr));
	}
}
