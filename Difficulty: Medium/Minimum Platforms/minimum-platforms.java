class Solution {
    public int minPlatform(int arr[], int dep[]) {
        //  code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        int count =0;int maxOverlap=0;
        int i=0;int j=0;int n = arr.length;
        while(i<n){
            if(arr[i]<=dep[j]){
                count++;
                maxOverlap = Math.max(maxOverlap,count);
                i++;
            }else if(arr[i]>dep[j]){
                count--;
                j++;
            }
        }
        return maxOverlap;
    }
}
