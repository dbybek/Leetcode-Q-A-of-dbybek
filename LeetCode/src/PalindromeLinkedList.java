import java.util.Scanner;

//234. Palindrome Linked List(Easy)
//---------------------------------
//Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
//
//Constraints:
//-----------
//The number of nodes in the list is in the range [1, 10^5].
//0 <= Node.val <= 9

public class PalindromeLinkedList 
{
	private ListNode reverse(ListNode r)
	{
		if(r==null || r.next==null) {
			return r;
		}
		ListNode prevNode = null, currNode = r;
		while(currNode!=null) {
			ListNode nextNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;
		}
		return prevNode;
	}
	
	public boolean isPalindrome(ListNode head) 
	{
		if(head==null || head.next==null) {
			return false;
		}
		ListNode slow = head, fast = head;
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		fast = head;
		slow = reverse(slow);
		while(slow!=null) {
			if(fast.val!=slow.val) {
				return false;
			}
			slow = slow.next;
			fast = fast.next;
		}
		return true;
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
		PalindromeLinkedList Res = new PalindromeLinkedList();
		System.out.print(Res.isPalindrome(root));
	}
}
