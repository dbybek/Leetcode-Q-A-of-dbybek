import java.util.Scanner;

//440. K-th Smallest in Lexicographical Order (Hard)
//--------------------------------------------------
//Given two integers n and k, return the kth lexicographically smallest integer in the range [1, n]. 
//
//Constraints:
//-----------
//1 <= k <= n <= 10^9

public class K_ThSmallestInLexicographicalOrder 
{
//	Approach I: DFS method.
//	-----------------------
//	int cnt = 0;
//	public void dfs(int j, int N, List<Integer> res,int K) 
//	{
//		if(j>N || cnt==K) {
//			return;
//		}
//		res.add(j);
//		cnt++;
//		for(int l=0;l<10;l++) {
//			int nxt = (j * 10) + l;
//			if(nxt > N || cnt == K) return;
//			dfs(nxt,N,res,K);
//		}
//	}
	
	public int findKthNumber(int n, int k) 
	{
//		Approach I: Using DFS and saving the values to a List. But this approach gives us memory limit exceeded 
//		            as the constraints are limited till 10^9. 
//		-------------------------------------------------------------------------------------------------------
//		List<Integer> res = new ArrayList<>();
//        for(int i=1;i<10;i++) {
//        	if(cnt != k) {
//        		dfs(i,n,res,k);
//        	}
//        	else {
//        		break;
//        	}
//        }
//        return res.get(res.size()-1);
		
//		Approach II: Traverse for each prefix starting from 1 to 9, while taking a count of how many numbers with
//		             take selected prefix fall in the range [1,N] and adjust the 'k' value accordingly.
//		---------------------------------------------------------------------------------------------------------
		long res = 1;
		k--;
		while(k>0) {
			long cnt = countNumbers(n,res,res+1);
			if(cnt<=k) {
				res++;
				k -= cnt;
			}
			else {
				res *= 10;
				k--;
			}
		}
		return (int)res;
	}
	
	private long countNumbers(long N,long curr,long nxt) 
	{
		long cntOfNums = 0;
		while(curr <= N) {
			cntOfNums += Math.min(N+1, nxt) - curr;
			curr *= 10;
			nxt *= 10;
		}
		return cntOfNums;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		sc.close();
		K_ThSmallestInLexicographicalOrder Res = new K_ThSmallestInLexicographicalOrder();
		System.out.print(Res.findKthNumber(N, K));
	}

}
