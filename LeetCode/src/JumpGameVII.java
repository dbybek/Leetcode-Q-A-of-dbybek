import java.util.Scanner;

//1871. Jump Game VII (Medium)
//----------------------------
//You are given a 0-indexed binary string s and two integers minJump and maxJump.
//In the beginning, you are standing at index 0, which is equal to '0'.
//You can move from index i to index j if the following conditions are fulfilled:
//i + minJump <= j <= min(i + maxJump, s.length - 1), and
//s[j] == '0'.
//Return true if you can reach index s.length - 1 in s, or false otherwise.
//Constraints:
//-----------
//2 <= s.length <= 10^5
//s[i] is either '0' or '1'.
//s[0] == '0'
//1 <= minJump <= maxJump < s.length

public class JumpGameVII 
{
	public boolean canReach(String s, int minJump, int maxJump)
	{
		int n = s.length();
        if(s.charAt(n-1)=='1'){
            return false;
        }
        boolean[] dp = new boolean[n];
        dp[0] = true;
        int possible = 0;
        for(int i=1;i<n;i++){
            if(i>=minJump && dp[i-minJump]){
                possible++;
            }
            if(i>maxJump && dp[i-maxJump-1]){
                possible--;
            }
            if(possible>0 && s.charAt(i)=='0'){
                dp[i] = true;
            }
        }
        return dp[n-1];
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		int mnj = sc.nextInt(), mxj = sc.nextInt();
		sc.close();
		JumpGameVII Res = new JumpGameVII();
		System.out.print(Res.canReach(N, mnj, mxj));
	}
}
