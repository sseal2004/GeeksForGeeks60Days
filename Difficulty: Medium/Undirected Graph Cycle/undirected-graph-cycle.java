class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        for(int[]e:edges){
            int u=e[0];
            int v=e[1];
            
            adj.get(v).add(u);
            adj.get(u).add(v);
        }
        boolean []vis = new boolean [V];
        
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(bfs(i,adj,vis)==true)return true;
            }
        }
        return false;

        
        
    }
    boolean bfs(int start,ArrayList<ArrayList<Integer>>adj,boolean []vis){
        Queue<int[]>q= new LinkedList<>();
        
        
        q.add(new int[]{start,-1});
        vis[start]=true;
        
        while(!q.isEmpty()){
            int temp[] = q.poll();
            int child = temp[0]; int parent = temp[1];
            for(int neighbour : adj.get(child)){
                if(!vis[neighbour]){
                    vis[neighbour]=true;
                    q.add(new int[]{neighbour,child});
                }
                else if(neighbour != parent) return true;
                
            }
        }
        return false;
        
    }
    
}