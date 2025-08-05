import java.util.Scanner;

//904. Fruit Into Baskets (Medium)
//--------------------------------
//You are visiting a farm that has a single row of fruit trees arranged from left to right. 
//The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
//You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
//
//You only have two baskets, 
//and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
//Starting from any tree of your choice,
//you must pick exactly one fruit from every tree (including the start tree) while moving to the right.
//The picked fruits must fit in one of your baskets.
//Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
//Given the integer array fruits, return the maximum number of fruits you can pick.
//
//Constraints:
//-----------
//1 <= numRows <= 30

public class FruitIntoBaskets 
{
	public int totalFruit(int[] fruits)
	{
		int n = fruits.length, res = 0, count = 0, currMax = 0, fruit1 = -1, fruit2 = -1;
		for(int i=0;i<n;i++) {
			int fruit = fruits[i];
			if(fruit==fruit1 || fruit==fruit2) {
				currMax++;
			}
			else {
				currMax = count+1;
			}
			
			if(fruit==fruit1) {
				count++;
			}
			else {
				count = 1;
				fruit2 = fruit1;
				fruit1 = fruit;
			}
			res = Math.max(currMax, res);
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
		FruitIntoBaskets Res = new FruitIntoBaskets();
		System.out.print(Res.totalFruit(arr));
	}

}
