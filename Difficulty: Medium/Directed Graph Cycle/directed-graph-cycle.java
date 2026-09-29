class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        Queue<Integer>q= new LinkedList<>();
        int []indegree =  new int[V];
        Arrays.fill(indegree,0);
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        
        for(int[]arr : edges){
            int u =arr[0];int v=arr[1];
            adj.get(u).add(v);
            indegree[v]++;
        }
        for(int i=0;i<V;i++){
            if(indegree[i]==0) q.add(i);
        }
        int cnt=0;
        ArrayList<Integer>ans = new ArrayList<Integer>();
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            cnt++;
        for(int e : adj.get(node)){
            indegree[e]--;
            if(indegree[e]==0)q.add(e);
         }
        }
        return cnt != V? true:false;
    }
}