import java.util.*;

//1282. Group the People Given the Group Size They Belong To (Medium)
//-------------------------------------------------------------------
//There are n people that are split into some unknown number of groups.
//Each person is labeled with a unique ID from 0 to n - 1.
//You are given an integer array groupSizes, where groupSizes[i] is the size of the group that person i is in.
//For example, if groupSizes[1] = 3, then person 1 must be in a group of size 3.
//Return a list of groups such that each person i is in a group of size groupSizes[i].
//Each person should appear in exactly one group, and every person must be in a group.
//If there are multiple answers, return any of them.
//It is guaranteed that there will be at least one valid solution for the given input.
//
//Constraints:
//-----------
//groupSizes.length == n
//1 <= n <= 500
//1 <= groupSizes[i] <= n

public class GroupThePeopleGivenTheGroupSizeTheyBelongTo 
{
	public List<List<Integer>> groupThePeople(int[] groupSizes)
	{
//		Approach I: Using a hashMap and running the loop while checking for the availabilty of the group size at each index.
//		--------------------------------------------------------------------------------------------------------------------
//		List<List<Integer>> res = new ArrayList<>();
//        HashMap<Integer,List<Integer>> hm = new HashMap<>();
//        int n = groupSizes.length;
//        for(int i=0;i<n;i++){
//            if(!hm.containsKey(groupSizes[i])){
//                List<Integer> temp = new ArrayList<>();
//                temp.add(i);
//                hm.put(groupSizes[i],temp);
//            }
//            else{
//                List<Integer> tmp = hm.get(groupSizes[i]);
//                tmp.add(i);
//                hm.put(groupSizes[i],tmp);
//            }
//            if(hm.get(groupSizes[i]).size()==groupSizes[i]){
//                res.add(hm.get(groupSizes[i]));
//                hm.put(groupSizes[i],new ArrayList<>());
//            }
//        }
//        return res;
//        
//		Approach II: Using a hashMap and running a nested for loop to check for more occurance of the same group size
//                   till the count of the group size is matched.
//		-------------------------------------------------------------------------------------------------------------
		List<List<Integer>> res = new ArrayList<>();
        int n = groupSizes.length;
        for(int i=0;i<n;i++){
        	if(groupSizes[i]==-1) {
        		continue;
        	}
        	int count = groupSizes[i]-1;
        	List<Integer> temp = new ArrayList<>();
        	temp.add(i);
        	for(int j=i+1;j<n && count>0;j++) {
        		if(groupSizes[j]==groupSizes[i]) {
        			temp.add(j);
        			groupSizes[j] = -1;
        			count--;
        		}
        	}
        	res.add(temp);
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
		GroupThePeopleGivenTheGroupSizeTheyBelongTo Res = new GroupThePeopleGivenTheGroupSizeTheyBelongTo();
		System.out.print(Res.groupThePeople(arr));
	}
}
