import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null, cur = slow.next;
        slow.next = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        ListNode first = head;
        while (prev != null) {
            ListNode t1 = first.next, t2 = prev.next;
            first.next = prev;
            prev.next = t1;
            first = t1;
            prev = t2;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter list values (empty for none): ");
        String line = sc.nextLine().trim();
        ListNode dummy = new ListNode(0), t = dummy;
        if (!line.isEmpty())
            for (String s : line.split("\\s+")) t = t.next = new ListNode(Integer.parseInt(s));
        new ReorderList().reorderList(dummy.next);
        List<Integer> out = new ArrayList<>();
        for (ListNode h = dummy.next; h != null; h = h.next) out.add(h.val);
        System.out.println("Reordered: " + out);
    }
}