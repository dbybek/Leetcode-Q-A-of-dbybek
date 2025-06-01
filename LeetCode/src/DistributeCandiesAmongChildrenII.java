import java.util.Scanner;

//2929. Distribute Candies Among Children II (Medium)
//---------------------------------------------------
//You are given two positive integers n and limit.
//Return the total number of ways to distribute n candies among 3 children such that no child gets more than limit candies.
//
//Constraints:
//-----------
//1 <= n <= 10^6
//1 <= limit <= 10^6

public class DistributeCandiesAmongChildrenII
{
	public long distributeCandies(int n, int limit) 
	{
		if (3*limit<n) {
        	return 0;
        }
        if (3*limit==n) {
        	return 1;
        }
        long res = 0;
		for(long i=Math.min(limit, n);i>=0;i--) {
			long c1 = (long)(n)-i;
			if(c1 > (long)(limit)*2L) {
				continue;
			}
			long c2 = Math.min((long)(limit),c1);
			long c3 = Math.max(0, c1-c2);
			res += c2-c3+1;
		}
		return res;
    }
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		sc.close();
		DistributeCandiesAmongChildrenII Res = new DistributeCandiesAmongChildrenII();
		System.out.print(Res.distributeCandies(N, M));
	}

}
