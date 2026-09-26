class Solution {
    public int countDistinctIslands(char[][] grid) {
        // code here
        int n=grid.length;int m = grid[0].length;
        HashSet<ArrayList<String>>set= new HashSet<>();
        boolean [][]vis = new boolean [n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='L' && vis[i][j]==false){
                    ArrayList<String>shape =  new ArrayList<>();
                    dfs(i,j,i,j,grid,vis,shape);
                    set.add(shape);
                }
            }
        }
        return set.size();
        
    }
    public void dfs(int r,int c,int baseRow,int baseCol,char[][]grid,boolean[][]vis,ArrayList<String>shape)
    {
        vis[r][c]=true;
        shape.add((r-baseRow) + ","+(c-baseCol));
        int[][]dir={{0,1},{1,0},{-1,0},{0,-1}};
        
        for(int[]d: dir){
            int nrow = r+d[0];
            int ncol= c+d[1];
            
            if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && grid[nrow][ncol]=='L' && vis[nrow][ncol]==false)
                dfs(nrow,ncol,baseRow,baseCol,grid,vis,shape);
        }
        
    }
}