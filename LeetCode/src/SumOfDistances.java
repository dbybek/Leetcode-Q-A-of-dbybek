import java.util.*;

//2615. Sum of Distances (Medium)
//-------------------------------
//You are given a 0-indexed integer array nums.
//There exists an array arr of length nums.length,
//where arr[i] is the sum of |i - j| over all j such that nums[j] == nums[i] and j != i.
//If there is no such j, set arr[i] to be 0.
//Return the array arr.
//
//Constraints:
//-----------
//1 <= nums.length <= 10^5
//0 <= nums[i] <= 10^9

public class SumOfDistances 
{
	public long[] distance(int[] nums)
	{
		int n = nums.length;
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for(int i=0;i<n;i++){
//            hm.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        	if(hm.containsKey(nums[i])) {
        		List<Integer> temp = hm.get(nums[i]);
        		temp.add(i);
        		hm.put(nums[i], new ArrayList<>(temp));
        	}
        	else {
        		List<Integer> temp = new ArrayList<>();
        		temp.add(i);
        		hm.put(nums[i], temp);
        	}
        }
        long[] res = new long[n];
        for(List<Integer> lst:hm.values()){
            int len = lst.size();
            long[] pref = new long[len];
            pref[0] = lst.get(0);
            for(int i=1;i<len;i++){
                pref[i] = pref[i-1]+lst.get(i);
            }
            for(int i=0;i<len;i++){
                long idx = lst.get(i), countL = i, countR = len-i-1;
                long leftSum = (i>0)?pref[i-1]:0, rightSum = pref[len-1]-pref[i];
                long left = idx*countL - leftSum, right = rightSum - idx*countR;
                res[(int)idx] = left+right;
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
		SumOfDistances Res = new SumOfDistances();
		long[] arr1 = Res.distance(arr);
		for(int i=0;i<N;i++) {
			System.out.print(arr1[i]+" ");
		}
	}
}
