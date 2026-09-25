class Solution {
    public int countIslands(char[][] grid) {
        // Code here
        int count =0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='L') {
                    dfs(i,j,grid);
                     count++;

                }
            }
        }
        return count;
        
    }
    public void dfs(int r,int c,char[][]mat){
        if( r<0|| c<0||r>=mat.length||c>=mat[0].length||mat[r][c]=='W') return ;
        mat[r][c]='W';
        //direction
        dfs(r-1,c,mat);
        dfs(r+1,c,mat);
        dfs(r,c-1,mat);
        dfs(r,c+1,mat);
        
        // 4 diagonal directions
        dfs(r - 1, c - 1, mat); 
        dfs(r - 1, c + 1, mat); 
        dfs(r + 1, c - 1, mat); 
        dfs(r + 1, c + 1, mat); 
    }
}