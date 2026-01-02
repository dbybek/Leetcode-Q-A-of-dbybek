import java.util.Scanner;

//955. Delete Columns to Make Sorted II(Medium)
//---------------------------------------------
//You are given an array of n strings strs, all of the same length.
//We may choose any deletion indices, and we delete all the characters in those indices for each string.
//For example, if we have strs = ["abcdef","uvwxyz"] and deletion indices {0, 2, 3},
//then the final array after deletions is ["bef", "vyz"].
//Suppose we chose a set of deletion indices answer such that after deletions,
//the final array has its elements in lexicographic order (i.e., strs[0] <= strs[1] <= strs[2] <= ... <= strs[n - 1]).
//Return the minimum possible value of answer.length.
//
//Constraints:
//-----------
//n == strs.length
//1 <= n <= 100
//1 <= strs[i].length <= 100
//strs[i] consists of lowercase English letters.

public class DeleteColumnsToMakeSortedII 
{
	public int minDeletionSize(String[] strs)
	{
		int res = 0, n = strs.length, l = strs[0].length();
        boolean[] delCheck = new boolean[n];
        for (int i=1;i<n;i++){
            delCheck[i] = true;
        }
        for (int j=0;j<l;j++)
        {
            boolean flag=false;
            for (int i=1;i<n;i++){
                if (delCheck[i]){
                    if (strs[i].charAt(j)<strs[i-1].charAt(j)){
                        flag=true;
                        break;
                    }
                }
            }
            if (flag) {
                res++;
                continue;
            }
            for (int i=1;i<n;i++){
                if (delCheck[i]){
                    if (strs[i].charAt(j)>strs[i-1].charAt(j)) {
                        delCheck[i]=false;
                    }
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
		DeleteColumnsToMakeSortedII Res = new DeleteColumnsToMakeSortedII();
		System.out.print(Res.minDeletionSize(arr));
	}
}
