import java.util.*;

/*
 Problem: Word Search II (LeetCode 212)
 Link: https://leetcode.com/problems/word-search-ii/
 Approach: Run a normal Word Search DFS for each word (duplicates removed
           with a set). Mark visited cells '#' and restore them when backtracking.
 Time: O(W * m * n * 3^L), W = number of words, L = word length
 Space: O(L), recursion stack
*/

public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for (String w : new HashSet<>(Arrays.asList(words))) {
            if (exist(board, w)) res.add(w);
        }
        return res;
    }

    private boolean exist(char[][] b, String w) {
        for (int i = 0; i < b.length; i++)
            for (int j = 0; j < b[0].length; j++)
                if (dfs(b, i, j, w, 0)) return true;
        return false;
    }

    private boolean dfs(char[][] b, int i, int j, String w, int k) {
        if (k == w.length()) return true;
        if (i < 0 || j < 0 || i >= b.length || j >= b[0].length || b[i][j] != w.charAt(k)) return false;
        char c = b[i][j];
        b[i][j] = '#';
        boolean f = dfs(b, i + 1, j, w, k + 1) || dfs(b, i - 1, j, w, k + 1)
                || dfs(b, i, j + 1, w, k + 1) || dfs(b, i, j - 1, w, k + 1);
        b[i][j] = c;
        return f;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'o', 'a', 'a', 'n'},
            {'e', 't', 'a', 'e'},
            {'i', 'h', 'k', 'r'},
            {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println("Found: " + new WordSearchII().findWords(board, words));
    }
}