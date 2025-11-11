import java.util.*;

//3217. Delete Nodes From Linked List Present in Array (Medium)
//-------------------------------------------------------------
//You are given an array of integers nums and the head of a linked list.
//Return the head of the modified linked list after removing all nodes from the linked list
//that have a value that exists in nums.
//
//Constraints:
//-----------
//1 <= nums.length <= 10^5
//1 <= nums[i] <= 10^5
//All elements in nums are unique.
//The number of nodes in the given list is in the range [1, 10^5].
//1 <= Node.val <= 10^5
//The input is generated such that there is at least one node in the linked list that has a value not present in nums.

public class DeleteNodesFromLinkedListPresentInArray 
{
	public ListNode modifiedList(int[] nums, ListNode head)
	{
//		Approach I: Using hashset for mapping of the array values and then removing them from the list.
//		            Approach works but we can do better with the time and space complexity by using freq array.
//		-------------------------------------------------------------------------------------------------------
//		HashSet<Integer> hs = new HashSet<>();
//        for(int ele:nums){
//            hs.add(ele);
//        }
//        ListNode temp = null;
//        while(head.next!=null){
//            if(!hs.contains(head.val)){
//                break;
//            }
//            temp = head.next;
//            head.next = null;
//            head = temp;
//        }
//        temp = head.next;
//        ListNode prev = head;
//        while(temp!=null){
//            if(hs.contains(temp.val)){
//                ListNode tmp = temp.next;
//                temp.next = null;
//                prev.next = tmp;
//                temp = tmp;
//            }
//            else{
//                prev = temp;
//                temp = temp.next;
//            }
//        }
//        return head;
//		
//		Approach II: Using frequency array for mapping of the array values and then removing them from the list.
//		--------------------------------------------------------------------------------------------------------
		int mx = -1;
		for(int ele:nums) {
			mx = Math.max(ele, mx);
		}
		boolean[] freq = new boolean[mx+1];
		for(int ele:nums) {
			freq[ele] = true;
		}
		ListNode temp = new ListNode();
		ListNode curr = temp;
		while(head!=null) {
			if(head.val>=mx+1 || freq[head.val]==false) {
				curr.next = head;
				curr = head;
			}
			head = head.next;
		}
		curr.next = null;
		return temp.next;
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
		ListNode n4 = new ListNode(sc.nextInt(),null);
		ListNode n3 = new ListNode(sc.nextInt(),n4);
		ListNode n2 = new ListNode(sc.nextInt(),n3);
		ListNode root = new ListNode(sc.nextInt(),n2);
		sc.close();
		System.out.println("Linked list before modification: ");
		ListNode temp = root;
		while(temp!=null) {
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
		DeleteNodesFromLinkedListPresentInArray Res = new DeleteNodesFromLinkedListPresentInArray();
		temp = Res.modifiedList(arr, root);
		System.out.println("Linked list after modification: ");
		while(temp!=null) {
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
	}
}
