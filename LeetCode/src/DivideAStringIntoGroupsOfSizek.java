import java.util.Scanner;

//2138. Divide a String Into Groups of Size k (Easy)
//--------------------------------------------------
//A string s can be partitioned into groups of size k using the following procedure:
//
//The first group consists of the first k characters of the string,
//the second group consists of the next k characters of the string, and so on.
//Each element can be a part of exactly one group.
//For the last group, if the string does not have k characters remaining, a character fill is used to complete the group.
//Note that the partition is done so that after removing the fill character from the last group (if it exists) 
//and concatenating all the groups in order, the resultant string should be s.
//
//Given the string s, the size of each group k and the character fill,
//return a string array denoting the composition of every group s has been divided into, using the above procedure.
//
//Constraints:
//-----------
//1 <= s.length <= 100
//s consists of lowercase English letters only.
//1 <= k <= 100
//fill is a lowercase English letter.

public class DivideAStringIntoGroupsOfSizek 
{
	public String[] divideString(String s, int k, char fill)
	{
		int len = s.length(), i = 0, j = 0;
		int n = len%k==0?len/k:len/k + 1;
		String[] res = new String[n];
		while(i<n && j<len-k+1) {
			res[i] = s.substring(j, j+k);
			j+=k;
			i++;
		}
		if(res[n-1]==null) {
			StringBuilder sb = new StringBuilder();
			sb.append(s.substring(j));
			while(sb.length()<k) {
				sb.append(fill);
			}
			res[n-1] = sb.toString();
		}
		return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int K = sc.nextInt();
		char ch = sc.next().charAt(0);
		sc.close();
		DivideAStringIntoGroupsOfSizek Res = new DivideAStringIntoGroupsOfSizek();
		String[] arr = Res.divideString(str, K, ch);
		for(String st:arr) {
			System.out.print(st+" ");
		}
	}

}
