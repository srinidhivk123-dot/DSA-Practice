import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

/*
 Problem: Remove Nth Node From End of List (LeetCode 19)
 Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 Approach: Two pointers with a dummy head. Move fast n + 1 steps ahead, then
           move slow and fast together until fast reaches null. Now slow sits
           just before the node to remove, so skip it with slow.next = slow.next.next.
 Time: O(L), one pass, L = length of the list
 Space: O(1)
*/

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;

        for (int i = 0; i <= n; i++) fast = fast.next;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }

    static ListNode read(Scanner sc, String prompt) {
        System.out.print(prompt);
        String line = sc.nextLine().trim();
        ListNode dummy = new ListNode(0), t = dummy;
        if (!line.isEmpty())
            for (String s : line.split("\\s+")) {
                t.next = new ListNode(Integer.parseInt(s));
                t = t.next;
            }
        return dummy.next;
    }

    static void print(ListNode h) {
        List<Integer> l = new ArrayList<>();
        for (; h != null; h = h.next) l.add(h.val);
        System.out.println(l);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode head = read(sc, "Enter list values: ");
        System.out.print("Enter n (position from the end to remove): ");
        int n = Integer.parseInt(sc.nextLine().trim());

        System.out.print("Result: ");
        print(new RemoveNthFromEnd().removeNthFromEnd(head, n));
    }
}