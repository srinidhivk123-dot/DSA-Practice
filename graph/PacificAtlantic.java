import java.util.*;

/*
 Problem: Pacific Atlantic Water Flow (LeetCode 417)
 Link: https://leetcode.com/problems/pacific-atlantic-water-flow/
 Approach: Reverse the flow. Instead of checking where each cell's water goes,
           start from the ocean borders and move uphill (to neighbors with
           height >= current). Pacific borders are the top row and left column,
           Atlantic borders are the bottom row and right column. A cell reached
           from both oceans can send water to both.
 Time: O(m * n), each cell is visited at most twice
 Space: O(m * n), two visited grids plus recursion stack
*/

public class PacificAtlantic {
    int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] h) {
        int m = h.length, n = h[0].length;
        boolean[][] pac = new boolean[m][n], atl = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(h, pac, i, 0);
            dfs(h, atl, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(h, pac, 0, j);
            dfs(h, atl, m - 1, j);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (pac[i][j] && atl[i][j]) res.add(Arrays.asList(i, j));
        return res;
    }

    private void dfs(int[][] h, boolean[][] seen, int i, int j) {
        seen[i][j] = true;
        for (int[] x : d) {
            int a = i + x[0], b = j + x[1];
            if (a < 0 || b < 0 || a >= h.length || b >= h[0].length || seen[a][b] || h[a][b] < h[i][j]) continue;
            dfs(h, seen, a, b);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows and columns: ");
        String[] rc = sc.nextLine().trim().split("\\s+");
        int m = Integer.parseInt(rc[0]), n = Integer.parseInt(rc[1]);

        int[][] h = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.out.print("Row " + (i + 1) + " heights: ");
            String[] p = sc.nextLine().trim().split("\\s+");
            for (int j = 0; j < n; j++) h[i][j] = Integer.parseInt(p[j]);
        }

        System.out.println("Cells that reach both oceans: " + new PacificAtlantic().pacificAtlantic(h));
    }
}