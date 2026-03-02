class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        // code here
        int n = arr.length;
        int[] lMax = new int[n];
        int[] rMax = new int[n];
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++){
            if(i % k == 0){
            // new window started
                lMax[i] = arr[i];
            }
            else{
                lMax[i] = Math.max(lMax[i - 1], arr[i]);
            }
        }
        for(int i = n - 1 ; i >= 0 ; i--){
            if(i == n - 1 || (i + 1) % k == 0){
            // here the new window started 
                rMax[i] = arr[i];
            }
            else{
                rMax[i] = Math.max(rMax[i + 1], arr[i]);
            }
        }
        for(int i = 0 ; i <= n - k ; i++) {
            //max from left n righttt
            ans.add(Math.max(rMax[i], lMax[i + k - 1]));
        }
        return ans;
    }
}