import java.util.*;

//1200. Minimum Absolute Difference (Easy)
//----------------------------------------
//Given an array of distinct integers arr,
//find all pairs of elements with the minimum absolute difference of any two elements.
//Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows
//
//a, b are from arr
//a < b
//b - a equals to the minimum absolute difference of any two elements in arr
//
//Constraints:
//-----------
//2 <= arr.length <= 10^5
//-10^6 <= arr[i] <= 10^6

public class MinimumAbsoluteDifference 
{
	public List<List<Integer>> minimumAbsDifference(int[] arr) 
	{
        Arrays.sort(arr);
        int mndiff = Integer.MAX_VALUE;
        for(int i=0;i<arr.length-1;i++){
            mndiff = Math.min(mndiff,arr[i+1]-arr[i]);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<arr.length-1;i++){
            if(arr[i+1]-arr[i]==mndiff){
                res.add(Arrays.asList(arr[i],arr[i+1]));
            }
        }
        return res;
    }
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		MinimumAbsoluteDifference Res = new MinimumAbsoluteDifference();
		System.out.print(Res.minimumAbsDifference(arr));
	}
}
