class Solution {
    public int findMaxSum(int arr[]) {
        // code here
        int n = arr.length;
        int[]dp= new int[n+1];
         dp[0]=arr[0];
         if(n<=0)return 0;
         if(n==1)return arr[0];
        for(int i=1;i<n;i++){
           int pick = arr[i];
           if(i>1)
           pick = arr[i]+dp[i-2];
           
           int notpick = dp[i-1];
           
           dp[i]=Math.max(pick,notpick);
        }
        return dp[n-1];
    }
}