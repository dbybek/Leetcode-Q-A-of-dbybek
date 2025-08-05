import java.util.Scanner;

//904. Fruits Into Baskets II (Easy)
//----------------------------------
//You are given two arrays of integers, fruits and baskets, each of length n,
//where fruits[i] represents the quantity of the ith type of fruit,
//and baskets[j] represents the capacity of the jth basket.
//From left to right, place the fruits according to these rules:
//
//Each fruit type must be placed in the leftmost available basket with a capacity greater than or
//equal to the quantity of that fruit type.
//Each basket can hold only one type of fruit.
//If a fruit type cannot be placed in any basket, it remains unplaced.
//Return the number of fruit types that remain unplaced after all possible allocations are made.
//
//Constraints:
//-----------
//n == fruits.length == baskets.length
//1 <= n <= 100
//1 <= fruits[i], baskets[i] <= 1000

public class FruitsIntoBasketsII 
{
	public int numOfUnplacedFruits(int[] fruits, int[] baskets) 
	{
		int n = fruits.length, usedBasketCount = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(fruits[i] <= baskets[j]) {
					usedBasketCount++;
					baskets[j] = 0;
					break;
				}
			}
		}
		return n-usedBasketCount;
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
		int[] arr1 = new int[N];
		for(int i=0;i<N;i++) {
			arr1[i] = sc.nextInt();
		}
		sc.close();
		FruitsIntoBasketsII Res = new FruitsIntoBasketsII();
		System.out.print(Res.numOfUnplacedFruits(arr, arr1));
	}

}
