class Solution {
    int upperBound(int[] arr, int target) {
        // code here
        int n = arr.length;
        int s=0;int h= n-1;int ans=n;
        while(s<=h){
            int m = (s+h)/2;
            if(arr[m]>target) {ans = m;h= m-1;}
            else s=m+1;
        }
        return ans;
    }
}
