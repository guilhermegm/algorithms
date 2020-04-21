class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }

public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = null;
        ListNode node = null;
        int carry = 0;

        while (l1 != null  || l2 != null) {
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;
            int sum = v1 + v2 + carry;

            carry = sum / 10;

            if (root == null) {
                root = new ListNode(sum % 10);
                node = root;
            } else {
                node.next = new ListNode(sum % 10);
                node = node.next;
            }

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0)
            node.next = new ListNode(carry);

        return root;
    }

    public static void main(String[] args) {
        ListNode two = new ListNode(2);
        ListNode four = new ListNode(4);
        ListNode three = new ListNode(3);
        ListNode five = new ListNode(5);
        ListNode five2 = new ListNode(5);
        ListNode six = new ListNode(6);
        ListNode four2 = new ListNode(4);

        two.next = four;
        four.next = three;
        // five.next = six;
        six.next = four2;

        ListNode list = addTwoNumbers(five, five2);
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }
}
