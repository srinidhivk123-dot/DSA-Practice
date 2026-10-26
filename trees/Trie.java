/*
 Problem: Implement Trie (Prefix Tree) (LeetCode 208)
 Link: https://leetcode.com/problems/implement-trie-prefix-tree/
 Approach: Each node holds 26 child links (one per letter) and a flag that
           marks the end of a word. insert walks down creating missing nodes.
           search and startsWith walk down following the letters; search also
           needs the end flag, startsWith does not.
 Time: O(L) per operation, L = length of the word or prefix
 Space: O(total letters inserted * 26) in the worst case
*/

public class Trie {
    private static class Node {
        Node[] next = new Node[26];
        boolean end;
    }

    private final Node root = new Node();

    public void insert(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (cur.next[i] == null) cur.next[i] = new Node();
            cur = cur.next[i];
        }
        cur.end = true;
    }

    public boolean search(String word) {
        Node node = find(word);
        return node != null && node.end;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    private Node find(String s) {
        Node cur = root;
        for (char c : s.toCharArray()) {
            int i = c - 'a';
            if (cur.next[i] == null) return null;
            cur = cur.next[i];
        }
        return cur;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println("search apple: " + trie.search("apple"));
        System.out.println("search app: " + trie.search("app"));
        System.out.println("startsWith app: " + trie.startsWith("app"));
        trie.insert("app");
        System.out.println("search app: " + trie.search("app"));
    }
}