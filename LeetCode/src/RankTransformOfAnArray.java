import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

//1331. Rank Transform of an Array (Easy)
//---------------------------------------
//Given an array of integers arr, replace each element with its rank.
//The rank represents how large the element is. The rank has the following rules:
//
//Rank is an integer starting from 1.
//The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
//Rank should be as small as possible.
//
//Constraints:
//-----------
//0 <= arr.length <= 10^5
//-10^9 <= arr[i] <= 10^9

public class RankTransformOfAnArray 
{
	public int[] arrayRankTransform(int[] arr)
	{
		HashMap<Integer,Integer> hm = new HashMap<>();
        int[] carr = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            carr[i] = arr[i];
        }
        Arrays.sort(carr);
        int rank = 1;
        for(int i=0;i<carr.length;i++){
            if(!hm.containsKey(carr[i])){
                hm.put(carr[i],rank);
                rank++;
            }
        }
        for(int i=0;i<arr.length;i++){
            arr[i] = hm.get(arr[i]);
        }
        return arr;
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
		RankTransformOfAnArray Res = new RankTransformOfAnArray();
		int[] arr1 = Res.arrayRankTransform(arr);
		for(int ele:arr1) {
			System.out.print(ele+" ");
		}
	}
}
