import java.util.*;

//3211. Generate Binary Strings Without Adjacent Zeros (Medium)
//-------------------------------------------------------------
//You are given a positive integer n.
//A binary string x is valid if all substrings of x of length 2 contain at least one "1".
//Return all valid strings with length n, in any order.
//
//Constraints:
//-----------
//1 <= n <= 18

public class GenerateBinaryStringsWithoutAdjacentZeros 
{
	public List<String> validStrings(int n)
	{
		List<String> res = new ArrayList<>();
		nString(n,new StringBuilder(),res);
		return res;
	}
	
	private void nString(int len,StringBuilder sb,List<String> lst)
	{
		if(sb.length()==len) {
			lst.add(sb.toString());
			return;
		}
		sb.append('1');
		nString(len,sb,lst);
		sb.deleteCharAt(sb.length()-1);
		if(sb.length()==0 || sb.charAt(sb.length()-1)!='0') {
			sb.append('0');
			nString(len,sb,lst);
			sb.deleteCharAt(sb.length()-1);
		}
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		GenerateBinaryStringsWithoutAdjacentZeros Res = new GenerateBinaryStringsWithoutAdjacentZeros();
		System.out.print(Res.validStrings(N));
	}
}