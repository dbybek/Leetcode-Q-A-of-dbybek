import java.util.Scanner;

//2260. Minimum Consecutive Cards to Pick Up (Medium)
//---------------------------------------------------
//You are given an integer array cards where cards[i] represents the value of the ith card.
//A pair of cards are matching if the cards have the same value.
//Return the minimum number of consecutive cards you have to pick up to have a pair of matching cards among the picked cards.
//If it is impossible to have matching cards, return -1.
//
//Constraints:
//-----------
//1 <= cards.length <= 10^5
//0 <= cards[i] <= 10^6

public class MinimumConsecutiveCardsToPickUp {

	public int minimumCardPickup(int[] cards)
	{
//		Approach I: Taking an index array of size 1000001
//		-------------------------------------------------
//		int min = Integer.MAX_VALUE, n = cards.length;
//		Integer[] index = new Integer[1000001];
//		for(int i=0;i<n;i++) {
//			min = Math.min(min, index[cards[i]] == null?Integer.MAX_VALUE : i - index[cards[i]]+1);
//			index[cards[i]] = i;
//		}
//		return min==Integer.MAX_VALUE?-1:min;
//		
//		Approach II: Taking an index array of size max value of cards + 1
//		-----------------------------------------------------------------
		int mx = Integer.MIN_VALUE, n = cards.length, min = Integer.MAX_VALUE;
        for (int ele:cards) {
        	mx = Math.max(ele, mx);
        }
        
        int[] index = new int[mx + 1];
        
        for(int i=0;i<n;i++) {
        	min = Math.min(min, index[cards[i]]==0?Integer.MAX_VALUE:i - index[cards[i]]+2);
        	index[cards[i]] = i+1;
        }
        
        return min==Integer.MAX_VALUE?-1:min;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		MinimumConsecutiveCardsToPickUp Res = new MinimumConsecutiveCardsToPickUp();
		System.out.print(Res.minimumCardPickup(arr));
	}

}
