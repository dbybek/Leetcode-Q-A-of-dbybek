import java.util.Scanner;

//2141. Maximum Running Time of N Computers (Hard)
//------------------------------------------------
//You have n computers. You are given the integer n and a 0-indexed integer array batteries
//where the ith battery can run a computer for batteries[i] minutes.
//You are interested in running all n computers simultaneously using the given batteries.
//Initially, you can insert at most one battery into each computer.
//After that and at any integer time moment, you can remove a battery from a computer and
//insert another battery any number of times.
//The inserted battery can be a totally new battery or a battery from another computer.
//You may assume that the removing and inserting processes take no time.
//
//Note that the batteries cannot be recharged.
//
//Return the maximum number of minutes you can run all the n computers simultaneously.
//
//Constraints:
//-----------
//1 <= n <= batteries.length <= 10^5
//1 <= batteries[i] <= 10^9

public class MaximumRunningTimeOfNComputers 
{
	public long maxRunTime(int n, int[] batteries)
	{
		long left = 0, right = 100000000000000L;
		while(left<right) {
			long mid = (left+right+1)/2, sum = 0;
			for(int ele:batteries) {
				sum += Math.min(mid, ele);
			}
			if(sum/n < mid) {
				right = mid-1;
			}
			else {
				left = mid;
			}
		}
		return left;
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
		MaximumRunningTimeOfNComputers Res = new MaximumRunningTimeOfNComputers();
		System.out.print(Res.maxRunTime(k, arr));
	}
}
