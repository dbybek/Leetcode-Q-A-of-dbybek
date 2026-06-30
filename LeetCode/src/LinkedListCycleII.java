import java.util.Scanner;

//142. Linked List Cycle II (Medium)
//----------------------------------
//Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
//There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
//following the next pointer.
//Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed).
//It is -1 if there is no cycle. Note that pos is not passed as a parameter.
//
//Do not modify the linked list.
//Constraints:
//-----------
//The number of the nodes in the list is in the range [0, 10^4].
//-10^5 <= Node.val <= 10^5
//pos is -1 or a valid index in the linked-list.

public class LinkedListCycleII 
{
	public ListNode detectCycle(ListNode head)
	{
		if(head==null || head.next==null) {
			return null;
		}
		ListNode slow = head, fast = head;
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow==fast) {
				break;
			}
		}
		if(slow!=fast) {
			return null;
		}
		slow = head;
		while(slow!=fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
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
		LinkedListCycleII Res = new LinkedListCycleII();
		System.out.print(Res.detectCycle(root));
	}
}
