package i_MergeKLists;


import java.util.ArrayList;
import java.util.Random;


class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class MergeLists {
	
	private static ListNode [] heads = new ListNode[3];
	
	public static void main(String[] args) {
		
		for (int i=30; i>=0; i-=10) {
			int min = i;
			int max = i+10;
			Random rand= new Random();
			for (int j=0; j<3; j++) {
				int k = rand.nextInt(max-min) + min;
				insertFront(k, j);
			}
		}
		
		for (int i=0; i<heads.length; i++) {
			ListNode node = heads[i];
			while (node != null) {
				System.out.print(node.val + "->");
				node = node.next;
			}
			System.out.println("null");
		}
		
		ArrayList<ListNode> A = new ArrayList<ListNode>();
		for (int i=0; i<heads.length; i++) {
			A.add(heads[i]);
		}
		
		ListNode root = mergeKLists(A);
		System.out.println("printing the merge list");
		while (root != null) {
			System.out.print(root.val + "->");
			root = root.next;
		}
		System.out.println("null");
		
	}

	public static ListNode mergeKLists(ArrayList<ListNode> a) {
		ListNode head = new ListNode(0);
		
		if (a.size() == 0) {
			return null;
		}
		
		head.next = a.get(0);
		ListNode p;
		ListNode q;
		
		int size = a.size();
		for (int i=1; i<size; i++) {
			p = head;
			q = a.get(i);
			
			while (q != null) {
				System.out.println("inside while");
				if (p.next == null) {
					p.next = q;
					break;
				}
				if (p.next.val < q.val) {
					p = p.next;
				} else {
					ListNode temp = p.next;
                    p.next = q;
                    q = q.next;
                    p.next.next = temp;
                    p = p.next;
				}
			}
		}
		
		return head.next;
	}
	
	public static void insertFront(int val, int index) {
		ListNode node = new ListNode(val);
		node.next = heads[index];
		heads[index] = node;
	}
}
