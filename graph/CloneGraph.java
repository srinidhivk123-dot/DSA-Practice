import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors = new ArrayList<>();
    public Node(int val) { this.val = val; }
}

/*
 Problem: Clone Graph (LeetCode 133)
 Link: https://leetcode.com/problems/clone-graph/
 Approach: DFS with a HashMap from original node to its copy, so each node
           is cloned once and cycles don't loop forever.
 Time: O(V + E)
 Space: O(V)
*/

public class CloneGraph {
    Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node n) {
        if (n == null) return null;
        if (map.containsKey(n)) return map.get(n);
        Node c = new Node(n.val);
        map.put(n, c);
        for (Node x : n.neighbors) c.neighbors.add(cloneGraph(x));
        return c;
    }

    static void fill(Node n, Map<Integer, List<Integer>> m) {
        if (n == null || m.containsKey(n.val)) return;
        List<Integer> l = new ArrayList<>();
        m.put(n.val, l);
        for (Node x : n.neighbors) { l.add(x.val); fill(x, m); }
    }

    static void print(Node n) {
        Map<Integer, List<Integer>> m = new TreeMap<>();
        fill(n, m);
        System.out.println(m.values());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = Integer.parseInt(sc.nextLine().trim());

        Node[] a = new Node[n + 1];
        for (int i = 1; i <= n; i++) a[i] = new Node(i);
        for (int i = 1; i <= n; i++) {
            System.out.print("Neighbors of node " + i + " (empty if none): ");
            String s = sc.nextLine().trim();
            if (!s.isEmpty())
                for (String p : s.split("\\s+")) a[i].neighbors.add(a[Integer.parseInt(p)]);
        }

        Node orig = n > 0 ? a[1] : null;
        Node copy = new CloneGraph().cloneGraph(orig);
        System.out.print("Original: ");
        print(orig);
        System.out.print("Clone:    ");
        print(copy);
        System.out.println("Different objects: " + (orig != copy));
    }
}