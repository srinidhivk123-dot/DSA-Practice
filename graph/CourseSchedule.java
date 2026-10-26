import java.util.*;

/*
 Problem: Course Schedule (LeetCode 207)
 Link: https://leetcode.com/problems/course-schedule/
 Approach: Topological sort (Kahn's BFS). Count how many prerequisites each
           course has (indegree). Start with courses that have none, finish them,
           and reduce the count of the courses that depend on them. If every
           course gets finished, there is no cycle, so return true.
 Time: O(V + E)
 Space: O(V + E)
*/

public class CourseSchedule {
    public boolean canFinish(int n, int[][] pre) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        int[] indeg = new int[n];
        for (int[] p : pre) {
            g.get(p[1]).add(p[0]);
            indeg[p[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) if (indeg[i] == 0) q.add(i);

        int done = 0;
        while (!q.isEmpty()) {
            int c = q.poll();
            done++;
            for (int next : g.get(c)) if (--indeg[next] == 0) q.add(next);
        }
        return done == n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of courses: ");
        int n = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Enter number of prerequisites: ");
        int m = Integer.parseInt(sc.nextLine().trim());

        int[][] pre = new int[m][2];
        for (int i = 0; i < m; i++) {
            System.out.print("Prerequisite " + (i + 1) + " (a b means take b before a): ");
            String[] p = sc.nextLine().trim().split("\\s+");
            pre[i][0] = Integer.parseInt(p[0]);
            pre[i][1] = Integer.parseInt(p[1]);
        }

        System.out.println("Can finish: " + new CourseSchedule().canFinish(n, pre));
    }
}