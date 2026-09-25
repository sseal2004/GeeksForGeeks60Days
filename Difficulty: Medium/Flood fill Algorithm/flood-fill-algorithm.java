class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // code here
        int original = image[sr][sc];
        if(original == newColor )return image;
        bfs(sr,sc,original,image,newColor);
        return image;
        
    }
    void bfs(int r,int c,int original,int [][]image,int color){
        Queue<int[]>q= new LinkedList<>();
        if(r<0||c<0||r>=image.length||c>=image[0].length||image[r][c]!=original)return ;
        
        q.offer(new int[]{r,c});
        image[r][c]= color;
        int[][] directions = {
                   {-1, 0},  // up
                   {1, 0},   // down
                   {0, -1},  // left
                   {0, 1}    // right
               };
        
        while(!q.isEmpty()){
            int[] temp = q.poll();
            int row = temp[0];
            int col = temp[1];
            
            for(int[]dir : directions){
                int nr = row + dir[0];
                int nc = col + dir[1];
                if(nr >= 0 && nc >= 0 && nr < image.length &&nc < image[0].length &&
                image[nr][nc] == original) {

                    image[nr][nc] = color;
                    q.offer(new int[]{nr, nc});
                 }
            }
            
        }
    }
}