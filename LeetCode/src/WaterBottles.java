import java.util.Scanner;

//1518. Water Bottles (Easy)
//--------------------------
//There are numBottles water bottles that are initially full of water.
//You can exchange numExchange empty water bottles from the market with one full water bottle.
//The operation of drinking a full water bottle turns it into an empty bottle.
//Given the two integers numBottles and numExchange, return the maximum number of water bottles you can drink.
//
//Constraints:
//-----------
//1 <= numBottles <= 100
//2 <= numExchange <= 100

public class WaterBottles 
{
	public int numWaterBottles(int numBottles, int numExchange)
	{
		int res = 0, noEmptyBottles = 0;
		while(numBottles > 0) {
			res += numBottles;
			noEmptyBottles += numBottles;
			numBottles = noEmptyBottles/numExchange;
			noEmptyBottles %= numExchange;
		}
		return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		sc.close();
		WaterBottles Res = new WaterBottles();
		System.out.print(Res.numWaterBottles(N, M));
	}
}
