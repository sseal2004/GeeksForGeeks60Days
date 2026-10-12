
import java.util.*;

class Solution {
    public ArrayList<Integer> bellmanFord(int V, int[][] edges, int src) {

        ArrayList<Integer> ans = new ArrayList<>();
        int[] dist = new int[V];

        Arrays.fill(dist, (int) 1e8);
        dist[src] = 0;

        // Relax all edges V - 1 times
        for (int i = 0; i < V - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                if (dist[u] != (int) 1e8 &&
                    dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        // Check for a negative-weight cycle
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (dist[u] != (int) 1e8 &&
                dist[u] + w < dist[v]) {
                ans.add(-1);
                return ans;
            }
        }

        for (int i = 0; i < V; i++) {
            ans.add(dist[i]);
        }

        return ans;
    }
}