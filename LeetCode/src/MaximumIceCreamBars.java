import java.util.Scanner;

//1833. Maximum Ice Cream Bars (Medium)
//-------------------------------------
//It is a sweltering summer day, and a boy wants to buy some ice cream bars.
//At the store, there are n ice cream bars.
//You are given an array costs of length n, where costs[i] is the price of the ith ice cream bar in coins.
//The boy initially has coins coins to spend, and he wants to buy as many ice cream bars as possible. 
//Note: The boy can buy the ice cream bars in any order.
//Return the maximum number of ice cream bars the boy can buy with coins coins.
//
//You must solve the problem by counting sort.
//
//Constraints:
//-----------
//costs.length == n
//1 <= n <= 10^5
//1 <= costs[i] <= 10^5
//1 <= coins <= 10^8

public class MaximumIceCreamBars 
{
	public int maxIceCream(int[] costs, int coins)
	{
		int mx = 0;
        for(int i=0;i<costs.length;i++){
            mx = Math.max(mx,costs[i]);
        }
        int[] freq = new int[mx+1];
        for(int i=0;i<costs.length;i++){
            freq[costs[i]]++;
        }
        int res = 0, count = 0;
        for(int i=1;i<=mx;i++){
            if(freq[i]==0){
                continue;
            }
            count = Math.min(freq[i],coins/i);
            res+=count;
            coins-=count*i;
            if(coins<i){
                break;
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
		int k = sc.nextInt();
		sc.close();
		MaximumIceCreamBars Res = new MaximumIceCreamBars();
		System.out.print(Res.maxIceCream(arr, k));
	}
}
