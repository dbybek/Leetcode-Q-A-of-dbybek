import java.util.Scanner;

//1304. Find N Unique Integers Sum up to Zero (Easy)
//--------------------------------------------------
//Given an integer n, return any array containing n unique integers such that they add up to 0.
//
//Constraints:
//-----------
//1 <= n <= 1000

public class FindNUniqueIntegersSumUpToZero 
{
	public int[] sumZero(int n)
	{
//		Approach I: Using 2 values-> One for index and another for result value.
//		------------------------------------------------------------------------
//		int[] res = new int[n];
//        if(n%2!=0){
//            res[n/2] = 0;
//        }
//        int i = 1, j = 0;
//        while(j<n/2){
//            res[j++] = i;
//            i++;
//        }
//        i = -1;
//        j = (n%2!=0)?(n/2)+1:n/2;
//        while(j<n){
//            res[j++] = i;
//            i--;
//        }
//        return res;
//		
//		Approach II: Same as above but in just one loop.
//		------------------------------------------------
		int[] res = new int[n];
        int ind = 0;
        for (int i=1;i<=n/2;i++) {
            res[ind++] = i;
            res[ind++] = -i;
        }
        if (n%2!=0) {
            res[ind] = 0;
        }
        return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		FindNUniqueIntegersSumUpToZero Res = new FindNUniqueIntegersSumUpToZero();
		int[] arr = Res.sumZero(N);
		for(int ele:arr) {
			System.out.print(ele+" ");
		}
	}
}
