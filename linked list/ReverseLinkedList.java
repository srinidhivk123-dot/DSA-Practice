import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

/*
 Problem: Reverse Linked List (LeetCode 206)
 Link: https://leetcode.com/problems/reverse-linked-list/
 Approach: Walk through the list with three pointers. For each node, save the
           next node, point the current node backwards to prev, then move
           prev and current one step forward. When current becomes null,
           prev is the new head.
 Time: O(n), each node is visited once
 Space: O(1), only pointers are used
*/

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    static ListNode build(int[] a) {
        ListNode dummy = new ListNode(0), t = dummy;
        for (int x : a) {
            t.next = new ListNode(x);
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
        System.out.print("Enter list values (empty for none): ");
        String line = sc.nextLine().trim();

        int[] a = new int[0];
        if (!line.isEmpty()) {
            String[] p = line.split("\\s+");
            a = new int[p.length];
            for (int i = 0; i < p.length; i++) a[i] = Integer.parseInt(p[i]);
        }

        ListNode head = build(a);
        System.out.print("Original: ");
        print(head);
        System.out.print("Reversed: ");
        print(new ReverseLinkedList().reverseList(head));
    }
}
