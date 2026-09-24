class Solution {
    int countConnected(int V, ArrayList<ArrayList<Integer>>edges ) {
        boolean []vis = new boolean[V];
    
         // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        
          // Convert edge list to adjacency list
        for(ArrayList<Integer> list : edges){
            int v = list.get(0);
            int e = list.get(1);
            
            adj.get(v).add(e);
            adj.get(e).add(v);
        }
        
        int count=0;
        for(int i=0;i<V;i++){
            if(!vis[i]){
                bfs(i,vis,adj);
                count++;
            }
        }
        return count;
        
    }
    public void bfs(int node,boolean vis[], ArrayList<ArrayList<Integer>>edges){
        Queue<Integer>q = new LinkedList<>();
        vis[node]=true;
        q.offer(node);
        
            
           while(!q.isEmpty()){
               int temp = q.poll();
               for(int i=0;i<edges.get(temp).size();i++){
                   int neighbour = edges.get(temp).get(i);
                   if(!vis[neighbour]){
                       q.add(neighbour);
                       vis[neighbour]=true;
                   }
               }
           }
        
    }
}