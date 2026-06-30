import java.util.Scanner;

//1967. Number of Strings That Appear as Substrings in Word (Easy)
//----------------------------------------------------------------
//Given an array of strings patterns and a string word,
//return the number of strings in patterns that exist as a substring in word.
//A substring is a contiguous sequence of characters within a string.
//
//Constraints:
//-----------
//1 <= patterns.length <= 100
//1 <= patterns[i].length <= 100
//1 <= word.length <= 100
//patterns[i] and word consist of lowercase English letters.

public class NumberOfStringsThatAppearAsSubstringsInWord 
{
	// private boolean subStr(String str, String W)
    // {
    //     int i = 0;
    //     for(int j=0;j<W.length();j++){
    //         if(str.charAt(i)==W.charAt(j)){
    //             i++;
    //         }
    //         else{
    //             j-=i;
    //             i = 0;
    //         }
    //         if(i==str.length()){
    //             return true;
    //         }
    //     }
    //     return false;
    // }
	
	public int numOfStrings(String[] patterns, String word)
	{
		// int res = 0;
        // for(String str:patterns){
        //     if(subStr(str,word)){
        //         res++;
        //     }
        // }
        // return res;
        int res = 0;
        for(String str:patterns){
            if(word.contains(str)){
                res++;
            }
        }
        return res;
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
		String w = sc.next();
		sc.close();
		NumberOfStringsThatAppearAsSubstringsInWord Res = new NumberOfStringsThatAppearAsSubstringsInWord();
		System.out.print(Res.numOfStrings(arr, w));
	}
}
