import java.util.Scanner;

//3653. XOR After Range Multiplication Queries I (Medium)
//-------------------------------------------------------
//You are given an integer array nums of length n and a 2D integer array queries of size q,
//where queries[i] = [li, ri, ki, vi].
//For each query, you must apply the following operations in order:
//
//Set idx = li.
//While idx <= ri:
//Update: nums[idx] = (nums[idx] * vi) % (10^9 + 7)
//Set idx += ki.
//Return the bitwise XOR of all elements in nums after processing all queries.
//
//Constraints:
//-----------
//1 <= n == nums.length <= 10^3
//1 <= nums[i] <= 10^9
//1 <= q == queries.length <= 10^3
//queries[i] = [li, ri, ki, vi]
//0 <= li <= ri < n
//1 <= ki <= n
//1 <= vi <= 10^5

public class XORAfterRangeMultiplicationQueriesI 
{
	public int xorAfterQueries(int[] nums, int[][] queries)
	{
		for(int query[]:queries){
            int idx=query[0];
            int end=query[1];
            int k=query[2];
            int v=query[3];
            for(;idx<=end;idx+=k){
                nums[idx] = (int)(((long)nums[idx] * v) % 1000000007);
            }
        }
        int res = 0;
        for(int ele:nums){
            res^=ele;
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
		int M = sc.nextInt();
		int[][] arr1 = new int[M][4];
		for(int i=0;i<M;i++) {
			arr1[i][0] = sc.nextInt();
			arr1[i][1] = sc.nextInt();
			arr1[i][2] = sc.nextInt();
			arr1[i][3] = sc.nextInt();
		}
		sc.close();
		XORAfterRangeMultiplicationQueriesI Res = new XORAfterRangeMultiplicationQueriesI();
		System.out.print(Res.xorAfterQueries(arr, arr1));
	}
}
