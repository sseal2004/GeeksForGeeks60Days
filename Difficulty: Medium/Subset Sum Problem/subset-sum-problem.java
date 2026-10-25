class Solution {
    static boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        boolean dp[][] = new boolean [n][sum+1];
        for(int i=0;i<n;i++)dp[i][0]=true;
        if(arr[0]<=sum) dp[0][arr[0]]=true;

        for(int i=1;i<n;i++){
            for(int t=1;t<=sum;t++ ){
               boolean nottake=dp[i-1][t];
               boolean take =false;
                if(arr[i]<=t) take=dp[i-1][t-arr[i]];
                
                dp[i][t]=take||nottake;
            }
        }
        return dp[n-1][sum];
    }
}