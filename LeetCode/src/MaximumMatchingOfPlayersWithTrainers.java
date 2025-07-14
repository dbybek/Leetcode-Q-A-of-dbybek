import java.util.*;

//2410. Maximum Matching of Players With Trainers(Medium)
//-------------------------------------------------------
//You are given a 0-indexed integer array players, where players[i] represents the ability of the ith player.
//You are also given a 0-indexed integer array trainers,
//where trainers[j] represents the training capacity of the jth trainer.
//The ith player can match with the jth trainer 
//if the player's ability is less than or equal to the trainer's training capacity.
//Additionally, the ith player can be matched with at most one trainer,
//and the jth trainer can be matched with at most one player.
//
//Return the maximum number of matchings between players and trainers that satisfy these conditions.
//
//Constraints:
//-----------
//1 <= players.length, trainers.length <= 10^5
//1 <= players[i], trainers[j] <= 10^9

public class MaximumMatchingOfPlayersWithTrainers 
{
	public int matchPlayersAndTrainers(int[] players, int[] trainers)
	{
		Arrays.sort(players);
        Arrays.sort(trainers);
        int i=0, j=0, res=0;
        while(i<players.length && j<trainers.length){
            if(players[i]<=trainers[j]){
                res++;
                i++;
            }
            j++;
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
		int M = sc.nextInt();
		int[] arr2 = new int[N];
		for(int i=0;i<M;i++) {
			arr2[i] = sc.nextInt();
		}
		sc.close();
		MaximumMatchingOfPlayersWithTrainers Res = new MaximumMatchingOfPlayersWithTrainers();
		System.out.print(Res.matchPlayersAndTrainers(arr, arr2));
	}

}
