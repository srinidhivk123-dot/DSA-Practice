import java.util.*;

/*
 Problem: Number of Islands (LeetCode 200)
 Link: https://leetcode.com/problems/number-of-islands/
 Approach: Scan the grid. When a '1' is found, count one island and sink the
           whole island with DFS (turn every connected '1' into '0') so it is
           never counted again.
 Time: O(m * n), each cell is visited a constant number of times
 Space: O(m * n), recursion stack in the worst case (all land)
*/

public class NumberOfIslands {
    public int numIslands(char[][] g) {
        int count = 0;
        for (int i = 0; i < g.length; i++)
            for (int j = 0; j < g[0].length; j++)
                if (g[i][j] == '1') {
                    count++;
                    sink(g, i, j);
                }
        return count;
    }

    private void sink(char[][] g, int i, int j) {
        if (i < 0 || j < 0 || i >= g.length || j >= g[0].length || g[i][j] != '1') return;
        g[i][j] = '0';
        sink(g, i + 1, j);
        sink(g, i - 1, j);
        sink(g, i, j + 1);
        sink(g, i, j - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows and columns: ");
        String[] rc = sc.nextLine().trim().split("\\s+");
        int m = Integer.parseInt(rc[0]), n = Integer.parseInt(rc[1]);

        char[][] g = new char[m][];
        for (int i = 0; i < m; i++) {
            System.out.print("Row " + (i + 1) + " (1 = land, 0 = water): ");
            g[i] = sc.nextLine().replaceAll("\\s", "").toCharArray();
        }

        System.out.println("Number of islands: " + new NumberOfIslands().numIslands(g));
    }
}
