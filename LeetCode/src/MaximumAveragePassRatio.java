import java.util.*;

//1792. Maximum Average Pass Ratio (Medium)
//-----------------------------------------
//There is a school that has classes of students and each class will be having a final exam.
//You are given a 2D integer array classes, where classes[i] = [passi, totali].
//You know beforehand that in the ith class, there are totali total students,
//but only passi number of students will pass the exam.
//You are also given an integer extraStudents.
//There are another extraStudents brilliant students that are guaranteed to pass the exam of any class they are assigned to.
//You want to assign each of the extraStudents students to a class in a way that maximizes 
//the average pass ratio across all the classes.
//The pass ratio of a class is equal to the number of students of the class that will pass the exam 
//divided by the total number of students of the class.
//The average pass ratio is the sum of pass ratios of all the classes divided by the number of the classes.
//
//Return the maximum possible average pass ratio after assigning the extraStudents students.
//Answers within 10-5 of the actual answer will be accepted.
//
//Constraints:
//-----------
//1 <= classes.length <= 10^5
//classes[i].length == 2
//1 <= passi <= totali <= 10^5
//1 <= extraStudents <= 10^5

public class MaximumAveragePassRatio 
{
	public double maxAverageRatio(int[][] classes, int extraStudents)
	{
		PriorityQueue<double[]> pq = new PriorityQueue<>((a,b)-> Double.compare(b[0], a[0]));
		for(int[] ele:classes) {
			double pass = ele[0];
            double total = ele[1];
            double inc = (pass + 1.0) / (total + 1.0) - pass / total;
            pq.offer(new double[]{inc, pass, total});
		}
		
		for(int i=0;i<extraStudents;i++) {
			double[] top = pq.poll();
            double pass = top[1] + 1;
            double total = top[2] + 1;
            double inc = (pass + 1.0) / (total + 1.0) - pass / total;
            pq.offer(new double[]{inc, pass, total});
		}
		
		double res = 0.0;
		for(double[] ele:pq) {
			res += ele[1]/ele[2];
		}
		return res/classes.length;
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
		int k = sc.nextInt();
		sc.close();
		MaximumAveragePassRatio Res = new MaximumAveragePassRatio();
		System.out.print(Res.maxAverageRatio(arr, k));
	}
}