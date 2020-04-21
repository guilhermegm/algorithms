public class IntersectionOfTwoLinkedLists {
    public static ListNode getIntersectionNodeBruteForce(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        while (headA != null) {
            ListNode nodeA = headA;
            ListNode nodeB = headB;

            while (nodeB != null && nodeA != nodeB) nodeB = nodeB.next;
            if (nodeB != null) {
                ListNode result = nodeA;
                while (nodeA != null && nodeA == nodeB) {
                    nodeA = nodeA.next;
                    nodeB = nodeB.next;
                }

                if (nodeA == null && nodeB == null) {
                    return result;
                }
            }

            headA = headA.next;
        }

        return null;
    }

    public static ListNode getIntersectionNodeTwoPointers(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode pointerA = headA;
        ListNode pointerB = headB;

        while (pointerA != pointerB) {
            if (pointerA == null)
                pointerA = headB;
            else
                pointerA = pointerA.next;

            if (pointerB == null)
                pointerB = headA;
            else
                pointerB = pointerB.next;
        }

        return pointerA;
    }

    public static void main(String[] args) {
        ListNode zero = new ListNode(0);
        ListNode one = new ListNode(1);
        ListNode one2 = new ListNode(1);
        ListNode four = new ListNode(4);
        ListNode four2 = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode five2 = new ListNode(5);
        ListNode eight = new ListNode(8);

        four.next = one;
        one.next = eight;
        eight.next = four2;
        four2.next = five;

        five2.next = zero;
        zero.next = one2;
        one2.next = eight;

        ListNode root = getIntersectionNodeTwoPointers(four, five2);
        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }
}
