import java.util.Scanner;

//1653. Minimum Deletions to Make String Balanced (Medium)
//--------------------------------------------------------
//You are given a string s consisting only of characters 'a' and 'b'​​​​.
//You can delete any number of characters in s to make s balanced.
//s is balanced if there is no pair of indices (i,j) such that i < j and s[i] = 'b' and s[j]= 'a'.
//
//Return the minimum number of deletions needed to make s balanced.
//
//Constraints:
//-----------
//1 <= s.length <= 10^5
//s[i] is 'a' or 'b'​​.

public class MinimumDeletionsToMakeStringBalanced 
{
	public int minimumDeletions(String s) 
	{
        int res = 0, bCount = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='b'){
                bCount++;
            }
            else if(bCount>0){
                res++;
                bCount--;
            }
        }
        return res;
    }
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();
		MinimumDeletionsToMakeStringBalanced Res = new MinimumDeletionsToMakeStringBalanced();
		System.out.print(Res.minimumDeletions(str));
	}
}
