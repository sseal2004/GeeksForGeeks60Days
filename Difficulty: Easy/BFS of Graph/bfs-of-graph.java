class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code
        int V = adj.size();
        
        Queue<Integer> q = new LinkedList<>();
        boolean []visited = new boolean [V];
        ArrayList<Integer>ansBFS = new ArrayList<>();
        
        visited[0]=true;//starting Node
        q.add(0);
        
        while(!q.isEmpty()){
            int node = q.poll(); //Integer node = q.poll()
            ansBFS.add(node);
            
            //Get all the adjacent Vertex of Dequed v
            //If a adjacent hasnot been yet visted then make it false
            //visited and enqueued it
            
            
            for(int i=0;i<adj.get(node).size();i++)  // for(Integer it : adj.get(node))
            {
                if(!visited[adj.get(node).get(i)]){// if(visited[it]==false)
                    q.add(adj.get(node).get(i));   // q.add(it)
                    visited[adj.get(node).get(i)]=true;//visited[it]=true
                }
            }
        }
        
        
        return ansBFS;
        
    }
}

