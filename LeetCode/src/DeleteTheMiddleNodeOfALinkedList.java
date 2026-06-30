import java.util.Scanner;

//2095. Delete the Middle Node of a Linked List (Medium)
//------------------------------------------------------
//You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.
//The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing,
//where ⌊x⌋ denotes the largest integer less than or equal to x.
//For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
//
//Constraints:
//-----------
//The number of nodes in the list is in the range [1, 10^5].
//1 <= Node.val <= 10^5

public class DeleteTheMiddleNodeOfALinkedList 
{
	public ListNode deleteMiddle(ListNode head)
	{
		if(head.next==null){
            return null;
        }
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(slow.next==null){
            head.next = null;
            return head;
        }
        slow.val = slow.next.val;
        slow.next = slow.next.next;
        return head;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ListNode node4 = new ListNode(sc.nextInt());
		ListNode node3 = new ListNode(sc.nextInt(),node4);
		ListNode node2 = new ListNode(sc.nextInt(),node3);
		ListNode node1 = new ListNode(sc.nextInt(),node2);
		ListNode head = new ListNode(sc.nextInt(),node1);
		sc.close();
		ListNode temp = head;
		System.out.println("Before deleting the middle node: ");
		while(temp!=null) {
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
		DeleteTheMiddleNodeOfALinkedList Res = new DeleteTheMiddleNodeOfALinkedList();
		temp = Res.deleteMiddle(head);
		System.out.println("After deleting the middle node: ");
		while(temp!=null) {
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
	}
}
