class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        Stack<Integer>st = new Stack<>();
        int[]vis=new int[V];
        for(int []arr : edges){
            int u=arr[0];int v=arr[1];
            
            adj.get(u).add(v);
        }
        
        
        Arrays.fill(vis,0);
        for(int i=0;i<V;i++){
            if(vis[i]==0) dfs(i,vis,st,adj);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!st.isEmpty()){
    
            ans.add(st.pop());
        }
        return ans;
    }
    
    public static void dfs(int node,int[]vis,Stack<Integer>st,ArrayList<ArrayList<Integer>>adj){
        vis[node]=1;
        for(int element : adj.get(node)){
            if(vis[element]==0){
                dfs(element,vis,st,adj);
            }
        }
        st.push(node);
        
    }
    
}