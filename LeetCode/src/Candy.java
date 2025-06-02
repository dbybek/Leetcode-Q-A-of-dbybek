import java.util.Arrays;
import java.util.Scanner;

//135. Candy (Hard)
//-----------------
//There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
//You are giving candies to these children subjected to the following requirements:
//
//Each child must have at least one candy.
//Children with a higher rating get more candies than their neighbors.
//Return the minimum number of candies you need to have to distribute the candies to the children.
//
//Constraints:
//-----------
//n == ratings.length
//1 <= n <= 2 * 10^4
//0 <= ratings[i] <= 2 * 10^4

public class Candy 
{

	public int candy(int[] ratings) 
	{
		int res = 0, n = ratings.length;
		int[] candy = new int[n];
		Arrays.fill(candy, 1);
		
//		Checking the left side neighbours rating and assigning candies.
//		---------------------------------------------------------------
		for(int i=1;i<n;i++) {
			if(ratings[i] > ratings[i-1]) {
				candy[i] = candy[i-1]+1;
			}
		}
		
//		Checking the right side neighbours rating and assigning candies.
//		----------------------------------------------------------------		
		for(int i=n-2;i>=0;i--) {
			if(ratings[i] > ratings[i+1]) {
				candy[i] = Math.max(candy[i], candy[i+1]+1);
			}
		}
		
		for(int ele:candy) {
			res += ele;
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
		Candy Res = new Candy();
		System.out.print(Res.candy(arr));
	}

}
