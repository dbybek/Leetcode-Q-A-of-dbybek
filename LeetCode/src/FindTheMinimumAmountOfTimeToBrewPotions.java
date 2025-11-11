import java.util.Scanner;

//3494. Find the Minimum Amount of Time to Brew Potions (Medium)
//--------------------------------------------------------------
//You are given two integer arrays, skill and mana, of length n and m, respectively.
//In a laboratory, n wizards must brew m potions in order.
//Each potion has a mana capacity mana[j] and must pass through all the wizards sequentially to be brewed properly.
//The time taken by the ith wizard on the jth potion is timeij = skill[i] * mana[j].
//Since the brewing process is delicate,
//a potion must be passed to the next wizard immediately after the current wizard completes their work.
//This means the timing must be synchronized so that each wizard begins working on a potion exactly when it arrives. ​
//
//Return the minimum amount of time required for the potions to be brewed properly.
//
//Constraints:
//-----------
//n == skill.length
//m == mana.length
//1 <= n, m <= 5000
//1 <= mana[i], skill[i] <= 5000

public class FindTheMinimumAmountOfTimeToBrewPotions 
{
	public long minTime(int[] skill, int[] mana)
	{
		int n = skill.length, m = mana.length;
		long[] preSkill = new long[n];
		preSkill[0] = skill[0];
		for(int i=1;i<n;i++) {
			preSkill[i] = preSkill[i-1]+skill[i];
		}
		long time = 0;
		for(int i=1;i<m;i++) {
			long canDo = time+(long)(skill[0]*mana[i-1]);
			for(int j=1;j<n;j++) {
				long temp = time+((preSkill[j]*(long)mana[i-1])-(preSkill[j-1]*(long)mana[i]));
				if(temp>canDo) {
					canDo = temp;
				}
			}
			time = canDo;
		}
		return time+preSkill[n-1]*mana[m-1];
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		int[] arr1 = new int[M];
		for(int i=0;i<M;i++) {
			arr1[i] = sc.nextInt();
		}
		sc.close();
		FindTheMinimumAmountOfTimeToBrewPotions Res = new FindTheMinimumAmountOfTimeToBrewPotions();
		System.out.print(Res.minTime(arr, arr1));
	}
}
