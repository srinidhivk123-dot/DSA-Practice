import java.util.*;

/*
 Problem: Number of Connected Components in an Undirected Graph (LeetCode 323)
 Link: https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 Approach: Union-Find. Start with every node as its own component (count = n).
           For each edge, find the leaders of both ends. If they differ, join
           them and reduce the count by one. The count left at the end is the
           number of components.
 Time: O(n + E * α(n)), almost O(n + E)
 Space: O(n), the parent array
*/

public class ConnectedComponents {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        int count = n;
        for (int[] e : edges) {
            int a = find(parent, e[0]), b = find(parent, e[1]);
            if (a != b) {
                parent[a] = b;
                count--;
            }
        }
        return count;
    }

    private int find(int[] p, int x) {
        while (p[x] != x) {
            p[x] = p[p[x]];
            x = p[x];
        }
        return x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Enter number of edges: ");
        int m = Integer.parseInt(sc.nextLine().trim());

        int[][] edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            System.out.print("Edge " + (i + 1) + " (a b): ");
            String[] p = sc.nextLine().trim().split("\\s+");
            edges[i][0] = Integer.parseInt(p[0]);
            edges[i][1] = Integer.parseInt(p[1]);
        }

        System.out.println("Connected components: " + new ConnectedComponents().countComponents(n, edges));
    }
}