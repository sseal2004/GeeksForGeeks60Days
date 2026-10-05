class Solution {
    static class Pair {
           int node;
           int weight;

           Pair(int node, int weight) {
               this.node = node;
               this.weight = weight;
           }
       }
       public ArrayList<Integer> shortestPath(int V, int[][] edges) {
             ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

             for(int i = 0; i < V; i++) {  adj.add(new ArrayList<>());}

             // Create adjacency list
             for(int i = 0; i < edges.length; i++) {
                 int u = edges[i][0];
                 int v = edges[i][1];
                 int weight = edges[i][2];

                 adj.get(u).add(new Pair(v, weight));

             }
             // Source = 0
             int[] dist = shortestPath(V, adj, 0);

             ArrayList<Integer> ans = new ArrayList<>();

             for(int i = 0; i < V; i++) {
                 if(dist[i] == Integer.MAX_VALUE)  ans.add(-1); 
                 else  ans.add(dist[i]);
             }

             return ans;
         }

         static void dfs(int node, ArrayList<ArrayList<Pair>> adj, int[] vis, Stack<Integer> st) {
             vis[node] = 1;
             for (Pair edge : adj.get(node)) {
                 int neighbour = edge.node;
                 if (vis[neighbour] == 0) dfs(neighbour, adj, vis, st);
             }
             st.push(node);
         }

        static int[] shortestPath(int V, ArrayList<ArrayList<Pair>> adj, int src) {
                int[] vis = new int[V];
                Stack<Integer> st = new Stack<>();
                for (int i = 0; i < V; i++) {
                    if (vis[i] == 0) dfs(i, adj, vis, st);
                }
                int[] dist = new int[V];
                 Arrays.fill(dist,Integer.MAX_VALUE);

                 dist[src]=0;
                 while(!st.isEmpty()){
                    int node = st.pop();
                    if (dist[node] != Integer.MAX_VALUE) {

                        for(Pair p: adj.get(node)){
                            int neighbour = p.node;
                            int weight = p.weight;
                             if (dist[node] + weight < dist[neighbour]) 
                                dist[neighbour]=dist[node]+weight;
                        }
                    }
                 }
                 return  dist;


            }
}