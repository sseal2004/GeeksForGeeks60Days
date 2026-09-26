
class Solution {
    
    public boolean isBipartite(int V, int[][] edges) {
    
    // Code here
        ArrayList<ArrayList<Integer>>adj =  new ArrayList<>();
        int [] visColor = new int[V];
        Arrays.fill(visColor,-1);
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        for(int[] e : edges){
            int u=e[0];
            int v=e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for(int i=0;i<V;i++){
                if(visColor[i]==-1){
                    if(bfs(i, V, adj, visColor)==false)return false;
                }
        }
        return true;
    }


    boolean bfs(int start,int V,ArrayList<ArrayList<Integer>>adj,int color[]){
        Queue<Integer>q =  new LinkedList<>();
        q.add(start);
        color[start]=0;
        while(!q.isEmpty()){
            int temp = q.poll();
            for(int it: adj.get(temp)){
                    if(color[it]==-1){
                        color[it] = 1-color[temp];
                        q.add(it);
                    }
                    else if(color[it]==color[temp]) return false; 
            }
        }

        return true;
    }
}