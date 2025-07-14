import java.util.*;

//3085. Minimum Deletions to Make String K-Special (Medium)
//---------------------------------------------------------
//You are given a string word and an integer k.
//
//We consider word to be k-special if |freq(word[i]) - freq(word[j])| <= k for all indices i and j in the string.
//
//Here, freq(x) denotes the frequency of the character x in word, and |y| denotes the absolute value of y.
//
//Return the minimum number of characters you need to delete to make word k-special.
//
//Constraints:
//-----------
//1 <= word.length <= 10^5
//0 <= k <= 10^5
//word consists only of lowercase English letters.

public class MinimumDeletionsToMakeStringKSpecial 
{
	public int minimumDeletions(String word, int k)
	{
		int[] freq = new int[26];
		for(int i=0;i<word.length();i++) {
			freq[word.charAt(i)-'a']++;
		}
		List<Integer> count = new ArrayList<>();
		for(int ele:freq) {
			if(ele>0) {
				count.add(ele);
			}
		}
		Collections.sort(count);
		int res = 100001, total = word.length(), delete = 0, sum = 0, j = 0, n = count.size();
		for(int i=0;i<n;i++) {
			int f = count.get(i), t = f+k;
			while(j<n && count.get(j)<=t) {
				sum += count.get(j);
				j++;
			}
			int l = n-j, lSum = total-sum, req = l*t, deleted = lSum-req;
			res = Math.min(res,delete + deleted);
			total -= count.get(i);
			delete += count.get(i);
			sum -= count.get(i);
		}
		return res;
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int K = sc.nextInt();
		sc.close();
		MinimumDeletionsToMakeStringKSpecial Res = new MinimumDeletionsToMakeStringKSpecial();
		System.out.print(Res.minimumDeletions(str, K));
	}

}
