import java.util.*;

//118. Pascal's Triangle (Easy)
//-----------------------------
//Given an integer numRows, return the first numRows of Pascal's triangle.
//
//Constraints:
//-----------
//1 <= numRows <= 30

public class PascalsTriangle 
{
	public List<List<Integer>> generate(int numRows)
	{
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		temp.add(1);
		res.add(new ArrayList<>(temp));
		if(numRows==1) {
			return res;
		}
		temp.add(1);
		res.add(new ArrayList<>(temp));
		if(numRows==2) {
			return res;
		}
		temp.add(1, 2);
		res.add(new ArrayList<>(temp));
		for(int i=4;i<=numRows;i++) {
			temp  = new ArrayList<>();
			temp.add(1);
			int n = res.getLast().size();
			for(int j=1;j<n;j++) {
				temp.add(res.getLast().get(j)+res.getLast().get(j-1));
			}
			temp.add(1);
			res.add(new ArrayList<>(temp));
		}
		return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		PascalsTriangle Res = new PascalsTriangle();
		System.out.print(Res.generate(N));
	}

}
