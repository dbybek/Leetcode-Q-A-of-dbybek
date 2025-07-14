import java.util.*;

//2200. Find All K-Distant Indices in an Array (Easy)
//---------------------------------------------------
//You are given a 0-indexed integer array nums and two integers key and k.
//A k-distant index is an index i of nums for which there exists at least one index j such that |i - j| <= k and
//nums[j] == key.
//Return a list of all k-distant indices sorted in increasing order.
//
//Constraints:
//-----------
//1 <= nums.length <= 1000
//1 <= nums[i] <= 1000
//key is an integer from the array nums.
//1 <= k <= nums.length

public class FindAllKDistantIndicesInAnArray 
{
	public List<Integer> findKDistantIndices(int[] nums, int key, int k)
	{
//		Approach I: Check the condition of key beign present in the range of (0,i-k) to (n,i+k).
//		----------------------------------------------------------------------------------------
		int n = nums.length;
		int[] diff = new int[n+1];
		for(int i=0;i<n;i++) {
			if(nums[i] == key) {
				int left = Math.max(0, i-k);
				int right = Math.min(n, i+k+1);
				diff[left]++;
				if(right < n) {
					diff[right]--;
				}
			}
		}
		List<Integer> res = new ArrayList<>();
		int sum = 0;
		for(int i=0;i<n;i++) {
			sum += diff[i];
			if(sum>0) {
				res.add(i);
			}
		}
		return res;
		
//		Approach II: Using priority queue
//		---------------------------------
//		int n = nums.length;
//		Queue<Integer> pq = new PriorityQueue<>();
//		for(int i=0;i<n;i++) {
//			if(nums[i]==key) {
//				pq.offer(i);
//			}
//		}
//		List<Integer> res = new ArrayList<>();
//		for(int i=0;i<n;i++) {
//			while(!pq.isEmpty() && i-pq.peek() > k) {
//				pq.poll();
//			}
//			if(!pq.isEmpty() && Math.abs(pq.peek()-i) <= k) {
//				res.add(i);
//			}
//		}
//		return res;
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
		int KEY = sc.nextInt(), K = sc.nextInt();
		sc.close();
		FindAllKDistantIndicesInAnArray Res = new FindAllKDistantIndicesInAnArray();
		System.out.print(Res.findKDistantIndices(arr, KEY, K));
	}

}
