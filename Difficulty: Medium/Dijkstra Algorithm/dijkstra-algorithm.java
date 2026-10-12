class Solution {
    public ArrayList<Integer> dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<Integer>ans = new ArrayList<>();
              ArrayList<ArrayList<int[]>>adj = new ArrayList<>();
              for(int i=0;i<V;i++)adj.add(new ArrayList<>());

              for(int []edge : edges){
                  int u=edge[0];
                  int v=edge[1];
                  int wt=edge[2];
                  adj.get(u).add(new int[]{v,wt});
                  adj.get(v).add(new int[]{u,wt});
              }
              PriorityQueue<int[]>pq= new PriorityQueue<>((a,b)->Integer.compare(a[0], b[0]));//Min heap{weight,node}

              int[]dist = new int [V];
              Arrays.fill(dist,(int)1e9); 
              dist[src]=0;
              pq.add(new int[]{0,src});

              while(!pq.isEmpty()){
                  int weight = pq.peek()[0];
                  int node = pq.peek()[1];
                  pq.remove();

                  for(int i=0;i<adj.get(node).size();i++){
                      int edgeWeight = adj.get(node).get(i)[1];
                      int adjNode = adj.get(node).get(i)[0];

                      if(weight+edgeWeight<dist[adjNode]){
                          dist[adjNode]=edgeWeight+weight;//update with the shortest weight
                          pq.add(new int[]{dist[adjNode],adjNode});
                      }
                  }
              }

              for(int i=0;i<V;i++) ans.add(dist[i]);//total shortest weight

              return ans;
    }
}