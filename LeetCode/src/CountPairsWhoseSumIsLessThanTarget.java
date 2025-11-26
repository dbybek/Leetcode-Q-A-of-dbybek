import java.util.*;

//2824. Count Pairs Whose Sum is Less than Target (Easy)
//------------------------------------------------------
//Given a 0-indexed integer array nums of length n and an integer target,
//return the number of pairs (i, j) where 0 <= i < j < n and nums[i] + nums[j] < target.
//
//Constraints:
//-----------
//1 <= nums.length == n <= 50
//-50 <= nums[i], target <= 50

public class CountPairsWhoseSumIsLessThanTarget 
{
	public int countPairs(List<Integer> nums, int target)
	{
		int res = 0, n = nums.size();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums.get(i)+nums.get(j)<target){
                    res++;
                }
            }
        }
        return res;
        // Collections.sort(nums);
        // int res = 0, start = 0, end = nums.size()-1;
        // while(start<end){
        //     if(nums.get(start)+nums.get(end)<target){
        //         res+=end-start;
        //         start++;
        //     }
        //     else{
        //         end--;
        //     }
        // }
        // return res;
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
		CountPairsWhoseSumIsLessThanTarget Res = new CountPairsWhoseSumIsLessThanTarget();
		System.out.print(Res.countPairs(lst, N));
	}
}
