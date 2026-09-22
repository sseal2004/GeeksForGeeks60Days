class Solution {
    public int findPages(int[] arr, int k) {
        if(k>arr.length)return -1;
        long max= Integer.MIN_VALUE;long sum=0;
        for(int n:arr){
            max=Math.max(max,n);sum+=n;
        
        }
        long s=max;long e=sum;
        while(s<=e){
            long m = s+(e-s)/2;
            if(func(arr,m,k)) e=m-1; 
            else s=m+1;
            
        }
        return (int)s;
        
    }
   boolean func(int[] arr,long pages,int k){
        int stud = 1;
        long pageAllot=0;
        for(int n: arr){
            if((long)n + pageAllot <= pages){
                pageAllot += n;
            }else{
                stud++;
                pageAllot=n;//reset
            }
        }
        return (stud<=k);
    }
}