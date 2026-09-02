import java.util.Scanner;

//3499. Maximize Active Section with Trade I (Medium)
//---------------------------------------------------
//You are given a binary string s of length n, where:
//'1' represents an active section.
//'0' represents an inactive section.
//You can perform at most one trade to maximize the number of active sections in s. In a trade, you:
//
//Convert a contiguous block of '1's that is surrounded by '0's to all '0's.
//Afterward, convert a contiguous block of '0's that is surrounded by '1's to all '1's.
//Return the maximum number of active sections in s after making the optimal trade.
//
//Note: Treat s as if it is augmented with a '1' at both ends, forming t = '1' + s + '1'.
//The augmented '1's do not contribute to the final count.
//
//Constraints:
//-----------
//1 <= n == s.length <= 10^5
//s[i] is either '0' or '1'

public class MaximizeActiveSectionWithTradeI 
{
	public int maxActiveSectionsAfterTrade(String s)
	{
//		int zeroBeforeOneCount = 0, oneCount = 0, zeroAfterOneCount = 0, res = 0;
//		for(int i=0;i<n;){
//			while(i<n && s.charAt(i)=='0') {
//				zeroBeforeOneCount++;
//				i++;
//			}
//			
//			while(i<n && s.charAt(i)=='1') {
//				oneCount++;
//				i++;
//			}
//			
//			while(i<n && s.charAt(i)=='0') {
//				zeroAfterOneCount++;
//				i++;
//			}
//			
//			if(zeroBeforeOneCount>0 && zeroAfterOneCount>0) {
//				res = Math.max(res, zeroBeforeOneCount+zeroAfterOneCount);
//			}
//			
//			zeroBeforeOneCount = zeroAfterOneCount;
//			zeroAfterOneCount = 0;
//		}
//		return res+oneCount;
		
		int currZeroCount = 0, oneCount = 0, zeroCount = 0, res = 0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='0') {
				currZeroCount++;
			}
			else {
				if(currZeroCount>0) {
					zeroCount = currZeroCount;
				}
				currZeroCount = 0;
				oneCount++;
			}
			res = Math.max(res, currZeroCount+zeroCount);
		}
		
		if(res==currZeroCount || res==zeroCount) {
			return oneCount;
		}
		return oneCount+res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		sc.close();
		MaximizeActiveSectionWithTradeI Res = new MaximizeActiveSectionWithTradeI();
		System.out.print(Res.maxActiveSectionsAfterTrade(N));
	}
}
