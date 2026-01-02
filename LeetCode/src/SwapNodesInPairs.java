import java.util.Scanner;

//24. Swap Nodes in Pairs(Medium)
//-------------------------------
//Given a linked list, swap every two adjacent nodes and return its head.
//You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
//
//Constraints:
//-----------
//The number of nodes in the list is in the range [0, 100].
//0 <= Node.val <= 100

public class SwapNodesInPairs 
{
	public ListNode swapPairs(ListNode head)
	{
		if(head==null || head.next==null) {
			return head;
		}
		ListNode currNode = head, prevNode = null;
		for(int i=0;i<2 && currNode!=null;i++) {
			ListNode nextNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;
		}
		head.next = swapPairs(currNode);
		return prevNode;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ListNode node3 = new ListNode();
		node3.val = sc.nextInt();
		ListNode node2 = new ListNode(sc.nextInt(),node3);
		ListNode node1 = new ListNode(sc.nextInt(),node2);
		ListNode root = new ListNode(sc.nextInt(),node1);
		sc.close();
		ListNode temp = root;
		while(temp!=null) {
			System.out.print(temp.val);
			temp = temp.next;
		}
		SwapNodesInPairs Res = new SwapNodesInPairs();
		temp = Res.swapPairs(root);
		while(temp!=null) {
			System.out.print(temp.val);
			temp = temp.next;
		}
	}
}
