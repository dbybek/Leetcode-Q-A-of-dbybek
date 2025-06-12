import java.util.*;

//386. Lexicographical Numbers (Medium)
//-------------------------------------
//Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.
//You must write an algorithm that runs in O(n) time and uses O(1) extra space. 
//
//Constraints:
//-----------
//1 <= n <= 5 * 10^4

public class LexicographicalNumbers 
{
	public void dfs(int j, int N, List<Integer> res) 
	{
		if(j>N) {
			return;
		}
		res.add(j);
		for(int k=0;k<10;k++) {
			int nxt = (j * 10) + k;
			if(nxt > N) return;
			dfs(nxt,N,res);
		}
	}
	
	public List<Integer> lexicalOrder(int n) 
	{
        List<Integer> res = new ArrayList<>();
        for(int i=1;i<10;i++) {
        	dfs(i,n,res);
        }
        return res;
    }
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		LexicographicalNumbers Res = new LexicographicalNumbers();
		System.out.print(Res.lexicalOrder(N));
	}

}
