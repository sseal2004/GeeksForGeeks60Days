class Solution {
    public int aggressiveCows(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        long max=Integer.MIN_VALUE;
        long min=Integer.MAX_VALUE;
        for(int n : arr){
            min = Math.min(min,n);
            max=Math.max(max,n);
        }
        long s= 1;long h=max-min;
        while(s<=h){
            long m = s + (h-s)/2;
            if(isPossible(arr,m,k)) s=m+1;
            else h=m-1;
        }
        return (int)h;
        
    }
    boolean isPossible(int[]arr,long dist,int k){
        int cow=1;long prevCow = arr[0];
        for(int i=1;i<arr.length;i++){
            if((long)arr[i]-prevCow>=dist){
                cow++;
                prevCow=arr[i];
                
            }  
        }
        return (cow>=k);
        
    }
    
}