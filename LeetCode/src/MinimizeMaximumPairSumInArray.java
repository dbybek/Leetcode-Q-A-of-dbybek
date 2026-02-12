import java.util.Scanner;

//1877. Minimize Maximum Pair Sum in Array (Medium)
//-------------------------------------------------
//The pair sum of a pair (a,b) is equal to a + b. The maximum pair sum is the largest pair sum in a list of pairs.
//For example,
//if we have pairs (1,5), (2,3), and (4,4), the maximum pair sum would be max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8.
//Given an array nums of even length n, pair up the elements of nums into n / 2 pairs such that:
//
//Each element of nums is in exactly one pair, and
//The maximum pair sum is minimized.
//Return the minimized maximum pair sum after optimally pairing up the elements.
//
//Constraints:
//-----------
//n == nums.length
//2 <= n <= 10^5
//n is even.
//1 <= nums[i] <= 10^5

public class MinimizeMaximumPairSumInArray 
{
	public int minPairSum(int[] nums)
	{
		int mx = 0, mn = 1000001;
        for(int i=0;i<nums.length;i++){
            mx = Math.max(nums[i],mx);
            mn = Math.min(nums[i],mn);
        }
        int[] freq = new int[mx+1];
        for(int i=0;i<nums.length;i++){
            freq[nums[i]]++;
        }
        int l = mn, r = mx, res = 0;
        while(l<r){
            while(freq[l]==0){
                l++;
            }
            while(freq[r]==0){
                r--;
            }
            res = Math.max(res, l+r);
            if(freq[l]>freq[r]){
                freq[l]-=freq[r];
                r--;
            }
            else if(freq[r]>freq[l]){
                freq[r]-=freq[l];
                l++;
            }
            else{
                l++;
                r--;
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
		MinimizeMaximumPairSumInArray Res = new MinimizeMaximumPairSumInArray();
		System.out.print(Res.minPairSum(arr));
	}
}
