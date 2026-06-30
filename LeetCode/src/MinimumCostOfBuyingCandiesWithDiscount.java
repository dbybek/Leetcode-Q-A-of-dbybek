import java.util.Scanner;

//2144. Minimum Cost of Buying Candies With Discount (Easy)
//---------------------------------------------------------
//A shop is selling candies at a discount. For every two candies sold, the shop gives a third candy for free.
//The customer can choose any candy to take away for free as long as
//the cost of the chosen candy is less than or equal to the minimum cost of the two candies bought.
//
//For example, if there are 4 candies with costs 1, 2, 3, and 4, and the customer buys candies with costs 2 and 3,
//they can take the candy with cost 1 for free, but not the candy with cost 4.
//Given a 0-indexed integer array cost, where cost[i] denotes the cost of the ith candy,
//return the minimum cost of buying all the candies.
//Constraints:
//-----------
//1 <= cost.length <= 100
//1 <= cost[i] <= 100

public class MinimumCostOfBuyingCandiesWithDiscount 
{
	public int minimumCost(int[] cost)
	{
		int[] freq = new int[101];
        for(int i=0;i<cost.length;i++){
            freq[cost[i]]++;
        }
        int res = 0, temp = 0;
        for(int i=100;i>0;i--){
            while(freq[i]>0){
                if(temp==2){
                    temp = 0;
                }
                else{
                    res+=i;
                    temp++;
                }
                freq[i]--;
            }
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
		MinimumCostOfBuyingCandiesWithDiscount Res = new MinimumCostOfBuyingCandiesWithDiscount();
		System.out.print(Res.minimumCost(arr));
	}
}
