class Solution {
    public int cutRod(int[] price) {
        // code here
     int n = price.length;  
      int[][]dp= new int[n][n+1]; 
      for(int cap=0;cap<=n;cap++){
        dp[0][cap] = cap * price[0];
      }
       for(int money=1;money<n;money++){
           int rodLength= money+1;
         for(int cap=0;cap<=n;cap++){
            int take=0;
            int nottake=dp[money-1][cap];
            if(rodLength<=cap){
                take=price[money]+dp[money][cap-rodLength];
            }
            dp[money][cap]=Math.max(take,nottake);
         }

      
      }
      return dp[n-1][n];
      

    }
}