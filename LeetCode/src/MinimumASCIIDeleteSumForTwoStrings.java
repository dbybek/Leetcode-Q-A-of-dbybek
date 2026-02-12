import java.util.Scanner;

//712. Minimum ASCII Delete Sum for Two Strings(Medium)
//-----------------------------------------------------
//Given two strings s1 and s2, return the lowest ASCII sum of deleted characters to make two strings equal.
//
//Constraints:
//-----------
//1 <= s1.length, s2.length <= 1000
//s1 and s2 consist of lowercase English letters.

public class MinimumASCIIDeleteSumForTwoStrings 
{
	public int minimumDeleteSum(String s1, String s2)
	{
//		Approach I: Take a dp of size m+1*n+1 and save the minimum delete ascii sum value. TC: O(m*n) SC: O(m*n)
//		--------------------------------------------------------------------------------------------------------
//		int m = s1.length() , n = s2.length();
//        int[][] dp = new int[m+1][n+1];
//
//        for(int i=1;i<=m;i++){
//            dp[i][0] = dp[i-1][0] + s1.charAt(i-1);
//        }
//
//        for (int j = 1; j <= n; j++) {
//            dp[0][j] = dp[0][j - 1] + (int) s2.charAt(j - 1);
//        }
//
//        for (int i = 1; i <= m; i++) {
//            for (int j = 1; j <= n; j++) {
//                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
//                    dp[i][j] = dp[i - 1][j - 1];
//                } else {
//                    dp[i][j] = Math.min(
//                        dp[i - 1][j] + (int) s1.charAt(i - 1),
//                        dp[i][j - 1] + (int) s2.charAt(j - 1)
//                    );
//                }
//            }
//        }
//
//        return dp[m][n];
        
//		Approach II: Same as above but with space optimization. TC: O(m*n) SC: O(n)
//		---------------------------------------------------------------------------
        int m = s1.length(), n = s2.length();
        int[] dp = new int[n + 1];
        
        for (int j = 1; j <= n; j++) {
            dp[j] = dp[j - 1] + s2.charAt(j - 1);
        }

        for (int i = 1; i <= m; i++) {
            int prev = dp[0]; 
            dp[0] += (int) s1.charAt(i - 1);
            
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[j] = prev;
                } 
                else {
                    dp[j] = Math.min(dp[j] + s1.charAt(i - 1), dp[j - 1] + s2.charAt(j - 1));
                }
                prev = temp;
            }
        }

        return dp[n];
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine(), str2 = sc.next();
		sc.close();
		MinimumASCIIDeleteSumForTwoStrings Res = new MinimumASCIIDeleteSumForTwoStrings();
		System.out.print(Res.minimumDeleteSum(str1, str2));
	}
}
