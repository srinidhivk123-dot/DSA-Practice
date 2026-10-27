import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

/*
 Problem: Merge Two Sorted Lists (LeetCode 21)
 Link: https://leetcode.com/problems/merge-two-sorted-lists/
 Approach: Use a dummy head and a tail pointer. Compare the front nodes of both
           lists, attach the smaller one to the tail, and move that list forward.
           When one list runs out, attach the rest of the other list.
 Time: O(n + m), each node is visited once
 Space: O(1), existing nodes are relinked, no new nodes are created
*/

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0), tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = list1 != null ? list1 : list2;
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
        ListNode a = read(sc, "Enter first sorted list (empty for none): ");
        ListNode b = read(sc, "Enter second sorted list (empty for none): ");
        System.out.print("Merged: ");
        print(new MergeTwoSortedLists().mergeTwoLists(a, b));
    }
}