import java.util.*;

//3285. Find Indices of Stable Mountains (Easy)
//---------------------------------------------
//There are n mountains in a row, and each mountain has a height.
//You are given an integer array height where height[i] represents the height of mountain i, and an integer threshold.
//A mountain is called stable if the mountain just before it (if it exists) has a height strictly greater than threshold.
//Note that mountain 0 is not stable.
//Return an array containing the indices of all stable mountains in any order.
//
//Constraints:
//-----------
//2 <= n == height.length <= 100
//1 <= height[i] <= 100
//1 <= threshold <= 100

public class FindIndicesOfStableMountains 
{
	public List<Integer> stableMountains(int[] height, int threshold)
	{
		List<Integer> res = new ArrayList<>();
        for(int i=1;i<height.length;i++){
            if(height[i-1]>threshold){
                res.add(i);
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
		int k = sc.nextInt();
		sc.close();
		FindIndicesOfStableMountains Res = new FindIndicesOfStableMountains();
		List<Integer> lst = Res.stableMountains(arr, k);
		for(Integer ele:lst) {
			System.out.print(ele+" ");
		}
	}
}
