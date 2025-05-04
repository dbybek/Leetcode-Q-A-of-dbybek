import java.util.*;

//1128. Number of Equivalent Domino Pairs (Easy)
//----------------------------------------------
//Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d]
//if and only if either (a == c and b == d), or (a == d and b == c) - that is, 
//one domino can be rotated to be equal to another domino.
//Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].
//
//Constraints:
//-----------
//1 <= dominoes.length <= 4 * 10^4
//dominoes[i].length == 2
//1 <= dominoes[i][j] <= 9

public class NumberOfEquivalentDominoPairs 
{

	public int numEquivDominoPairs(int[][] dominoes)
	{
//		Approach I: Brute force but this will give TC exceeded.
//		-------------------------------------------------------
//		int res = 0, n=dominoes.length;
//		for(int i=0;i<n;i++) {
//			for(int j=i+1;j<n;j++) {
//				if(dominoes[i][0]==dominoes[j][0] && dominoes[i][1]==dominoes[j][1]) {
//					res++;
//				}
//				else if(dominoes[i][0]==dominoes[j][1] && dominoes[i][1]==dominoes[j][0]) {
//					res++;
//				}
//			}
//		}
//		return res;
//		
//		Approach II: Efficient pair grouping by making the dominoes unique
//		------------------------------------------------------------------
//		HashMap<String, Integer> hm = new HashMap<>();
//        int res = 0;
//        for (int[] d : dominoes) {
//            int a = Math.min(d[0], d[1]);
//            int b = Math.max(d[0], d[1]);
//            String key = a + "," + b;
//            hm.put(key, hm.getOrDefault(key, 0) + 1);
//        }
//        for (int val : hm.values()) {
//            res += val * (val - 1) / 2;
//        }
//        return res;
//		
//		Approach III: Efficient pair grouping by making the dominoes unique and using a fixed length Array.
//		---------------------------------------------------------------------------------------------------
		int[][] dp = new int[10][10];
        for(int[] d : dominoes) {
            dp[d[0]][d[1]]++;
        }
        int res = 0;
        for(int i=1;i<10;i++){
        	for(int j=i;j<dp[i].length;j++){
        		int count = dp[i][j];
                if(i!=j) {
                	count+=dp[j][i];
                }
                res += count * (count - 1) / 2;
            }
        }
        return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][2];
		for(int i=0;i<N;i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		sc.close();
		NumberOfEquivalentDominoPairs Res = new NumberOfEquivalentDominoPairs();
		System.out.print(Res.numEquivDominoPairs(arr));
	}

}
