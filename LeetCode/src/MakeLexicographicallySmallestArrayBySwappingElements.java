import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

//2948. Make Lexicographically Smallest Array by Swapping Elements (Medium)
//-------------------------------------------------------------------------
//You are given a 0-indexed array of positive integers nums and a positive integer limit.
//In one operation, you can choose any two indices i and j and swap nums[i] and nums[j] if |nums[i] - nums[j]| <= limit.
//Return the lexicographically smallest array that can be obtained by performing the operation any number of times.
//An array a is lexicographically smaller than an array b if in the first position where a and b differ,
//array a has an element that is less than the corresponding element in b.
//For example, the array [2,10,3] is lexicographically smaller than the array [10,2,3]
//because they differ at index 0 and 2 < 10.
//
//Constraints:
//-----------
//1 <= nums.length <= 10^5
//1 <= nums[i] <= 10^9
//1 <= limit <= 10^9

public class MakeLexicographicallySmallestArrayBySwappingElements 
{
	public int[] lexicographicallySmallestArray(int[] nums, int limit)
	{
		int n = nums.length, grp = 0;
		int[] ncopy = nums.clone();
		Arrays.sort(ncopy);
		HashMap<Integer, Integer> group = new HashMap<>();
		HashMap<Integer, Integer> ind = new HashMap<>();
		group.put(ncopy[0], grp);
		ind.put(grp, 0);
		for(int i=1;i<n;i++) {
			if(ncopy[i]-ncopy[i-1] > limit) {
				grp++;
				ind.put(grp, i);
			}
			group.put(ncopy[i], grp);
		}
		int[] res = new int[n];
		for(int i=0;i<n;i++) {
			int curr = group.get(nums[i]), j = ind.get(curr);
			res[i] = ncopy[j];
			ind.put(curr, j+1);
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
		int k = sc.nextInt();
		sc.close();
		MakeLexicographicallySmallestArrayBySwappingElements Res = new MakeLexicographicallySmallestArrayBySwappingElements();
		int[] arr1 = Res.lexicographicallySmallestArray(arr, k);
		for(int i=0;i<N;i++) {
			System.out.print(arr1[i]+" ");
		}
	}
}
