class Solution {
    public int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n = val.length;
     int [][]dp = new int[n][capacity+1];
     
     //only item 0 is available
      for(int cap=0;cap<=capacity;cap++)
             if(wt[0]<=cap){
                 dp[0][cap]=(cap/wt[0])*val[0];
             }
         
     //remaining
     for(int i=1;i<n;i++){
         for(int j=0;j<=capacity;j++){
             int take=0;
             int nottake = dp[i-1][j];
             if(wt[i]<=j){
                 take = val[i]+dp[i][j-wt[i]];
             }
             dp[i][j] = Math.max(take,nottake);
         }
     }
     return dp[n-1][capacity];
    
    }
}