import java.util.*;

//1665. Minimum Initial Energy to Finish Tasks (Hard)
//---------------------------------------------------
//You are given an array tasks where tasks[i] = [actuali, minimumi]:
//actuali is the actual amount of energy you spend to finish the ith task.
//minimumi is the minimum amount of energy you require to begin the ith task.
//For example, if the task is [10, 12] and your current energy is 11, you cannot start this task.
//However, if your current energy is 13, you can complete this task, and your energy will be 3 after finishing it.
//
//You can finish the tasks in any order you like.
//
//Return the minimum initial amount of energy you will need to finish all the tasks.
//Constraints:
//-----------
//1 <= tasks.length <= 10^5
//1 <= actual​i <= minimumi <= 10^4

public class MinimumInitialEnergyToFinishTasks 
{
	public int minimumEffort(int[][] tasks)
	{
		Arrays.sort(tasks, (a,b) -> (b[1]-b[0])-(a[1]-a[0]));
        int currE = 0, res = 0;
        for(int[] task:tasks){
            if(currE<task[1]){
                res += (task[1]-currE);
                currE = task[1];
            }
            currE -= task[0];
        }
        return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][2];
		for(int i=0;i<N;i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		sc.close();
		MinimumInitialEnergyToFinishTasks Res = new MinimumInitialEnergyToFinishTasks();
		System.out.print(Res.minimumEffort(arr));
	}
}
