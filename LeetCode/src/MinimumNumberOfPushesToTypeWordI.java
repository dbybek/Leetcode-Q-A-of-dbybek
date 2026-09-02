import java.util.Scanner;

//3014. Minimum Number of Pushes to Type Word I (Easy)
//----------------------------------------------------
//You are given a string word containing distinct lowercase English letters.
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
//1 <= word.length <= 26
//word consists of lowercase English letters.
//All letters in word are distinct.

public class MinimumNumberOfPushesToTypeWordI 
{
	public int minimumPushes(String word)
	{
		int res = 0, n = word.length(), mul = 1;
        while(n>0){
            if(n<8){
                res += (n*mul);
            }
            else{
                res += (8*mul);
            }
            n -= 8;
            mul++;
        }
        return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		sc.close();
		MinimumNumberOfPushesToTypeWordI Res = new MinimumNumberOfPushesToTypeWordI();
		System.out.print(Res.minimumPushes(N));
	}
}
