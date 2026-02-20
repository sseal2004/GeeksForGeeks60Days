class Solution {
    static int inversionCount(int arr[]) {
        int count =0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            int low =0;
            int high = list.size()-1;
            while(low<=high){
                int mid = (low+high)/2;
                if(list.get(mid)<=arr[i])
                low = mid+1;
                else
                high = mid-1;
            }
            count+= (list.size()-low);
            list.add(low,arr[i]);
        }
        return count;
    }
}