import java.util.Scanner;

//3016. Minimum Number of Pushes to Type Word II (Medium)
//-------------------------------------------------------
//You are given a string word containing lowercase English letters.
//Telephone keypads have keys mapped with distinct collections of lowercase English letters,
//which can be used to form words by pushing them. For example, the key 2 is mapped with ["a","b","c"],
//we need to push the key one time to type "a", two times to type "b", and three times to type "c" .
//It is allowed to remap the keys numbered 2 to 9 to distinct collections of letters.
//The keys can be remapped to any amount of letters, but each letter must be mapped to exactly one key.
//You need to find the minimum number of times the keys will be pushed to type the string word.
//Return the minimum number of pushes needed to type word after remapping the keys.
//An example mapping of letters to keys on a telephone keypad is given below.
//Note that 1, *, #, and 0 do not map to any letters.
//
//Constraints:
//-----------
//1 <= word.length <= 10^5
//word consists of lowercase English letters.

public class MinimumNumberOfPushesToTypeWordII 
{
	int[] distMax = new int[26];
    private void maxValChange(int ind, int val)
    {
        for(int i=25;i>=0;i--){
            if(ind==i){
                distMax[i] = val;
                return;
            }
            distMax[i] = distMax[i-1];
        }
    }
    
	public int minimumPushes(String word)
	{
		int dist = 0;
        int[] freq = new int[26];
        for(int i=0;i<word.length();i++){
            if(freq[word.charAt(i)-'a']==0){
                dist++;
            }
            freq[word.charAt(i)-'a']++;
        }
        if(dist<=8){
            return word.length();
        }
        int res = 0;
        for(int i=0;i<26;i++){
            if(freq[i]>distMax[0]){
                maxValChange(0,freq[i]);
            }
            else if(freq[i] > distMax[1]){
                maxValChange(1,freq[i]);
            }
            else if(freq[i] > distMax[2]){
                maxValChange(2,freq[i]);
            }
            else if(freq[i] > distMax[3]){
                maxValChange(3,freq[i]);
            }
            else if(freq[i] > distMax[4]){
                maxValChange(4,freq[i]);
            }
            else if(freq[i] > distMax[5]){
                maxValChange(5,freq[i]);
            }
            else if(freq[i] > distMax[6]){
                maxValChange(6,freq[i]);
            }
            else if(freq[i] > distMax[7]){
                maxValChange(7,freq[i]);
            }
            else if(freq[i] > distMax[8]){
                maxValChange(8,freq[i]);
            }
            else if(freq[i] > distMax[9]){
                maxValChange(9,freq[i]);
            }
            else if(freq[i] > distMax[10]){
                maxValChange(10,freq[i]);
            }
            else if(freq[i] > distMax[11]){
                maxValChange(11,freq[i]);
            }
            else if(freq[i] > distMax[12]){
                maxValChange(12,freq[i]);
            }
            else if(freq[i] > distMax[13]){
                maxValChange(13,freq[i]);
            }
            else if(freq[i] > distMax[14]){
                maxValChange(14,freq[i]);
            }
            else if(freq[i] > distMax[15]){
                maxValChange(15,freq[i]);
            }
            else if(freq[i] > distMax[16]){
                maxValChange(16,freq[i]);
            }
            else if(freq[i] > distMax[17]){
                maxValChange(17,freq[i]);
            }
            else if(freq[i] > distMax[18]){
                maxValChange(18,freq[i]);
            }
            else if(freq[i] > distMax[19]){
                maxValChange(19,freq[i]);
            }
            else if(freq[i] > distMax[20]){
                maxValChange(20,freq[i]);
            }
            else if(freq[i] > distMax[21]){
                maxValChange(21,freq[i]);
            }
            else if(freq[i] > distMax[22]){
                maxValChange(22,freq[i]);
            }
            else if(freq[i] > distMax[23]){
                maxValChange(23,freq[i]);
            }
            else if(freq[i] > distMax[24]){
                maxValChange(24,freq[i]);
            }
            else if(freq[i] > distMax[25]){
                distMax[25] = freq[i];
            }
        }
        for(int i=0;i<dist;i++){
        	res += distMax[i]*((i/8)+1);
        }
        return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		sc.close();
		MinimumNumberOfPushesToTypeWordII Res = new MinimumNumberOfPushesToTypeWordII();
		System.out.print(Res.minimumPushes(N));
	}
}
