class Solution {
    int minCost(int[] height) {
        // code here
        int n = height.length;
        int []dp = new int[n];
        dp[0]=0;
        for(int i=1;i<n;i++){
            int left = dp[i-1]+Math.abs(height[i-1]-height[i]);
            int right = Integer.MAX_VALUE;
            if(i>1)
            right = dp[i-2]+Math.abs(height[i-2]-height[i]);
            
            dp[i] = Math.min(left,right );
        }
        return dp[n-1];
    }
}