import java.util.Scanner;

//1927. Sum Game (Medium)
//-----------------------
//Alice and Bob take turns playing a game, with Alice starting first.
//You are given a string num of even length consisting of digits and '?' characters.
//On each turn, a player will do the following if there is still at least one '?' in num:
//Choose an index i where num[i] == '?'.
//Replace num[i] with any digit between '0' and '9'.
//The game ends when there are no more '?' characters in num.
//For Bob to win, the sum of the digits in the first half of num must be equal to the sum of the digits in the second half.
//For Alice to win, the sums must not be equal.
//For example, if the game ended with num = "243801", then Bob wins because 2+4+3 = 8+0+1.
//If the game ended with num = "243803", then Alice wins because 2+4+3 != 8+0+3.
//Assuming Alice and Bob play optimally, return true if Alice will win and false if Bob will win.
//
//Constraints:
//-----------
//2 <= num.length <= 10^5
//num.length is even.
//num consists of only digits and '?'.

public class SumGame 
{
	public boolean sumGame(String num)
	{
		int lHalf = 0, rHalf = 0, lSum = 0, rSum = 0, n = num.length();
        for(int i=0;i<n;i++){
            if(i<n/2){
                if(num.charAt(i)=='?'){
                    lHalf++;
                }
                else{
                    lSum+=(num.charAt(i)-'0');
                }
            }
            else{
                if(num.charAt(i)=='?'){
                    rHalf++;
                }
                else{
                    rSum+=(num.charAt(i)-'0');
                }
            }
        }
        return (lHalf+rHalf)%2==1 || (lSum-rSum)!=((rHalf-lHalf)*9)/2;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		sc.close();
		SumGame Res = new SumGame();
		System.out.print(Res.sumGame(N));
	}
}
