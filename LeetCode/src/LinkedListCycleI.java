import java.util.Scanner;

//141. Linked List Cycle I (Easy)
//-------------------------------
//Given head, the head of a linked list, determine if the linked list has a cycle in it.
//There is a cycle in a linked list if there is some node in the list that can be reached again
//by continuously following the next pointer.
//Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
//Note that pos is not passed as a parameter.
//Return true if there is a cycle in the linked list. Otherwise, return false.
//
//Do not modify the linked list.
//Constraints:
//-----------
//The number of the nodes in the list is in the range [0, 10^4].
//-10^5 <= Node.val <= 10^5
//pos is -1 or a valid index in the linked-list.

public class LinkedListCycleI
{
	public boolean hasCycle(ListNode head)
	{
		ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ListNode node3 = new ListNode(sc.nextInt());
		ListNode node2 = new ListNode(sc.nextInt(),node3);
		ListNode node1 = new ListNode(sc.nextInt(),node2);
		ListNode root = new ListNode(sc.nextInt(),node1);
		node3.next = node1;
		sc.close();
		LinkedListCycleI Res = new LinkedListCycleI();
		System.out.print(Res.hasCycle(root));
	}
}
