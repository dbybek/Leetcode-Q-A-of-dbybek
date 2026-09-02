import java.util.Scanner;

//2058. Find the Minimum and Maximum Number of Nodes Between Critical Points (Medium)
//-----------------------------------------------------------------------------------
//A critical point in a linked list is defined as either a local maxima or a local minima.
//A node is a local maxima if the current node has a value strictly greater than the previous node and the next node.
//A node is a local minima if the current node has a value strictly smaller than the previous node and the next node.
//Note that a node can only be a local maxima/minima if there exists both a previous node and a next node.
//Given a linked list head, return an array of length 2 containing [minDistance, maxDistance]
//where minDistance is the minimum distance between any two distinct critical points and
//maxDistance is the maximum distance between any two distinct critical points.
//If there are fewer than two critical points, return [-1, -1].
//
//Constraints:
//-----------
//The number of nodes in the list is in the range [2, 10^5].
//1 <= Node.val <= 10^5

public class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints 
{
	public int[] nodesBetweenCriticalPoints(ListNode head)
	{
		int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        int ind = 0, firstCP = 0, prevCP = 0, currCP = 0;
        ListNode prevNode = head, currNode = head;
        while(currNode.next!=null && firstCP==0){
            ind++;
            if((prevNode.val>currNode.val && currNode.val<currNode.next.val) ||
               (prevNode.val<currNode.val && currNode.val>currNode.next.val))
            {
                firstCP = ind;
                prevCP = ind;
                currCP = ind;
            }
            prevNode = currNode;
            currNode = currNode.next;
        }
        if(firstCP==0){
            return res;
        }
        while(currNode.next!=null){
            ind++;
            if((prevNode.val>currNode.val && currNode.val<currNode.next.val) ||
               (prevNode.val<currNode.val && currNode.val>currNode.next.val))
            {
                currCP = ind;
                if(res[0]==-1){
                    res[0] = currCP - prevCP;
                }
                else{
                    res[0] = Math.min(res[0], currCP - prevCP);
                }
                prevCP = ind;
            }
            prevNode = currNode;
            currNode = currNode.next;
        }
        if(firstCP<prevCP){
            res[1] = prevCP-firstCP;
        }
        return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ListNode node6 = new ListNode(sc.nextInt());
		ListNode node5 = new ListNode(sc.nextInt(), node6);
		ListNode node4 = new ListNode(sc.nextInt(), node5);
		ListNode node3 = new ListNode(sc.nextInt(), node4);
		ListNode node2 = new ListNode(sc.nextInt(), node3);
		ListNode node1 = new ListNode(sc.nextInt(), node2);
		ListNode head = new ListNode(sc.nextInt(), node1);
		sc.close();
		FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints Res = new FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints();
		int[] arr = Res.nodesBetweenCriticalPoints(head);
		System.out.print(arr[0]+" "+arr[1]);
	}
}
