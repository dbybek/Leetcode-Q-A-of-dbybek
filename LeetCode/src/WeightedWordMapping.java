import java.util.Scanner;

//3838. Weighted Word Mapping (Easy)
//----------------------------------
//You are given an array of strings words, where each string represents a word containing lowercase English letters.
//You are also given an integer array weights of length 26,
//where weights[i] represents the weight of the ith lowercase English letter.
//The weight of a word is defined as the sum of the weights of its characters.
//For each word, take its weight modulo 26 and
//map the result to a lowercase English letter using reverse alphabetical order (0 -> 'z', 1 -> 'y', ..., 25 -> 'a').
//
//Return a string formed by concatenating the mapped characters for all words in order.
//
//Constraints:
//-----------
//1 <= words.length <= 100
//1 <= words[i].length <= 10
//weights.length == 26
//1 <= weights[i] <= 100
//words[i] consists of lowercase English letters.

public class WeightedWordMapping 
{
	public String mapWordWeights(String[] words, int[] weights)
	{
		StringBuilder sb = new StringBuilder();
        for(int i=0;i<words.length;i++){
            int w = 0;
            for(int j=0;j<words[i].length();j++){
                w+=weights[words[i].charAt(j)-'a'];
            }
            w%=26;
            sb.append((char)('z'-w));
        }
        return sb.toString();
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
		int[] arr1 = new int[26];
		for(int i=0;i<26;i++) {
			arr1[i] = sc.nextInt();
		}
		sc.close();
		WeightedWordMapping Res = new WeightedWordMapping();
		System.out.print(Res.mapWordWeights(arr, arr1));
	}
}
