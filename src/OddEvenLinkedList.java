public class OddEvenLinkedList {
    public static ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        ListNode lastOdd = null;
        ListNode lastEven = null;
        ListNode result = null;
        int counter = 2;

        result = new ListNode(head.val);
        lastOdd = result;
        head = head.next;

        while (head != null) {
            if (counter % 2 == 0) {
                if (lastEven == null) {
                    lastOdd.next = new ListNode(head.val);
                    lastEven = lastOdd.next;
                } else {
                    lastEven.next = new ListNode(head.val);
                    lastEven = lastEven.next;
                }
            } else {
                ListNode node = lastOdd.next;
                lastOdd.next = new ListNode(head.val);
                lastOdd = lastOdd.next;
                lastOdd.next = node;
            }

            head = head.next;
            counter++;
        }

        return result;
    }

    public static ListNode oddEvenListSolution(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        ListNode seven = new ListNode(7);

        two.next = one;
        one.next = three;
        three.next = five;
        five.next = six;
        six.next = four;
        four.next = seven;

        ListNode result = oddEvenList(two);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
