import java.util.Scanner;

//944. Delete Columns to Make Sorted(Easy)
//----------------------------------------
//You are given an array of n strings strs, all of the same length.
//The strings can be arranged such that there is one on each line, making a grid.
//
//For example, strs = ["abc", "bce", "cae"] can be arranged as follows:
//abc
//bce
//cae
//You want to delete the columns that are not sorted lexicographically.
//In the above example (0-indexed), columns 0 ('a', 'b', 'c') and 2 ('c', 'e', 'e') are sorted,
//while column 1 ('b', 'c', 'a') is not, so you would delete column 1.
//
//Return the number of columns that you will delete.
//
//Constraints:
//-----------
//n == strs.length
//1 <= n <= 100
//1 <= strs[i].length <= 1000
//strs[i] consists of lowercase English letters.

public class DeleteColumnsToMakeSorted 
{
	public int minDeletionSize(String[] strs)
	{
		int res = 0, n = strs[0].length(), m = strs.length;
        for(int i=0;i<n;i++){
            for(int j=1;j<m;j++){
                if(strs[j].charAt(i) < strs[j-1].charAt(i)){
                    res++;
                    break;
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
		DeleteColumnsToMakeSorted Res = new DeleteColumnsToMakeSorted();
		System.out.print(Res.minDeletionSize(arr));
	}
}
