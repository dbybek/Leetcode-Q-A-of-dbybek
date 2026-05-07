import java.util.*;

//49. Group Anagrams (Medium)
//---------------------------
//Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//Constraints:
//-----------
//1 <= strs.length <= 10^4
//0 <= strs[i].length <= 100
//strs[i] consists of lowercase English letters.

public class GroupAnagrams 
{
	public List<List<String>> groupAnagrams(String[] strs)
	{
		// HashMap<String, List<String>> res = new HashMap<>();
        // for (String str : strs) {
        //     int[] freq = new int[26];
        //     for (int i=0;i<str.length();i++) {
        //         freq[str.charAt(i) - 'a']++;
        //     }
        //     StringBuilder sb = new StringBuilder();
        //     for (int ele : freq) {
        //         sb.append(ele).append("#");
        //     }
        //     String key = sb.toString();
        //     if (!res.containsKey(key)) {
        //         res.put(key, new ArrayList<>());
        //     }
        //     res.get(key).add(str);
        // }
        // return new ArrayList<>(res.values());
        HashMap<String,List<String>> res = new HashMap<>();
        for( String str : strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);
            if(!res.containsKey(s)){
                res.put(s, new ArrayList<>());
            }
            res.get(s).add(str);
        }
        return new ArrayList<>(res.values());
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] arr = new String[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextLine();
		}
		sc.close();
		GroupAnagrams Res = new GroupAnagrams();
		System.out.print(Res.groupAnagrams(arr));
	}
}
