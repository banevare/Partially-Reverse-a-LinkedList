class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {							// reverses a linkedlist between two specified nodes
		if (head == null || left >= right) return head;
		int length = 0;
		ListNode pLeft = head;
		for(ListNode p = head; p != null; p = p.next){
			length++;
			if(length == left){
				pLeft = p;
				break;
			}
		}
		while(left < right){
			int position = left;
			for(ListNode p = pLeft.next; p != null; p = p.next){
				position++;
				if(position == right){
					int temp = p.val;
					p.val = pLeft.val;
					pLeft.val = temp;																// stores our second node value
					break;
				}
			}
			pLeft = pLeft.next;
			left++;
			right--;
		}
		return head;
	}
	public class ListNode {																			// Definition for singly-linked list.
		int val;
		ListNode next = null;
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode prev) { this.val = val; prev.next = this; }
	}

	// ----------- TESTING ------------
	public ListNode makeList0(){																	// ListNode = [] 
		return null;
	}
	public ListNode makeList1(){																	// ListNode = [1]
		return new ListNode(1);
	}
	public ListNode makeList6(){																	// ListNode = [1 2 3 4 5 6] 
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2,a);
		ListNode c = new ListNode(3,b);
		ListNode d = new ListNode(4,c);
		ListNode e = new ListNode(5,d);
		ListNode f = new ListNode(6,e);
		return a;
	}
	public String print(final ListNode head){														// printing method of our singly-linked list
		String s = null;
		ListNode p = head;
		while(p != null){
			if( s == null) s = "" + p.val; else s += " " + p.val;
			p = p.next;
		}
		return s == null ? "" : s;
	}
	public static void test0(int left, int right,String ta){										// empty ListNode test
		ReverseBetween s = new ReverseBetween();
		ListNode head = s.makeList0();
		String tb = "";
		String rb = s.print(head);
		assert(tb.equals(rb));

		ListNode r = s.reverseBetween(head,left,right);
		String ra = s.print(r);
		assert(ta.equals(ra));
	}
	public static void test1(int left, int right,String ta){										// empty ListNode test
		ReverseBetween s = new ReverseBetween();
		ListNode head = s.makeList1();
		String tb = "1";
		String rb = s.print(head);
		assert(tb.equals(rb));

		ListNode r = s.reverseBetween(head,left,right);
		String ra = s.print(r);
		assert(ta.equals(ra));
	}
	public static void test6(int left, int right,String ta){										// 6 element ListNode test
		ReverseBetween s = new ReverseBetween();
		ListNode head = s.makeList6();
		String tb = "1 2 3 4 5 6";
		String rb = s.print(head);
		assert(tb.equals(rb));

		ListNode r = s.reverseBetween(head,left,right);
		String ra = s.print(r);
		assert(ta.equals(ra));
	}
	public static void main(String[] args){															// main test for singly-linked list
		test0(2,4,"");
		test1(2,4,"1");
		test6(2,6,"1 6 5 4 3 2");
		test6(3,6,"1 2 6 5 4 3");
		test6(1,6,"6 5 4 3 2 1");
	}
}
