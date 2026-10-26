import java.util.*;

/*
 Problem: Longest Consecutive Sequence (LeetCode 128)
 Link: https://leetcode.com/problems/longest-consecutive-sequence/
 Approach: Put all numbers in a HashSet. A number starts a sequence only if
           (number - 1) is not in the set. From each start, keep checking
           number + 1, number + 2, ... and count the length. Keep the best.
 Time: O(n), each number is visited at most twice
 Space: O(n), the set
*/

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);

        int best = 0;
        for (int x : set) {
            if (!set.contains(x - 1)) {
                int cur = x, len = 1;
                while (set.contains(cur + 1)) {
                    cur++;
                    len++;
                }
                best = Math.max(best, len);
            }
        }
        return best;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter numbers (empty for none): ");
        String line = sc.nextLine().trim();

        int[] nums = new int[0];
        if (!line.isEmpty()) {
            String[] p = line.split("\\s+");
            nums = new int[p.length];
            for (int i = 0; i < p.length; i++) nums[i] = Integer.parseInt(p[i]);
        }

        System.out.println("Longest consecutive sequence: " + new LongestConsecutive().longestConsecutive(nums));
    }
}
