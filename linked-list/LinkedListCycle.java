import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

/*
 Problem: Linked List Cycle (LeetCode 141)
 Link: https://leetcode.com/problems/linked-list-cycle/
 Approach: Floyd's two pointers. slow moves one step, fast moves two steps.
           If there is a cycle, fast eventually catches slow inside it.
           If there is no cycle, fast reaches the end (null).
 Time: O(n)
 Space: O(1), only two pointers
*/

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter list values (empty for none): ");
        String line = sc.nextLine().trim();
        System.out.print("Enter pos (index the tail connects to, -1 for no cycle): ");
        int pos = Integer.parseInt(sc.nextLine().trim());

        ListNode head = null;
        if (!line.isEmpty()) {
            String[] p = line.split("\\s+");
            ListNode[] nodes = new ListNode[p.length];
            for (int i = 0; i < p.length; i++) {
                nodes[i] = new ListNode(Integer.parseInt(p[i]));
                if (i > 0) nodes[i - 1].next = nodes[i];
            }
            head = nodes[0];
            if (pos >= 0 && pos < p.length) nodes[p.length - 1].next = nodes[pos];
        }

        System.out.println("Has cycle: " + new LinkedListCycle().hasCycle(head));
    }
}