import java.util.Scanner;

//2996. Smallest Missing Integer Greater Than Sequential Prefix Sum (Easy)
//------------------------------------------------------------------------
//You are given a 0-indexed array of integers nums.
//A prefix nums[0..i] is sequential if, for all 1 <= j <= i, nums[j] = nums[j - 1] + 1.
//In particular, the prefix consisting only of nums[0] is sequential.
//Return the smallest integer x missing from nums such that x is greater than or equal to the
//sum of the longest sequential prefix.
//
//Constraints:
//-----------
//1 <= nums.length <= 50
//1 <= nums[i] <= 50

public class SmallestMissingIntegerGreaterThanSequentialPrefixSum 
{
	public int missingInteger(int[] nums)
	{
		int sum = nums[0];
        int[] freq = new int[52];
        freq[nums[0]]++;
        boolean prefSeq = true;
        for(int i=1;i<nums.length;i++){
            if(prefSeq && nums[i]==nums[i-1]+1){
                sum+=nums[i];
            }
            else{
                prefSeq = false;
                if(sum>50){
                    return sum;
                }
            }
            freq[nums[i]]++;
        }

        for(int i=sum;i<52;i++){
            if(freq[i]==0){
                return i;
            }
        }
        return sum;
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
		SmallestMissingIntegerGreaterThanSequentialPrefixSum Res = new SmallestMissingIntegerGreaterThanSequentialPrefixSum();
		System.out.print(Res.missingInteger(arr));
	}
}
