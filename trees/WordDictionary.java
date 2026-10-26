/*
 Problem: Design Add and Search Words Data Structure (LeetCode 211)
 Link: https://leetcode.com/problems/design-add-and-search-words-data-structure/
 Approach: Trie. addWord inserts letter by letter. search follows the letters,
           and a '.' tries all 26 children with DFS, succeeding if any path works.
 Time: addWord O(L). search O(L) with no dots, up to O(26^L) when all dots.
 Space: O(total letters inserted * 26) for the trie, O(L) recursion stack
*/

public class WordDictionary {
    private static class Node {
        Node[] next = new Node[26];
        boolean end;
    }

    private final Node root = new Node();

    public void addWord(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (cur.next[i] == null) cur.next[i] = new Node();
            cur = cur.next[i];
        }
        cur.end = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int idx, Node node) {
        if (node == null) return false;
        if (idx == word.length()) return node.end;

        char c = word.charAt(idx);

        if (c == '.') {
            for (Node child : node.next) {
                if (child != null && dfs(word, idx + 1, child)) return true;
            }
            return false;
        }

        return dfs(word, idx + 1, node.next[c - 'a']);
    }

    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("bad");
        wd.addWord("dad");
        wd.addWord("mad");
        System.out.println("search pad: " + wd.search("pad"));
        System.out.println("search bad: " + wd.search("bad"));
        System.out.println("search .ad: " + wd.search(".ad"));
        System.out.println("search b..: " + wd.search("b.."));
        System.out.println("search b.: " + wd.search("b."));
    }
}