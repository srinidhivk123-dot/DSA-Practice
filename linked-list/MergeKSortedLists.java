import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

/*
 Problem: Merge k Sorted Lists (LeetCode 23)
 Link: https://leetcode.com/problems/merge-k-sorted-lists/
 Approach: Min-heap. Put the head of every list in the heap. Repeatedly take
           the smallest node, attach it to the result, and push that node's
           next node into the heap. The heap never holds more than k nodes,
           so each step is cheap.
 Time: O(N log k), N = total number of nodes, k = number of lists
 Space: O(k), the heap
*/

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for (ListNode l : lists) if (l != null) pq.add(l);

        ListNode dummy = new ListNode(0), tail = dummy;
        while (!pq.isEmpty()) {
            ListNode n = pq.poll();
            tail.next = n;
            tail = n;
            if (n.next != null) pq.add(n.next);
        }
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
        System.out.print("Enter number of lists: ");
        int k = Integer.parseInt(sc.nextLine().trim());

        ListNode[] lists = new ListNode[k];
        for (int i = 0; i < k; i++)
            lists[i] = read(sc, "List " + (i + 1) + " (sorted, empty for none): ");

        System.out.print("Merged: ");
        print(new MergeKSortedLists().mergeKLists(lists));
    }
}