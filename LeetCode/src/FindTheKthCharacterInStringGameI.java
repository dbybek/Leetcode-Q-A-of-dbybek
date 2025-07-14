import java.util.Scanner;

//3304. Find the K-th Character in String Game I(Easy)
//----------------------------------------------------
//Alice and Bob are playing a game. Initially, Alice has a string word = "a".
//
//You are given a positive integer k.
//
//Now Bob will ask Alice to perform the following operation forever:
//
//Generate a new string by changing each character in word to its next character in the English alphabet,
//and append it to the original word.
//For example, performing the operation on "c" generates "cd" and performing the operation on "zb" generates "zbac".
//
//Return the value of the kth character in word,
//after enough operations have been done for word to have at least k characters.
//
//Note that the character 'z' can be changed to 'a' in the operation.
//
//Constraints:
//-----------
//1 <= k <= 500

public class FindTheKthCharacterInStringGameI 
{
	public char kthCharacter(int k)
	{
//		ApproachI: Creating the word with length >= k then returning the kth character.
//		-------------------------------------------------------------------------------
//		StringBuilder word = new StringBuilder("a");
//        int n = 1;
//        while (n < k) {
//            n = word.length();
//            for (int i=0;i<n;i++) {
//                char ch = word.charAt(i);
//                if (ch=='z') {
//                    word.append('a');
//                } 
//                else {
//                    word.append((char)(ch + 1));
//                }
//            }
//        }
//        
//        return word.charAt(k - 1);
//        
//      ApproachII: Calculating the bits in k and finding the parent index for the character then adding the increments with 'a'.
//      -------------------------------------------------------------------------------------------------------------------------
//        int n = k-1, count = 0;
//        while (n > 0) {
//            long p = 1;
//            while (p * 2 <= n) {
//                p *= 2;
//            }
//            count++;
//            n -= p;
//        }
//        return (char) ('a' + (count % 26));
//		
		return (char) ('a' + Integer.bitCount(k - 1));
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		FindTheKthCharacterInStringGameI Res = new FindTheKthCharacterInStringGameI();
		System.out.print(Res.kthCharacter(N));
	}
}
