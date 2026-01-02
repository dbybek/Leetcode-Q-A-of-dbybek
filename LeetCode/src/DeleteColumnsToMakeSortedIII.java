import java.util.Arrays;
import java.util.Scanner;

//960. Delete Columns to Make Sorted III(Hard)
//--------------------------------------------
//You are given an array of n strings strs, all of the same length.
//We may choose any deletion indices, and we delete all the characters in those indices for each string.
//For example, if we have strs = ["abcdef","uvwxyz"] and deletion indices {0, 2, 3},
//then the final array after deletions is ["bef", "vyz"].
//Suppose we chose a set of deletion indices answer such that after deletions,
//the final array has every string (row) in lexicographic order. (i.e.,
//(strs[0][0] <= strs[0][1] <= ... <= strs[0][strs[0].length - 1]), and 
//(strs[1][0] <= strs[1][1] <= ... <= strs[1][strs[1].length - 1]), and so on).
//Return the minimum possible value of answer.length.
//
//Constraints:
//-----------
//n == strs.length
//1 <= n <= 100
//1 <= strs[i].length <= 100
//strs[i] consists of lowercase English letters.

public class DeleteColumnsToMakeSortedIII 
{
	public int minDeletionSize(String[] strs)
	{
		int res = 0, n = strs[0].length(), len = strs.length;
		boolean[] delCol = new boolean[len];
		Arrays.fill(delCol, true);
		for(int i=0;i<len;i++) {
			for(int j=1;j<n;j++) {
				if(delCol[j] && strs[i].charAt(j) < strs[i].charAt(j-1)) {
					delCol[j] = false;
					res++;
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] arr = new String[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextLine();
		}
		sc.close();
		DeleteColumnsToMakeSortedIII Res = new DeleteColumnsToMakeSortedIII();
		System.out.print(Res.minDeletionSize(arr));
	}
}
