package list_FlattenLinkedList;

public class FlattenList {

	public static void main(String[] args) {
		
	}
	
	public void flattenList(ListNode node) {
		
		if (node == null) {
			return;
		}
		
		if (node.down != null) {
			node.down.right = node.right;
			node.right = node.down;
			node.down = null;
		}
	}
}

class ListNode {
	
	int value;
	ListNode right;
	ListNode down;
	
	public ListNode(int value) {
		this.value = value;
	}
}
