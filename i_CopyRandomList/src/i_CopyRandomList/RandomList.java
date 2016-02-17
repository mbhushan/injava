package i_CopyRandomList;

import java.util.HashMap;

public class RandomList {

	class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	};
	
	 public RandomListNode copyRandomList(RandomListNode head) {
	      if (head == null)
			return null;
	 
		RandomListNode p = head;
	 
		// copy every node and insert to list
		while (p != null) {
			RandomListNode copy = new RandomListNode(p.label);
			copy.next = p.next;
			p.next = copy;
			p = copy.next;
		}
	 
		// copy random pointer for each new node
		p = head;
		while (p != null) {
			if (p.random != null)
				p.next.random = p.random.next;
			p = p.next.next;
		}
	 
		// break list to two
		p = head;
		RandomListNode newHead = head.next;
		while (p != null) {
			RandomListNode temp = p.next;
			p.next = temp.next;
			if (temp.next != null)
				temp.next = temp.next.next;
			p = p.next;
		}
	 
		return newHead;
	    }

	public RandomListNode copyRandomList1(RandomListNode head) {

		if (head != null) {
			return null;
		}
		HashMap<RandomListNode, RandomListNode> mp = new HashMap<RandomListNode, RandomListNode>(); // map
																									// <originalNode,
																									// newNode>
		mp.clear();
		RandomListNode res = new RandomListNode(0);
		RandomListNode p = head;
		RandomListNode q = res;

		while (p != null) {
			RandomListNode tmp = new RandomListNode(p.label);
			q.next = tmp;
			mp.put(p, tmp);
			p = p.next;
			q = q.next;
		}
		p = head;
		q = res.next;
		while (p != null) {
			if (p.random == null) {
				q.random = null;
			} else {
				q.random = mp.get(p.random);
			}
			p = p.next;
			q = q.next;
		}
		return res.next;
	}
}
