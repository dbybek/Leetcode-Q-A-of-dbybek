import java.util.Scanner;

//1061. Lexicographically Smallest Equivalent String (Medium)
//-----------------------------------------------------------
//You are given two strings of the same length s1 and s2 and a string baseStr.
//
//We say s1[i] and s2[i] are equivalent characters.
//
//For example, if s1 = "abc" and s2 = "cde", then we have 'a' == 'c', 'b' == 'd', and 'c' == 'e'.
//Equivalent characters follow the usual rules of any equivalence relation:
//
//Reflexivity: 'a' == 'a'.
//Symmetry: 'a' == 'b' implies 'b' == 'a'.
//Transitivity: 'a' == 'b' and 'b' == 'c' implies 'a' == 'c'.
//For example, given the equivalency information from s1 = "abc" and s2 = "cde",
//"acd" and "aab" are equivalent strings of baseStr = "eed", and "aab" is the 
//lexicographically smallest equivalent string of baseStr.
//
//Return the lexicographically smallest equivalent string of baseStr by using the equivalency information from s1 and s2.
//
//Constraints:
//-----------
//1 <= s1.length, s2.length, baseStr <= 1000
//s1.length == s2.length
//s1, s2, and baseStr consist of lowercase English letters.

public class LexicographicallySmallestEquivalentString 
{

	int[] matchesArray;
	public int find(int val)
    {
        if(matchesArray[val]!=val)
        {
        	matchesArray[val]=find(matchesArray[val]);
            
        }
        return matchesArray[val];
    }
	
	
//	public int find(char x, int[] root) 
//	{
//		while(root[x-'a'] != x-'a') 
//		{
// 		   x = (char)(root[x-'a']+'a');
// 	    }
//        return root[x-'a'];
//    }
	
	public String smallestEquivalentString(String s1, String s2, String baseStr) 
	{
//	Approach I: Taking more time when submmitting in leetcode. Need to check the reason.
//	------------------------------------------------------------------------------------
//       StringBuffer res = new StringBuffer();
//       int[] matchesArray = new int[26];
//       for(int i=0;i<26;i++) {
//    	   matchesArray[i] = i;
//       }
//       int n = s1.length();
//       for(int i=0;i<n;i++) {
//    	   char mn, mx;
//    	   if(s1.charAt(i)<s2.charAt(i)) {
//    		   mn = s1.charAt(i);
//    		   mx = s2.charAt(i);
//    	   }
//    	   else {
//    		   mn = s2.charAt(i);
//    		   mx = s1.charAt(i);
//    	   }
//    	   
//    	   mx = (char)(find(mx,matchesArray)+'a');
//    	   mn = (char)(find(mn,matchesArray)+'a');
//    	   
//    	   if(mx!=mn) {
//    		   if(mx < mn) {
//    			   matchesArray[mn-'a'] = mx-'a';
//    		   }
//    		   else {
//    			   matchesArray[mx-'a'] = mn-'a';
//    		   }
//    	   }
//       }
//       for(int i=0;i<26;i++) {
//    	   System.out.println((char)(i+'a')+" = "+matchesArray[i]);
//       }
//       n = baseStr.length();
//       for(int i=0;i<n;i++) {
//    	   char temp = baseStr.charAt(i);
//    	   res.append((char)(find(temp,matchesArray)+'a'));
//       }
//       return res.toString();
//	
//	Appraoch II: Took from leetcode. Need to check why taking less time.
//	--------------------------------------------------------------------
		int n = s1.length();
		matchesArray = new int[26];
        for(int i=0;i<26;i++)
        {
        	matchesArray[i] = i;
        }
		for(int i=0;i<n;i++) {
			int roots1 = find(s1.charAt(i)-'a'), roots2 = find(s2.charAt(i)-'a');
			if(roots1 < roots2) {
				matchesArray[roots2] = roots1;
			}
			else {
				matchesArray[roots1] = roots2;
			}
		}
		StringBuilder res = new StringBuilder();
		n = baseStr.length();
		for(int i=0;i<n;i++) {
			char temp = baseStr.charAt(i);
			res.append((char)(find(temp-'a')+'a'));
		}
		return res.toString();
    }
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine(), str1 = sc.nextLine(), str3 = sc.nextLine();
		sc.close();
		LexicographicallySmallestEquivalentString Res = new LexicographicallySmallestEquivalentString();
		System.out.print(Res.smallestEquivalentString(str, str1, str3));
	}

}