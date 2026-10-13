class Solution {
    public int spanningTree(int V, int[][] edges) {
ArrayList<ArrayList<int[]>>adj = new ArrayList<>();
     for(int i=0;i<V;i++)adj.add(new ArrayList<>());
     for(int []it:edges){
         int u=it[0];
         int v=it[1];
         int w=it[2];
         adj.get(u).add(new int []{v,w});
         adj.get(v).add(new int []{u,w});

     }
     PriorityQueue<int[]>pq =  new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
     boolean[]vis = new boolean [V];
     pq.add(new int[]{0,0});
     int sum=0;
     while(!pq.isEmpty()){
         int wt=pq.peek()[0];
         int node=pq.peek()[1];
         pq.poll();
         if(vis[node]) continue;//if already visited then to skip cycle;
         vis[node]=true;
         sum+=wt;
         for(int []it:adj.get(node)){
             int adjNode = it[0];
             int edgesWeight = it[1];
             if(!vis[adjNode]) pq.add(new int[]{edgesWeight,adjNode});
         }
     }

     return sum;        
    }
}
