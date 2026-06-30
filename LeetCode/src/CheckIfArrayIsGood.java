import java.util.Scanner;

//2784. Check if Array is Good (Easy)
//-----------------------------------
//You are given an integer array nums. We consider an array good if it is a permutation of an array base[n].
//base[n] = [1, 2, ..., n - 1, n, n] (in other words, it is an array of length n + 1 which contains 1 to n - 1 exactly once,
//plus two occurrences of n). For example, base[1] = [1, 1] and base[3] = [1, 2, 3, 3].
//Return true if the given array is good, otherwise return false.
//Note: A permutation of integers represents an arrangement of these numbers.
//Constraints:
//-----------
//1 <= nums.length <= 100
//1 <= num[i] <= 200

public class CheckIfArrayIsGood 
{
	public boolean isGood(int[] nums)
	{
		// int mx = 0;
        // int[] freq = new int[201];
        // for(int ele:nums){
        //     freq[ele]++;
        //     mx = Math.max(mx,ele);
        // }
        // if(freq[mx]!=2){
        //     return false;
        // }
        // for(int i=1;i<mx;i++){
        //     if(freq[i]!=1){
        //         return false;
        //     }
        // }
        // return true;
        int n = nums.length;
        int[] freq = new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]>=n){
                return false;
            }
            freq[nums[i]]++;
        }
        for(int i=1;i<n-1;i++){
            if(freq[i]!=1){
                return false;
            }
        }
        return freq[n-1]==2;
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
		CheckIfArrayIsGood Res = new CheckIfArrayIsGood();
		System.out.print(Res.isGood(arr));
	}
}
