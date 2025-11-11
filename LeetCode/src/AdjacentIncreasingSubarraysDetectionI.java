import java.util.*;

//3349. Adjacent Increasing Subarrays Detection I (Easy)
//------------------------------------------------------
//Given an array nums of n integers and an integer k,
//determine whether there exist two adjacent subarrays of length k such that both subarrays are strictly increasing.
//Specifically, check if there are two subarrays starting at indices a and b (a < b), where:
//Both subarrays nums[a..a + k - 1] and nums[b..b + k - 1] are strictly increasing.
//The subarrays must be adjacent, meaning b = a + k.
//Return true if it is possible to find two such subarrays, and false otherwise.
//
//Constraints:
//-----------
//2 <= nums.length <= 100
//1 < 2 * k <= nums.length
//-1000 <= nums[i] <= 1000

public class AdjacentIncreasingSubarraysDetectionI 
{
	public boolean hasIncreasingSubarrays(List<Integer> nums, int k)
	{
		int n=nums.size(),count=1,prev=0;
        for(int i=1;i<n;i++){
            if(nums.get(i-1)<nums.get(i)){
                count++;
            }
            else{
                prev = count;
                count = 1;
            }
            if(count/2>=k || prev/2>=k || Math.min(prev,count)>=k){
                return true;
            }
        }
        return false;
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
		int k = sc.nextInt();
		sc.close();
		AdjacentIncreasingSubarraysDetectionI Res = new AdjacentIncreasingSubarraysDetectionI();
		System.out.print(Res.hasIncreasingSubarrays(lst, k));
	}
}
