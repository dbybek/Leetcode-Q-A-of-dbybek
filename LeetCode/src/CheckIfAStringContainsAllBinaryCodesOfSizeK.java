import java.util.*;

//1461. Check If a String Contains All Binary Codes of Size K (Medium)
//--------------------------------------------------------------------
//Given a binary string s and an integer k,
//return true if every binary code of length k is a substring of s. Otherwise, return false.
//
//Constraints:
//-----------
//1 <= s.length <= 5 * 10^5
//s[i] is either '0' or '1'.
//1 <= k <= 20

public class CheckIfAStringContainsAllBinaryCodesOfSizeK 
{
	public boolean hasAllCodes(String s, int k)
	{
//		Approach I: Using hashset to save all the possible k length sub strings from s. 
//		            Then match hashset size with count of possible binary codes of length k (i.e 2^k).
//		----------------------------------------------------------------------------------------------
//		            
//		HashSet<String> hs = new HashSet<>();
//        StringBuilder sb = new StringBuilder();
//        for(int i=0;i<s.length();i++){
//            sb.append(s.charAt(i));
//            if(sb.length()==k){
//                hs.add(sb.toString());
//                sb.deleteCharAt(0);
//                if(hs.size()==(1<<k)) {
//                	return true;
//                }
//            }
//        }
//        return false;
//		
//		Approach II: Using a boolean array of size 2^k-1 instead of a hashset for better space complexity and
//		             checking the count at each new substring found to get a better time complexity.
//		------------------------------------------------------------------------------------------------------
		int subStrCount = 1<<k;
        boolean[] subStr = new boolean[subStrCount];
        int hs = 0, allOne = subStrCount-1, count = 0;
        for(int i=0;i<s.length();i++){
            hs = ((hs<<1) & allOne | (s.charAt(i)-'0'));
            if(i>=k-1){
                if(!subStr[hs]){
                    subStr[hs] = true;
                    count++;
                    if(count==subStrCount){
                        return true;
                    }
                }
            }
        }
        return false;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		int k = sc.nextInt();
		sc.close();
		CheckIfAStringContainsAllBinaryCodesOfSizeK Res = new CheckIfAStringContainsAllBinaryCodesOfSizeK();
		System.out.print(Res.hasAllCodes(N, k));
	}
}
