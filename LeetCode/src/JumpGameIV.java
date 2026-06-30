import java.util.*;

//1345. Jump Game IV (Hard)
//-------------------------
//Given an array of integers arr, you are initially positioned at the first index of the array.
//In one step you can jump from index i to index:
//
//i + 1 where: i + 1 < arr.length.
//i - 1 where: i - 1 >= 0.
//j where: arr[i] == arr[j] and i != j.
//Return the minimum number of steps to reach the last index of the array.
//
//Notice that you can not jump outside of the array at any time.
//Constraints:
//-----------
//1 <= arr.length <= 5 * 10^4
//-10^8 <= arr[i] <= 10^8

public class JumpGameIV 
{
	public int minJumps(int[] arr)
	{
		HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();
        int n = arr.length;
        if(n==1){
            return 0;
        }
        if(arr[0]==arr[n-1]){
            return 1;
        }
        for(int i=0;i<n;i++){
            hm.putIfAbsent(arr[i], new ArrayList<>());
            hm.get(arr[i]).add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.offer(0);
        visited[0] = true;
        int res = 0;
        while(!q.isEmpty()){
            int s = q.size();
            while(s-- > 0){
                int currInd = q.poll();
                if(currInd==n-1){
                    return res;
                }
                if(currInd+1<n && !visited[currInd+1]){
                    visited[currInd+1] = true;
                    q.offer(currInd+1);
                }
                if(currInd-1>=0 && !visited[currInd-1]){
                    visited[currInd-1] = true;
                    q.offer(currInd-1);
                }
                for(int ind:hm.get(arr[currInd])){
                    if(!visited[ind]){
                        visited[ind] = true;
                        q.offer(ind);
                    }
                }
                hm.get(arr[currInd]).clear();
            }
            res++;
        }
        return -1;
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
		JumpGameIV Res = new JumpGameIV();
		System.out.print(Res.minJumps(arr));
	}
}
