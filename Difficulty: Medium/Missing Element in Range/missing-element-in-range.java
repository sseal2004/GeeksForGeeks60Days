class Solution {
    public ArrayList<Integer> missingRange(int[] arr, int low, int high) {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        int idx=0;
        for (int i = low; i <= high; i++) {
         // skip elements smaller than current i
        while (idx < arr.length && arr[idx] < i) {
                idx++;
            }

            if (idx < arr.length && arr[idx] == i) {
                idx++;   
            } else {
                list.add(i);
            }
        }
        return list;
    }
}
