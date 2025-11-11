import java.util.*;

//1488. Avoid Flood in The City (Medium)
//--------------------------------------
//Your country has an infinite number of lakes.
//Initially, all the lakes are empty, but when it rains over the nth lake, the nth lake becomes full of water.
//If it rains over a lake that is full of water, there will be a flood. Your goal is to avoid floods in any lake.
//Given an integer array rains where:
//rains[i] > 0 means there will be rains over the rains[i] lake.
//rains[i] == 0 means there are no rains this day and you can choose one lake this day and dry it.
//Return an array ans where:
//ans.length == rains.length
//ans[i] == -1 if rains[i] > 0.
//ans[i] is the lake you choose to dry in the ith day if rains[i] == 0.
//If there are multiple valid answers return any of them. If it is impossible to avoid flood return an empty array.
//Notice that if you chose to dry a full lake, it becomes empty, but if you chose to dry an empty lake, nothing changes.
//
//Constraints:
//-----------
//1 <= rains.length <= 10^5
//0 <= rains[i] <= 10^9

public class AvoidFloodInTheCity 
{
	public int[] avoidFlood(int[] rains)
	{
		int n = rains.length;
        int[] res = new int[n];
        HashMap<Integer,Integer> hm = new HashMap<>();
        TreeSet<Integer> tSet = new TreeSet<>();
        for(int i=0;i<n;i++){
            if(rains[i]==0) {
            	tSet.add(i);
            	res[i] = 1;
            }
            else {
            	res[i] = -1;
            	if(hm.containsKey(rains[i])) {
            		Integer dry = tSet.higher(hm.get(rains[i]));
            		if(dry==null) {
            			return new int[0];
            		}
            		res[dry] = rains[i];
            		tSet.remove(dry);
            	}
            	hm.put(rains[i], i);
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
		AvoidFloodInTheCity Res = new AvoidFloodInTheCity();
		int[] arr1 = Res.avoidFlood(arr);
		for(int i=0;i<N;i++) {
			System.out.print(arr1[i]+" ");
		}
	}
}
