import java.util.Scanner;

//2928. Distribute Candies Among Children I (Easy)
//------------------------------------------------
//You are given two positive integers n and limit.
//Return the total number of ways to distribute n candies among 3 children such that no child gets more than limit candies..
//
//Constraints:
//-----------
//1 <= n <= 50
//1 <= limit <= 50

public class DistributeCandiesAmongChildrenI 
{
	public int distributeCandies(int n, int limit) 
	{
//		Approach I: Checking for each possible combination using a loop.
//		---------------------------------------------------------------
//		if(limit*3 < n) {
//			return 0;
//		}
//		if(limit*3 == n) {
//			return 1;
//		}
//		
//		int res = 0;
//		for(int i=Math.min(limit, n);i>=0;i--) {
//			int c1 = n-i;
//			if(c1 > limit*2) {
//				continue;
//			}
//			int c2 = Math.min(limit,c1);
//			int c3 = Math.max(0, c1-c2);
//			res += c2-c3+1;
//		}
//		return res;
		
//		Approach II: Using combinatrics formula of Inclusion-Exclusion Principle -> "∣A∪B∪C∣=∣A∣+∣B∣+∣C∣−(∣A∩B∣+∣B∩C∣+∣A∩C∣)+∣A∩B∩C∣"
//		---------------------------------------------------------------------------------------------------------------------
		if (3*limit<n) {
        	return 0;  // Impossible to distribute
        }
		
        if (3*limit==n) {
        	return 1; // Only one way when exactly limit for all
        }
        
        int allCases = ((n+2)*(n+1))/2;  // Total unrestricted ways

        // Compute cases where at least one child gets more than limit candies
        int excludeOne = (n - (limit + 1) + 2);
        int oneLimit = (excludeOne > 1)? 3*((excludeOne*(excludeOne-1))/2):0;

        // Compute cases where at least two children get more than limit candies
        int excludeTwo = (n - 2 * (limit + 1) + 2);
        int twoLimit = (excludeTwo > 1) ? 3*((excludeTwo*(excludeTwo-1))/2):0;

        // Compute cases where all three children get more than limit candies
        int excludeThree = (n - 3 * (limit + 1) + 2);
        int threeLimit = (excludeThree > 1) ? ((excludeThree*(excludeThree-1))/2):0;

        // Apply Inclusion-Exclusion Principle
        return allCases - oneLimit + twoLimit - threeLimit;
    }
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		sc.close();
		DistributeCandiesAmongChildrenI Res = new DistributeCandiesAmongChildrenI();
		System.out.print(Res.distributeCandies(N, M));
	}

}
